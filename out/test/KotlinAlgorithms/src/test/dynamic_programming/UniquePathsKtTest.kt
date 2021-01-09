package dynamic_programming

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class UniquePathsKtTest {

    @Test
    fun uniquePaths() {
        assert(1 == uniquePaths(1, 1))
        assert(10 == uniquePaths(3, 4))
    }

    @Test
    fun uniquePathsBadCells() {
        assert(1 == uniquePathsBadCells(
                listOf(
                        listOf(0, 0)
                )
        ))

        assert(3 == uniquePathsBadCells(
                listOf(
                        listOf(0, 0, 0, 0),
                        listOf(0, 0, 1, 1),
                        listOf(0, 0, 0, 0)
                )
        ))
    }

    @Test
    fun uniquePathMaxProfit() {
        assert(13 == uniquePathMaxProfit(
                listOf(
                        listOf(0, 2, 2, 1),
                        listOf(3, 1, 1, 1),
                        listOf(4, 4, 2, 0)
                )
        ))

        assert(154 == uniquePathMaxProfit(
                listOf(
                        listOf(0, 2, 2, 50),
                        listOf(3, 1, 1, 100),
                        listOf(4, 4, 2, 0)
                )
        ))
    }
}