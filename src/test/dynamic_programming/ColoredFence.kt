package dynamic_programming

// Paint Fence With Two Colors
// There is a fence with n posts, each post can be painted with either green or blue color.
// You have to paint all the posts such that no more than two adjacent fence posts have the same color.
// Return the total number of ways you can paint the fence.

// Runtime: 0(n)
// Spacetime: 0(n)
fun numWays(n: Int): Int {
    val dp = List(n + 1) {
        IntArray(2)
    }

    dp[1][0] = 1
    dp[1][1] = 1
    dp[2][0] = 2 //10 00
    dp[2][1] = 2 //01 11

    for(i in 3..n) {
        for(j in dp[0].indices) {
            dp[i][j] = dp[i-1][1-j] + dp[i-2][1-j]
        }
    }

    return dp[n][0] + dp[n][1]
}