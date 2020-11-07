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

    fun medianSelect(kthSmallest: Int): Int {
        val list = array.toMutableList()
        return selection(list, 0, list.size - 1, kthSmallest)
    }

    private fun selection(
            list: MutableList<Int>,
            left: Int,
            right: Int,
            k: Int): Int {

        val size = right - left + 1
        if(k > 0 && k < size) {
            var i = 0
            val medians = mutableListOf<Int>()
            val groupSize = size / 5

            while (i < groupSize) {
                val begin = left + i * 5
                val end = begin + 5
                medians.add(findMedian(list.slice(begin until end)))
                i++
            }

            if(i * 5 < size) {
                val begin = left + i * 5
                val end = begin + (size % 5)
                medians.add(findMedian(list.slice(begin until end)))
                i++
            }

            val medOfMed: Int = if (i == 1) medians[i - 1] else selection(medians, 0, i - 1, i / 2)

            val pos = medianSelectPartition(list, left, right, medOfMed)

            // If position is same as k
            val positionIndex = pos - left
            val kIndex = k
            if (positionIndex == kIndex)
                return list[pos]

            if (positionIndex > kIndex)
                return selection(list, left, pos - 1, k)

            return selection(list, pos + 1, right, k - pos + left - 1)

        }

        return Int.MAX_VALUE
    }


    private fun medianSelectPartition(list: MutableList<Int>, left: Int, right: Int, x: Int): Int {
        val pivotIndex = list.indexOf(x)

        Collections.swap(list, pivotIndex, right)
        var partitionIndex = left

        for(i in left until right) {
            if(list[i] <= x) {
                Collections.swap(list, i, partitionIndex)
                partitionIndex++
            }
        }

        Collections.swap(list, partitionIndex, right)
        return partitionIndex
    }

    private fun findMedian(array: List<Int>) : Int {
        val sortedArr = array.sorted()
        return sortedArr[sortedArr.size / 2]
    }
}

private const val LIST_SIZE = 101
class KthSmallestElementTest {

    //val list = List<Int>(LIST_SIZE) { Random.nextInt(0, 100) }
    val list = listOf(0, 2, 9, 8, 5, 3, 4, 6, 10, 1, 12)
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

        expected = sortedList[2]
        result = kthSmallestElement.medianSelect(2)

        assertEquals(expected, result)
    }
}