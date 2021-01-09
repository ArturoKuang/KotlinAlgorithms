package dynamic_programming

import java.lang.Integer.max

/*
Problem:
	Unique Paths
	A robot is located at the top-left corner of a m x n grid (marked 'S' in the diagram below).
	The robot can only move either down or right at any point in time.
	The robot is trying to reach the bottom-right corner of the grid (marked 'E' in the diagram below).
	How many possible unique paths are there?
	+---+---+---+---+
	| S |   |   |   |
	+---+---+---+---+
	|   |   |   |   |
	+---+---+---+---+
	|   |   |   | E |
	+---+---+---+---+
	Above is a 3 x 4 grid. How many possible unique paths are there?
*/

// Problem given a MxN matrix find total number of ways to get to x,y
// Objective function: F(i,j)
// Base cases: 1x1 = 1, 2x2 = 2
// recurrence relation: F(i,j) = F(i-1,j) + F(i, j-1)
// Runtime: 0(mn)
// Spacetime: 0(mn)
fun uniquePaths(m: Int, n: Int): Int {
    val dp = MutableList(m) {
        MutableList(n) { 0 }
    }
    dp[0][0] = 1

    for (i in 0 until m) {
        for(j in 0 until n) {
            if (i > 0 && j > 0) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
            } else if (i > 0) {
                dp[i][j] = dp[i - 1][j]
            } else if (j > 0) {
                dp[i][j] = dp[i][j - 1]
            }
        }
    }

    return dp[m-1][n-1]
}

// Problem given a MxN matrix find total number of ways to get to x,y with given bad cells
// Runtime: 0(mn)
// Spacetime: 0(mn)
fun uniquePathsBadCells(badCells: List<List<Int>>): Int {
    val m = badCells.size
    val n = badCells[0].size

    val dp = MutableList(m) {
        MutableList(n) { 0 }
    }
    dp[0][0] = 1

    for (i in 0 until m) {
        for(j in 0 until n) {
            if(badCells[i][j] == 1) {
                dp[i][j] = 0
                continue
            }

            if (i > 0 && j > 0) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
            } else if (i > 0) {
                dp[i][j] = dp[i - 1][j]
            } else if (j > 0) {
                dp[i][j] = dp[i][j - 1]
            }
        }
    }

    return dp[m-1][n-1]
}

fun uniquePathMaxProfit(grid: List<List<Int>>): Int {
    val m = grid.size
    val n = grid[0].size

    val dp = MutableList(m) {
        MutableList(n) { 0 }
    }
    dp[0][0] = grid[0][0]

    for(i in 0 until m) {
        for(j in 0 until n) {
            if (i > 0 && j > 0) {
                dp[i][j] = max(dp[i - 1][j], dp[i][j - 1])
            } else if (i > 0) {
                dp[i][j] = dp[i - 1][j]
            } else if (j > 0) {
                dp[i][j] = dp[i][j - 1]
            }

            dp[i][j] += grid[i][j]
        }
    }

    return dp[m - 1][n - 1]
}




