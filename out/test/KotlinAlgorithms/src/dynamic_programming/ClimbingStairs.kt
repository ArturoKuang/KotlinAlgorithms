package dynamic_programming

import kotlin.math.min

//find all possible ways of getting to the n-step in a staircase
//if the person can take 1 or 2 steps
fun climbingStairs(numStairs: Int): Int {
    val dp = IntArray(numStairs + 1)
    var a = 1
    var b = 1
    var c = 0

    for (i in 2 until dp.size) {
        c = a + b
        a = b
        b = c
    }

    return c
}

//Optimized climbing stairs over k steps
//Runtime: 0(nk) n = total # of stairs, k = # of steps
//Spacetime: 0(k)
fun climbingStairsKSteps(numStairs: Int, steps: Int): Int {
    val dp = IntArray(steps)
    dp[0] = 1
    for (i in 1..numStairs) {
        for (j in 1 until steps) {
            if(i - j < 0) {
                continue
            }

            dp[i % steps] += dp[(i-j) % steps]
        }
    }

    return dp[numStairs % steps]
}


// We are given array with red steps that we can not step on
fun climbStairsKStepsSkipRed(numStairs: Int, steps: Int, stairs: IntArray): Int {
    val dp = IntArray(steps)
    dp[0] = 1
    for (i in 1..numStairs) {
        for (j in 1 until steps) {
            if(i - j < 0) {
                continue
            }

            //check for red stairs
            if(stairs.contains(i-1)) {
                dp[i % steps] = 0
                break
            }

            dp[i % steps] += dp[(i-j) % steps]
        }
    }

    return dp[numStairs % steps]
}

// Example problem: n = 3, k = 2, Price = [ 3, 2, 4 ]
// 0    1    2    3
// |----|----|----|
//     $3   $2   $4
// Object function: F(i) = min cost to get to the ith stair
// Base cases: F(0) = 0, F(1) = 3, F(2) = 2, F(3) = 6
// Recurrence relation: F(n) = P(n) + min(F(n-1), F(n-2))
// Order of computation: Bottom-up
// Location of answer: F(n)
// Runtime: 0(nk) n = total # of stairs, k = # of steps
// Spacetime: 0(k)
fun climbingStairsCheapestPath(numStairs: Int, steps: Int, price: IntArray): Int {
    val dp = IntArray(steps)
    dp[0] = 0
    dp[1] = price[1]

    for (i in 1..numStairs) {
        var minTotal = Int.MAX_VALUE
        for(j in 1..steps) {
            if(i - j < 0) {
                continue
            }

            minTotal =  min(minTotal, dp[(i-j) % steps])
        }
        dp[i % steps] = minTotal + price[i]
    }

    return dp[numStairs % steps]
}

