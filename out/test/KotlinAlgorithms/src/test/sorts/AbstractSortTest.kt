package sorts

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

abstract class AbstractSortTest<out T: Sort>(private val sortType: T) {
    @Test 
    fun emptyTest() {
        val arr = arrayOf<Int>()
        sortType.sortTest(arr)
        Assertions.assertArrayEquals(arrayOf<Int>(), arr)
    }

    @Test
    fun singleElementTest() {
        val arr = arrayOf(1)
        sortType.sortTest(arr)
        Assertions.assertArrayEquals(arrayOf<Int>(1), arr)
    }

    @Test
    fun twoElementsTest() {

    }

    @Test
    fun twoElementsOutOfOrderTest() {

    }
}