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
}