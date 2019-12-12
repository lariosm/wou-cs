{--
Manuel Larios
CS360
10/8/2019
--}

import Data.List
import System.IO
import Data.Char

--problem 1
squareRoot x = sqrt x

--problem 2
asciiPrevious x = pred x

--problem 3
verifyEven x = if(3 * x + 1) `mod` 2 == 0 then True else False

--problem 4
gaussianProduct x = product [1,3..x]

--problem 5
largestInList xs = maximum (tail (init xs))

--problem 6
constructList = 6:19:41: -3:[]

--problem 7
firstXEvens x = takeWhile(<= x * 2) [x | x <- [1..], even x]

--problem 8
oddsDivisible3and7 x = [x | x <- [1..x], odd x, x `mod` 3 == 0 , x `mod` 7 == 0]

--problem 9
oddsDivisible9 x = [x | x <- [(x `div` 2)..x], odd x, x `mod` 9 == 0 ]

--problem 10
countNegs xs = length [x | x <- xs, x < 0]

--problem 11
hexMaps = zip [0..9]['0'..'9'] ++ zip [10..15]['A'..'F']

--problem 12
makeList x = [[1..n] | n <- [1..x] ]

--problem 13
sanitize xs = concat [if x == ' ' then "%20" else [x] | x <- xs]

--problem 14 
{--
sqrt :: Floating a => a -> a
Types it will work with: isNaN, exponent, scaleFloat

succ :: Enum a => a -> a
Types it will work with: Int, Integer, Float

div :: Integral a => a -> a -> a
Types it will work with: numerator, denominator, approxRational

(*) :: Num a => a -> a -> a
Types it will work with: (/), recip, fromRational

(>) :: Ord a => a -> a -> Bool
Types it will work with: properFraction, ceiling, round
--}

--problem 15
getSuit 0 = "Heart"
getSuit 1 = "Diamond"
getSuit 2 = "Spade"
getSuit 3 = "Club"
getSuit x = "I don't have a suit for this value, bud."

--problem 16
dotProduct (x1, y1, z1)(x2, y2, z2) = (x1 * x2) + (y1 * y2) + (z1 * z2)

--problem 17
reverseFirstThree [] = [] --0 elements in list; stays intact
reverseFirstThree (x:[]) = x:[] --1 element in list; stays intact
reverseFirstThree (x:y:[]) = y:x:[] --2 elements in list; reversed
reverseFirstThree (x:y:z:[]) = z:y:x:[] --3 elements in list; reversed
reverseFirstThree (x:y:z:xs) = z:y:x:reverseFirstThree xs --Multiple elements in list; first 3 reversed

--problem 18
feelsLike temp
    | temp <= -45.3 = "Frostbite central!"
    | temp <= 32 = "It's freezing out there!"
    | temp <= 60 = "Cool weather. Be sure to wear a sweater."
    | temp <= 80 = "Warm. It's a good day for a walk."
    | temp > 80 = "Turn on the AC, baby!"

--problem 19
feelsLike2 celsius
    | temp <= -45.3 = (temp, "Frostbite central!")
    | temp <= 32 = (temp, "It's freezing out there!")
    | temp <= 60 = (temp, "Cool weather. Be sure to wear a sweater.")
    | temp <= 80 = (temp, "Warm. It's a good day for a walk.")
    | temp > 80 = (temp, "Turn on the AC, baby!")
    where temp = (celsius * (9 / 5)) + 32

--problem 20
cylinderToVolume xs = [vol | (r, h) <- xs, let vol =  pi * (r ^ 2) * h]






--Main

