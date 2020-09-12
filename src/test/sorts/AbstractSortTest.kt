package sorts

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import kotlin.random.Random

abstract class AbstractSortTest<out T: Sort>(private val sortType: T) {
    @Test 
    fun emptyTest() {
        val arr = arrayOf<Int>()
        sortType.sortArr(arr)
        Assertions.assertArrayEquals(arrayOf<Int>(), arr)
    }

    @Test
    fun singleElementTest() {
        val arr = arrayOf(1)
        sortType.sortArr(arr)
        Assertions.assertArrayEquals(arrayOf<Int>(1), arr)
    }

    @Test
    fun twoElementsTest() {
        val arr = arrayOf(3, 5)
        sortType.sortArr(arr)
        Assertions.assertArrayEquals(arrayOf<Int>(3,5), arr)
    }

    @Test
    fun twoElementsOutOfOrderTest() {
        val arr = arrayOf(5, 3)
        sortType.sortArr(arr)
        Assertions.assertArrayEquals(arrayOf<Int>(3,5), arr)
    }

    @Test
    fun randomElements() {
        val arr = Array(1000) { Random.nextInt(0, 100) }
        sortType.sortArr(arr)
        for (i in 1 until arr.size) {
            if(arr[i - 1] > arr[i] && arr[i + 1] < arr[i]) {
                Assertions.fail<String>("Array is not ordered")
            }
        }
    }
}