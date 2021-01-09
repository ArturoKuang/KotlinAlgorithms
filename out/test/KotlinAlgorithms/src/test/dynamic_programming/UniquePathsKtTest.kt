package dynamic_programming

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class UniquePathsKtTest {

    @Test
    fun uniquePaths() {
        assert(1 == uniquePaths(1, 1))
        assert(10 == uniquePaths(3, 4))
    }
}