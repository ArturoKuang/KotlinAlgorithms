package dynamic_programming

// Given an unlimited supply of coin of given denominations (ex: 1, 3, 5, 10),
// find the total number of ways to make a change of size n

// Object function: F(i) = total number of ways to to make a change of size n
// Base cases: F(0) = 1; each coin zero times
// F(0) = 1, F(1) = 1, F(2) = 1 -> [1, 1], F(3) = F(2) + F(0) = 2
// Recurrence relation: F(n) = F(n-1) + F(n-3) + F(n-5) + F(n-10)

// denominations (1, 3, 5, 10)
fun coinChange(n: Int): Int {
    val dp = IntArray(n + 1)
    dp[0] = 1

    for(i in 1..n) {
        dp[i] += dp[i - 1]
        if(i >= 3) {
            dp[i] += dp[i - 3]
        }

        if(i >= 5) {
            dp[i] += dp[i - 5]
        }

        if(i >= 10) {
            dp[i] += dp[i - 10]
        }
    }

    return dp[n]
}

// Given an unlimited supply of coin of given denominations (ex: 1, 3, 5, 10),
// find the total number of ways to make a change of size n [by using exactly 9 coins]
// Objective function: F(i, t)
// Base cases: F(i, 0) = 0, F(0,0) = 1,
// F(i, 1) = { (1, 1) = 1, (3, 1) = 1, (5, 1) = 1, (10, 1) = 1, 0 }
// Recurrence relation: F(i - 1, t - 1) + F(i - 3, t - 1) + F(i - 5, t - 1) + F(i - 10, t - 1)
fun coinChange(n: Int, numCoins: Int, denominations: IntArray): Int {
    val dp = MutableList(n + 1) {
        MutableList(numCoins + 1) { 0 }
    }
    dp[0][0] = 1

    for(denomination in denominations) {
        if(denomination < n) {
            dp[denomination][1] = 1
        }
    }

    for (i in 1..n) {
        for(j in 1..numCoins) {
            for (denomination in denominations) {
                if(i >= denomination) {
                    dp[i][j] += dp[i - denomination][j - 1]
                }
            }
        }
    }

    return dp[n][numCoins]
}

fun coinChangeNoMoreTCoins(n: Int, t: Int, coins: IntArray): Int {
    val dp = MutableList(n + 1) {
        MutableList(t + 1) { 0 }
    }
    dp[0][0] = 1

    for(i in 1..n) {
        for(j in 1..t) {
            if(i > 0 && j == 0) {
                dp[i][j] = 0
                continue
            }

            if(i == 0 && j > 0) {
                dp[i][j] = 1
            }

            for (coin in coins) {
                if(i  >= coin) {
                    dp[i][j] += dp[i - coin][j - 1]
                }
            }
        }
    }

    return dp[n][t]
}



























