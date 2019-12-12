import Data.List
import System.IO
import Data.Char
import qualified Assn2b as A

{--
Manuel Larios
CS360
--}


--problem 1
gcdMine x y = if y == 0 then x else gcdMine y (x `mod` y)

gcdCheck x y = (myAnswer, correctAnswer, comment)
    where
        myAnswer = gcdMine x y
        correctAnswer = gcd x y
        comment = if myAnswer == correctAnswer then "Matches" else "Does not Match"

--problem 2
fibList n
    | n <= 1 = n
    | otherwise = fibList (n - 1) + fibList (n - 2)

fibSeq n = map fibList [1..n]

--problem 3
count element [] = 0
count element (x:xs)
    | element == x = 1 + (count element xs)
    | otherwise = count element xs

--problem 4
--Source: https://stackoverflow.com/questions/26708047/change-the-function-to-use-recursion-in-haskell
--sanitize xs = concat [if x == ' ' then "%20" else [x] | x <- xs]
sanitize xs
    | xs == [] = []
    | head xs == ' ' = "%20" ++ sanitize (tail xs)
    | otherwise = head xs:sanitize (tail xs)

--problem 5
multListBy10 xs = map (*10) xs

--problem 6
incrementList1 xs = map succ xs
incrementList2 xs = map succ xs

--problem 7
containsDivisibleBy42 xs = any (\n -> n `mod` 42 == 0) xs

--problem 8
powersOf10 xs = zipWith (^) (replicate 10 10) xs

--problem 9
stringStripper xs = dropWhileEnd (== ' ') xs

--problem 10
evenNumbers xs = all (even) xs

--problem 11
addNotToList xs = map ("not " ++) xs

--problem 12
reverseListString xs = map (reverse) xs

--problem 13
addNumbers = \x -> \y -> x + y

--problem 14
times4 = \x -> x * 4

--problem 15
secondElement x = (\a -> a !! 1) x

--problem 16
roundSquare x = (\a -> round(sqrt a)) x

--problem 17
splitSentence x = (\a -> words a ) x

--problem 18
triangles = map (\(a,b) -> (a,b,(sqrt (a ^ 2 + b ^ 2))))

