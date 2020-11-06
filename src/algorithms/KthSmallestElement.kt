package algorithms

import org.junit.jupiter.api.Test
import java.util.*
import kotlin.random.Random
import kotlin.test.assertEquals

class KthSmallestElement(private val array: List<Int>) {

    fun quickSelect(kthSmallest: Int): Int {
        var left = 0
        var right = array.size - 1
        val list = array.toMutableList()

        while(left <= right) {
            val pivotIndex = Random.nextInt(left, right + 1)
            val partitionIndex = partition(pivotIndex, list, left, right)

            when {
                partitionIndex == kthSmallest -> {
                    return list[partitionIndex]
                }
                partitionIndex > kthSmallest -> {
                    right = partitionIndex - 1
                }
                else -> {
                    left = partitionIndex + 1
                }
            }
        }
        return -1
    }

    fun medianSelect(kthSmallest: Int): Int {
        val list = array.toMutableList()
        return medianSelect(list, 0, list.size - 1, kthSmallest)
    }

    private fun medianSelect(
            list: MutableList<Int>,
            left: Int,
            right: Int,
            k: Int): Int {

        if(k < 0 && k >= right - left + 1) {
            return -1
        }

        val size = right - left + 1
        var medianGroupSize = size / 5

        val medians = mutableListOf<Int>()
        for(i in 0 until medianGroupSize) {
            val begin = left + i * 5
            val end = begin + 5
            medians.add(findMedian(list.slice(begin until end)))
        }

        if(medianGroupSize * 5 < size) {
            val begin = left + medianGroupSize * 5
            val end = begin + (size % 5)
            medians.add(findMedian(list.slice(begin until end)))
            medianGroupSize++
        }

        val medOfMed =
                if (medianGroupSize == 1) {
                    medians[medianGroupSize - 1]
                } else {
                    medianSelect(medians, 0, medianGroupSize - 1, medianGroupSize / 2)
                }

        val medOfMedIndex = list.indexOf(medOfMed)
        val pos = partition(medOfMedIndex, list, left, right)

        if(pos-left == k - 1)
            return list[pos]
        if(pos-left > k - 1)
            return medianSelect(list, left, pos - 1, k)

        return medianSelect(list, pos + 1, right, k)
    }

    private fun partition(
            pivotIndex: Int,
            list: MutableList<Int>,
            left: Int,
            right: Int): Int {
        val pivot = list[pivotIndex]
        Collections.swap(list, pivotIndex, right)

        var position = left
        for(i in left until right) {
            if(list[i] < pivot) {
                Collections.swap(list, position, i)
                position++
            }
        }

        Collections.swap(list, position, right)
        return position
    }

    private fun findMedian(array: List<Int>) : Int {
        val sortedArr = array.sorted()
        return sortedArr[sortedArr.size / 2]
    }
}

private const val LIST_SIZE = 101
class KthSmallestElementTest {

    val list = List<Int>(LIST_SIZE) { Random.nextInt(0, 100) }
    private val sortedList = list.sorted()
    private val kthSmallestElement = KthSmallestElement(list)

    @Test
    fun smallestElementNTest() {
        var expected = 0
        var result = 0

        for(i in 0..9) {
            expected = sortedList[i]
            result = kthSmallestElement.quickSelect(i)
            assertEquals(expected, result)
        }

        expected = sortedList[10]
        result = kthSmallestElement.medianSelect(10)
        assertEquals(expected, result)
    }
}