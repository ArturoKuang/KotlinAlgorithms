package sorts

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import kotlin.random.Random

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
        val arr = arrayOf(3, 5)
        sortType.sortTest(arr)
        Assertions.assertArrayEquals(arrayOf<Int>(3,5), arr)
    }

    @Test
    fun twoElementsOutOfOrderTest() {
        val arr = arrayOf(5, 3)
        sortType.sortTest(arr)
        Assertions.assertArrayEquals(arrayOf<Int>(3,5), arr)
    }

    @Test
    fun randomElements() {
        val arr = Array(1000) { Random.nextInt(0, 100) }
        for (i in 1..arr.size) {
            if(arr[i - 1] > arr[i] && arr[i + 1] < arr[i]) {
                Assertions.fail<String>("Array is not ordered")
            }
        }
    }
}