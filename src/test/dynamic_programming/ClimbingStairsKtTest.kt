package dynamic_programming

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class ClimbingStairsKtTest {

    @Test
    fun climbingStairs() {
        assert(3 == climbingStairs(3))
        assert(8 == climbingStairs(5))
    }

    @Test
    fun climbingStairsKSteps() {
        assert(3 == climbingStairsKSteps(3, 2))
        assert(8 == climbingStairsKSteps(5, 2))
        assert(4 == climbingStairsKSteps(3, 3))
        assert(13 == climbingStairsKSteps(5, 3))
    }

    @Test
    fun climbStairsKStepsSkipRed() {
        assert(2 == climbStairsKStepsSkipRed(7, 3, intArrayOf(1, 3, 4)))
    }

    @Test
    fun climbingStairsCheapestPath() {
        assert(6 == dynamic_programming.climbingStairsCheapestPath(3, 2, intArrayOf(0, 3, 2, 4)))
        assert(7 == dynamic_programming.climbingStairsCheapestPath(4, 2, intArrayOf(0, 3, 2, 4, 5)))
    }
}