main = do
    --Problem 1
    putStrLn "-Problem 1-"
    putStrLn "Input: 18, 42"
    putStr "Output: "
    print(gcdMine 18 42)
    putStrLn "gcdCheck... check"
    print(gcdCheck 111 259)
    print(gcdCheck 2945 123042)
    print(gcdCheck (2*5*7)(7*23))
    putStrLn""

    --Problem 2
    putStrLn "-Problem 2-"
    putStrLn "Input: 20"
    putStr "Output: "
    print(fibSeq 20)
    putStrLn ""

    --Problem 3
    putStrLn "-Problem 3-"
    putStrLn "Input1: 7 [1,7,6,2,7,7,9]"
    putStr "Output1: "
    print(count 7 [1,7,6,2,7,7,9])
    putStrLn "Input2: 'w' \"western oregon wolves\""
    putStr "Output2: "
    print(count 'w' "western oregon wolves")
    putStrLn ""

    --Problem 4
    putStrLn "-Problem 4-"
    putStrLn "Input1: \"http://wou.edu/my homepage/I love spaces.html\""
    putStr "Output1: "
    print(sanitize "http://wou.edu/my homepage/I love spaces.html")
    putStrLn ""

    --Problem 5
    putStrLn "-Problem 5-"
    putStrLn "Input: [1,2,3,4,5,6,7,8,9]"
    putStr "Output: "
    print(multListBy10 [1..9])
    putStrLn ""

    --Problem 6
    putStrLn "-Problem 6-"
    putStrLn "First Function"
    putStrLn "Input: [1,2,3,4,5,6,7,8,9]"
    putStr "Output: "
    print(incrementList1 [1..9])
    putStrLn "Second Function"
    putStrLn "Input: \"Haskell is fun.\""
    putStr "Output: "
    print(incrementList2 "Haskell is fun.")
    putStrLn ""

    --Problem 7
    putStrLn "-Problem 7-"
    putStrLn "Input1: [12,15,87,968,54,23,5875,665,25,2]"
    putStr "Output1: "
    print(containsDivisibleBy42 [12,15,87,968,54,23,5875,665,25,2])
    putStrLn "Input1: [987,85,53,336,2125,21,5151,84,646,64]"
    putStr "Output1: "
    print(containsDivisibleBy42 [987,85,53,336,2125,21,5151,84,646,64])
    putStrLn ""

    --Problem 8
    putStrLn "-Problem 8-"
    putStrLn "Input1: [1,3,5,7,9]"
    putStr "Output1: "
    print(powersOf10 [1,3,5,7,9])
    putStrLn ""

    --Problem 9
    putStrLn "-Problem 9-"
    putStrLn "Input: \"That is pretty neat         \""
    putStr "Output: "
    print(stringStripper "That is pretty neat         ")
    putStrLn ""

    --Problem 10
    putStrLn "-Problem 10-"
    putStrLn "Input: [2,2,4,6]"
    putStr "Output: "
    print(evenNumbers [2,2,4,6])
    putStrLn ""

    --Problem 11
    putStrLn "-Problem 11-"
    putStrLn "Input: [\"my chair\",\"my problem\"]"
    putStr "Output: "
    print(addNotToList ["my chair", "my problem"])
    putStrLn ""

    --Problem 12
    putStrLn "-Problem 12-"
    putStrLn "Input: [\"This\",\"is\",\"a\",\"sentence\"]"
    putStr "Output: "
    print(reverseListString ["This","is","a","sentence"])
    putStrLn ""

    --Problem 13
    putStrLn "-Problem 13-"
    putStrLn "Input: 8 9"
    putStr "Output: "
    print(addNumbers 8 9)
    putStrLn ""


    --Problem 14
    putStrLn "-Problem 14-"
    putStrLn "Input: 8"
    putStr "Output: "
    print(times4 8)
    putStrLn ""

    --Problem 15
    putStrLn "-Problem 15-"
    putStrLn "Input: [1,4,6,7,8,9]"
    putStr "Output: "
    print(secondElement [1,4,6,7,8,9])
    putStrLn ""

    --Problem 16
    putStrLn "-Problem 16-"
    putStrLn "Input: 17"
    putStr "Output: "
    print(roundSquare 17)
    putStrLn ""

    --Problem 17
    putStrLn "-Problem 17-"
    putStrLn "Input: \"This is a sentence written in the usual way\""
    putStr "Output: "
    print(splitSentence "This is a sentence written in the usual way")
    putStrLn ""

    --Problem 18
    putStrLn "-Problem 18-"
    putStrLn "Input: [(3,4),(5,16),(9.4,2)]"
    putStr "Output: "
    print(triangles [(3,4),(5,16),(9.4,2)])
    putStrLn ""

    --Part02_Problem 1
    putStrLn "-Part02_Problem 1-"
    putStrLn "In comments in source code"
    A.problem1
    putStrLn ""

    --Part02_Problem 2
    putStrLn "-Part02_Problem 2-"
    putStrLn "Input: [9,8,7,6,5,4,3,2,1,0]"
    putStr "Output: "
    print(A.myLength [9,8,7,6,5,4,3,2,1,0])
    putStrLn ""

    --Part02_Problem 3.1
    putStrLn "-Part02_Problem 3.1-"
    putStrLn "Input: [1,2,3,4,5]"
    putStr "Output: "
    print(A.convertInttoStringLeft [1,2,3,4,5])
    putStrLn ""

    --Part02_Problem 3.2
    putStrLn "-Part02_Problem 3.2-"
    putStrLn "Input: [1,2,3,4,5]"
    putStr "Output: "
    print(A.convertInttoStringRight [1,2,3,4,5])
    putStrLn ""

    --Part02_Problem 4.1
    putStrLn "-Part02_Problem 4.1"
    putStrLn "Original: take 10 (cycle (filter (>5) (map (*2) [1..10])))"
    putStr "Output: "
    print(take 10 (cycle (filter (>5) (map (*2) [1..10]))))
    putStrLn "Rewrite: take 10 $ cycle $ filter (>5) $ map (*2) [1..10]"
    putStr "Output: "
    print(A.problem4Exp1)
    putStrLn ""

    --Part02_Problem 4.2
    putStrLn "-Part02_Problem 4.2"
    putStrLn "Original: length (filter (<20) [1..100])"
    putStr "Output: "
    print(length (filter (<20) [1..100]))
    putStrLn "Rewrite: length $ filter (<20) [1..100]"
    putStr "Output: "
    print(A.problem4Exp2)