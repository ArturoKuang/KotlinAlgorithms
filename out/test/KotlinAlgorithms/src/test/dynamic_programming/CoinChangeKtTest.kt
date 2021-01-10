package dynamic_programming

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class CoinChangeKtTest {


    @Test
    fun coinChange() {
        assert(1 == coinChange(0))
        assert(2 == coinChange(3))
        assert(3 == coinChange(4))
    }

    @Test
    fun coinChangeExactCoins() {
        val denominations = intArrayOf(1, 2, 3, 5)
        assert(1 == coinChange(0, 0, denominations))
        assert(9 == coinChange(7, 3, denominations))
    }

    @Test
    fun coinChangeEvenCoins() {
        val denominations = intArrayOf(1, 3, 5, 10)
        assert(3 == coinChangeEvenCoins(4, denominations))
        assert(8 == coinChangeEvenCoins(6, denominations))
    }

    @Test
    fun coinChangeUniqueWays() {
        assert(2894 == coinChangeUniqueWays(75, intArrayOf(1, 2, 3, 5)))
        assert(107 == coinChangeUniqueWays(75, intArrayOf(2, 3, 5)))
        assert(3 == coinChangeUniqueWays(10, intArrayOf(4, 1)))
    }

    @Test
    fun changeMaking() {
        assert(7 == changeMaking(29, intArrayOf(1, 3, 5)))
        assert(-1 == changeMaking(1, intArrayOf(2, 3, 5)))
        assert(6 == changeMaking(56, intArrayOf(15, 4, 3)))
    }
}