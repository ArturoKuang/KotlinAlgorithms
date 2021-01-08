package dynamic_programming

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

