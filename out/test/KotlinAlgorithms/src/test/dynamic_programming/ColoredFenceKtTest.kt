package dynamic_programming

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class ColoredFenceKtTest {

    @Test
    fun numWays() {
        assert(6 == numWays(3))
        assert(10 == numWays(4))
        assert(16 == numWays(5))
    }
}