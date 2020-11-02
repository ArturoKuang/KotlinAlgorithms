package data_structures

import org.junit.jupiter.api.Test
import kotlin.math.exp
import kotlin.random.Random
import kotlin.test.assertEquals

class HeapTest {

    @Test
    fun test() {
        var heap = Heap()
        var expected = List<Int>(100) { Random.nextInt(0, 100) }

        for (i in expected) {
            heap.insert(i)
        }

        var sortedList = expected.sorted().toMutableList()

        assertEquals(sortedList, heap.toSortedList())
    }
}