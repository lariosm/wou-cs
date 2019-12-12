module Assn2b
(
 problem1, myLength, convertInttoStringLeft, convertInttoStringRight, problem4Exp1, problem4Exp2
) where
    
--problem 1
problem1 = putStrLn "foldr works to multply every value in the list starting at the end of the list and working its way to the left, whereas foldl does the exact opposite."

--problem 2
myLength xs = foldl (\x _  -> x + 1) 0 xs

--problem 3.1
convertInttoStringLeft xs = show (foldl (\x y -> 10 * x + y) 0 xs)

--problem 3.2
convertInttoStringRight xs = reverse ( show (foldr (\x y -> 10 * y + x) 0 xs))

--problem 4.1
problem4Exp1 = take 10 $ cycle $ filter (>5) $ map (*2) [1..10]

--problem 4.2
problem4Exp2 = length $ filter (<20) [1..100]