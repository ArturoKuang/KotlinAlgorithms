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

    @Test
    fun uniquePathMaxProfitPath() {
        val p0 = uniquePathMaxProfitPath(
                listOf(
                        listOf(0, 2, 2, 1),
                        listOf(3, 1, 1, 1),
                        listOf(4, 4, 2, 0)
                )
        )

        val p1 = uniquePathMaxProfitPath(
                listOf(
                        listOf(0, 2, 2, 50),
                        listOf(3, 1, 1, 100),
                        listOf(4, 4, 2, 0)
                )
        )

        val p2 = uniquePathMaxProfitPath(
                listOf(
                        listOf(0, 2, 2, 500),
                        listOf(3, 1, 1, 1000),
                        listOf(400, 400, 2, 0),
                        listOf(0, 200, 2, 500),
                        listOf(3, 1, 1, 1000),
                        listOf(4, 4000, 2, 0),
                        listOf(0, 2, 2, 50),
                        listOf(3, 1, 1, 100),
                        listOf(4, 4, 2, 0)
                )
        )

        println("${p0.joinToString("\n")} \n")
        println("${p1.joinToString("\n")} \n")
        println("${p2.joinToString("\n")} \n")
    }
}