main = do
    --problem 1
    putStrLn("")
    putStrLn("-Problem 1-")
    putStrLn("Input: 818281336460929553769504384519009121840452831049")
    putStr("Output: ")
    print(squareRoot 818281336460929553769504384519009121840452831049)
    putStrLn("")

    --Problem 2
    putStrLn("-Problem 2-")
    putStrLn("Input: 'A'")
    putStr("Output: ")
    print(asciiPrevious 'A')
    putStrLn("")

    --Problem 3
    putStrLn("-Problem 3-")
    putStrLn("Input1: 5")
    putStr("Output1: ")
    print(verifyEven 5)
    putStrLn("Input2: 10")
    putStr("Output2: ")
    print(verifyEven 10)
    putStrLn("Input3: 6541562")
    putStr("Output3: ")
    print(verifyEven 6541562)
    putStrLn("")

    --Problem 4
    putStrLn("-Problem 4-")
    putStrLn("Input: 100")
    putStr("Output: ")
    print(gaussianProduct 100)
    putStrLn("")

    --Problem 5
    putStrLn("-Problem 5-")
    putStrLn("Input: [99,23,4,2,67,82,49,-40]")
    putStr("Output: ")
    print(largestInList [99,23,4,2,67,82,49,-40])
    putStrLn("")

    --Problem 6
    putStrLn("-Problem 6-")
    putStr("Output: ")
    print(constructList)
    putStrLn("")

    --Problem 7
    putStrLn("-Problem 7-")
    putStrLn("Input: 27")
    putStr("Output: ")
    print(firstXEvens 27)
    putStrLn("")

    --Problem 8
    putStrLn("-Problem 8-")
    putStrLn("Input: 200")
    putStr("Output: ")
    print(oddsDivisible3and7 200)
    putStrLn("")

    --Problem 9
    putStrLn("-Problem 9-")
    putStrLn("Input: 200")
    putStr("Output: ")
    print(oddsDivisible9 200)
    putStrLn("")

    --Problem 10
    putStrLn("-Problem 10-")
    putStrLn("Input: [(-4),6,7,8,(-14)]")
    putStr("Output: ")
    print(countNegs [(-4),6,7,8,(-14)])
    putStrLn("")

    --Problem 11
    putStrLn("-Problem 11-")
    putStr("Output: ")
    print(hexMaps)
    putStrLn("")

    --Problem 12
    putStrLn("-Problem 12-")
    putStrLn("Input1: 7")
    putStr("Output1: ")
    print(makeList 7)
    putStrLn("Input2: 0")
    putStr("Output2: ")
    print(makeList 0)
    putStrLn("Input3: -1")
    putStr("Output3: ")
    print(makeList (-1))
    putStrLn("")

    --Problem 13
    putStrLn("-Problem 13-")
    putStrLn("Input: \"http://wou.edu/my homepage/I love spaces.html\"")
    putStr("Output: ")
    print(sanitize "http://wou.edu/my homepage/I love spaces.html")
    putStrLn("")

    --Problem 15
    putStrLn("-Problem 15-")
    putStrLn("Input1: 0")
    putStr("Output1: ")
    print(getSuit 0)
    putStrLn("Input2: 1")
    putStr("Output2: ")
    print(getSuit 1)
    putStrLn("Input3: 2")
    putStr("Output3: ")
    print(getSuit 2)
    putStrLn("Input4: 3")
    putStr("Output4: ")
    print(getSuit 3)
    putStrLn("Input5: 77")
    putStr("Output5: ")
    print(getSuit 77)
    putStrLn("")

    --Problem 16
    putStrLn("-Problem 16-")
    putStrLn("Input: (1,2,3.0) (4.0,5,6)")
    putStr("Output: ")
    print(dotProduct (1,2,3.0) (4.0,5,6))
    putStrLn("")

    --Problem 17
    putStrLn("-Problem 17-")
    putStrLn("Input1: [1]")
    putStr("Output1: ")
    print(reverseFirstThree [1])
    putStrLn("Input2: [1,2]")
    putStr("Output2: ")
    print(reverseFirstThree [1,2])
    putStrLn("Input3: [1,2,3]")
    putStr("Output3: ")
    print(reverseFirstThree [1,2,3])
    putStrLn("Input4: [1,2,3,4]")
    putStr("Output4: ")
    print(reverseFirstThree [1,2,3,4])
    putStrLn("")

    --Problem 18
    putStrLn("-Problem 18-")
    putStrLn("Input1: -200")
    putStr("Output1: ")
    print(feelsLike (-200))
    putStrLn("Input2: 200")
    putStr("Output2: ")
    print(feelsLike 200)
    putStrLn("Input3: -45.3")
    putStr("Output3: ")
    print(feelsLike (-45.3))
    putStrLn("Input4: 79")
    putStr("Output4: ")
    print(feelsLike 79)
    putStrLn("")

    --Problem 19
    putStrLn("-Problem 19-")
    putStrLn("Input1: -200")
    putStr("Output1: ")
    print(feelsLike2 (-200))
    putStrLn("Input2: -0.1")
    putStr("Output2: ")
    print(feelsLike2 (-0.1))
    putStrLn("Input3: -42.9444444444444444444444444445")
    putStr("Output3: ")
    print(feelsLike2 (-42.9444444444444444444444444445))
    putStrLn("Input4: 100")
    putStr("Output4: ")
    print(feelsLike2 100)
    putStrLn("")

    --Problem 20
    putStrLn("-Problem 20-")
    putStrLn("Input: [(2,5.3),(4.2,9),(1,1),(100.3,94)]")
    putStr("Output: ")
    print(cylinderToVolume [(2,5.3),(4.2,9),(1,1),(100.3,94)])