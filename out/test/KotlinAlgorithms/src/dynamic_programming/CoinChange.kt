package dynamic_programming

import kotlin.math.min

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

    for (i in 1..n) {
        dp[i] += dp[i - 1]
        if (i >= 3) {
            dp[i] += dp[i - 3]
        }

        if (i >= 5) {
            dp[i] += dp[i - 5]
        }

        if (i >= 10) {
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

    for (i in 1..n) {
        for (j in 1..numCoins) {
            if (i > 0 && j == 0) {
                dp[i][j] = 0
                continue
            }

            for (denomination in denominations) {
                if (i >= denomination) {
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

    for (i in 1..n) {
        for (j in 1..t) {
            if (i > 0 && j == 0) {
                dp[i][j] = 0
                continue
            }

            if (i == 0 && j > 0) {
                dp[i][j] = 1
            }

            for (coin in coins) {
                if (i >= coin) {
                    dp[i][j] += dp[i - coin][j - 1]
                }
            }
        }
    }

    return dp[n][t]
}

// 1 == even, 0 == odd
fun coinChangeEvenCoins(n: Int, coins: IntArray): Int {
    val dp = MutableList(n + 1) {
        MutableList(2) { 0 }
    }
    dp[0][0] = 0
    dp[0][1] = 1
    for (i in 1..n) {
        for (coin in coins) {
            for (j in 0 until 2) {
                if (i >= coin) {
                    dp[i][j] += dp[i-coin][1-j]
                }
            }
        }
    }

    return dp[n][1]
}



/*
n = 3 coins = 1,2,3
No duplicates
for _, coin := range coins {
	for i := 1; i <= n; i++ {

coin = [1]
    (1)      (1)      (1)
3 ------ 2 ------ 1 ------ 0

coin = [1,2]
    (1)      (1)     (1)
/------ 2 ------ 1 ------ 0
3
\------- 1 ------ 0
    (2)     (1)

coin = [1,2,3]
    (1)     (1)      (1)
/------ 2 ------ 1 ------ 0
|
|  (3)
3 ------ 0
|
|
\------- 1 ------ 0
    (2)       (1)
Answer: 3


With duplicates
for i := 1; i <= n; i++ {
	for _, coin := range coins {

coins = [1]
     (1)
1 ------- 0
coins = [1,2]
    (1)       (1)
/------- 1 ------- 0
2
\--------0
    (2)
coins = [1,2,3]
             (1)      (1)
   (1)   /------- 1 ------- 0
/------ 2
3        \--------0
|              (2)
|  (2)     (1)
|----- 1 ----- 0
|
|  (3)
|----- 0
Answer: 4
*/
fun coinChangeUniqueWays(n: Int, coins: IntArray): Int {
    val dp = MutableList(n + 1) { col ->
        MutableList(coins.size) {
            if (col == 0) {
                return@MutableList 1
            }
            return@MutableList 0
        }
    }

    for (i in 0..n) {
        for(j in coins.indices) {
            for (k in 0..j) {
                if (i-coins[k] < 0) {
                    continue
                }
                dp[i][j] += dp[i-coins[k]][k]
            }
        }
    }

    return dp[n][coins.size - 1]
}


// Find the min. number of coins to make a total of size n
// given an array of coins
fun changeMaking(n: Int, coins: IntArray): Int {
    val dp = MutableList(n + 1) { 0 }

    dp[0] = 0
    for (i in 1..n) {
        dp[i] = Int.MAX_VALUE
        for(coin in coins) {
            if(i >= coin && 1 + dp[i - coin] != Int.MIN_VALUE) {
                dp[i] = min(dp[i], 1 + dp[i - coin])
            }
        }
    }

    return if(dp[n] == Int.MAX_VALUE) {
        -1
    } else {
        dp[n]
    }
}






















