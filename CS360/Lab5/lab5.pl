/* 
    CS360 Lab 5 - Prolog 
    Manuel Larios
*/

/* PART ONE */
/* ---Problem 1: Prolog Knowledge Base--- */

male(abraham).
male(clancy).
male(herb).
male(homer).
male(bart).

female(mona).
female(jackie).
female(marge).
female(patty).
female(selma).
female(lisa).
female(maggie).
female(ling).

% Parents: Abraham and Mona
parent_of(abraham, herb).
parent_of(abraham, homer).
parent_of(mona, homer).

% Parents: Clancy and Jackie
parent_of(clancy, marge).
parent_of(clancy, patty).
parent_of(clancy, selma).
parent_of(jackie, marge).
parent_of(jackie, patty).
parent_of(jackie, selma).

% Parents: Homer and Marge
parent_of(homer, bart).
parent_of(homer, lisa).
parent_of(homer, maggie).
parent_of(marge, bart).
parent_of(marge, lisa).
parent_of(marge, maggie).

% Parent: Selma
parent_of(selma, ling).



/* ---Problem 2: Formulate Relationships--- */

father_of(Father, Child) :-
    male(Father),
    parent_of(Father, Child).

mother_of(Mother, Child) :-
    female(Mother),
    parent_of(Mother, Child).

grandfather_of(Grandparent, Child) :-
    male(Grandparent),
    parent_of(Grandparent, Parent),
    parent_of(Parent, Child).

grandmother_of(Grandparent, Child) :-
    female(Grandparent),
    parent_of(Grandparent, Parent),
    parent_of(Parent, Child).

sister_of(Sister, Person) :-
    female(Sister),
    setof((Sister, Person), Parent^(parent_of(Parent, Sister), parent_of(Parent, Person), \+ Sister = Person), Sibs),
    member((Sister, Person), Sibs).

aunt_of(Aunt, Person) :-
    female(Aunt),
    sister_of(Aunt, Sibling),
    parent_of(Sibling, Person).

uncle_of(Uncle, Person) :-
    male(Uncle),
    setof((Uncle, Sibling), Parent^(parent_of(Parent, Uncle), parent_of(Parent, Sibling), \+ Uncle = Sibling), Sibs),
    member((Uncle, Sibling), Sibs),
    parent_of(Sibling, Person).



/* ---Problem 3: Queries--- */

% Who are Bart's grandmothers?
barts_grandmothers :- 
    grandmother_of(mona, bart),
    grandmother_of(jackie, bart),
    write("Bart\'s grandmothers are Mona and Jackie").

% List "Person X's" grandchildren
list_persons_grandchildren :- 
    grandfather_of(abraham, bart),
    grandfather_of(abraham, lisa), 
    grandfather_of(abraham, maggie),
    write("Abraham\'s children are Bart, Lisa and Maggie").

% List "Person X's" aunts
persons_aunt :- 
    aunt_of(marge, ling),
    aunt_of(patty, ling),
    write("Ling\'s aunts are Marge and Patty").

% List "Person X's" grandparents
list_persons_grandparents :- 
    grandfather_of(clancy, ling),
    grandmother_of(jackie, ling),
    write("Ling\'s grandparents are Jackie and Clancy").

% List "Person X's" siblings
list_siblings :- 
    sister_of(lisa, bart),
    sister_of(lisa, maggie),
    write("Lisa\'s siblings are Bart and Maggie").




/* PART TWO */
% Prolog Owl Puzzle

owns_owl(Street, Who) :-
    % 1) There are five houses on the street
    Street = [_House1, _House2, _House3, _House4, _House5],

    /*
        THINGS TO NOTE:
        house(C, A, P, D, S)

        C: Color of house
        A: Alma mater of alum
        P: Alum's pet
        D: Alum's drink
        S: Alum's signature dessert
    */

    % 2) The OSU alum lives in the red house.
    member(house(red, osu_alum, _, _, _), Street),

    % 3) The OIT alum owns the dog.
    member(house(_, oit_alum, dog, _, _), Street),

    % 4) Coffee is drunk in the green house.
    member(house(green, _, _, coffee, _), Street),

    % 5) The UofO alum drinks tea.
    member(house(_, uo_alum, _, tea, _), Street),

    % 6) The green house is immediately to the right of the ivory house.
    is_right(house(green, _, _, _, _), house(ivory, _, _, _, _), Street),

    % 7) The cookies eater owns snails.
    member(house(_, _, snails, _, cookies), Street),

    % 8) Twinkies are eaten in the yellow house.
    member(house(yellow, _, _, _, twinkies), Street),

    % 9) Milk is drunk in the middle house.
    [_, _, house(_, _, _, milk, _), _, _] = Street,

    % 10) The PSU alum lives in the first house
    [house(_, psu_alum, _, _, _), _, _, _, _] = Street,

    % 11) The alum who eats pie lives in the house next to the alum with the fox.
    next_to(house(_, _, _, _, pie), house(_, _, fox, _, _), Street),

    % 12) Twinkies are eaten in the house next to the house where the horse is kept. 
    next_to(house(_, _, _, _, twinkies), house(_, _, horse, _, _), Street),

    % 13) The alum who eats ice cream drinks orange juice.
    member(house(_, _, _, orange_juice, ice_cream), Street),

    % 14) The WOU alum eats cheesecake.
    member(house(_, wou_alum, _, _, cheesecake), Street),

    % 15) The PSU alum lives next to the blue house.
    next_to(house(_, psu_alum, _, _, _), house(blue, _, _, _, _), Street),

    % The final statement
    member(house(_, Who, owl, _, _), Street).

% Helper rules
is_right(L, R, [L | [R | _]]).
is_right(L, R, [_ | Rest]) :- is_right(L, R, Rest).
next_to(X, Y, List) :- is_right(X, Y, List).
next_to(X, Y, List) :- is_right(Y, X, List).

/*
    This is what you would run in the terminal to get the answer:

    owns_owl(Street, Who).

    It should spit out:

    Who = wou_alum
*/