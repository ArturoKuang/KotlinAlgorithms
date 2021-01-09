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
        if(i - 3 >= 0) {
            dp[i] += dp[i - 3]
        }

        if(i - 5 >= 0) {
            dp[i] += dp[i - 5]
        }

        if(i - 10 >= 0) {
            dp[i] += dp[i - 10]
        }
    }

    return dp[n]
}