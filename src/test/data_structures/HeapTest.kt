package data_structures

import org.junit.jupiter.api.Test
import kotlin.random.Random
import kotlin.test.assertEquals

class HeapTest {

    @Test
    fun test() {
        var heap = Heap()
        var expected = MutableList<Int>(100) { Random.nextInt(0, 100) }

        for (i in expected) {
            heap.insert(i)
        }

        assertEquals(heap.toList(), expected.sorted())

        heap.remove(expected[0])
        heap.remove(expected[83])
        heap.remove(expected[25])
        expected.removeAt(0)
        expected.removeAt(83)
        expected.removeAt(25)

        assertEquals(heap.toList(), expected.sorted())
    }


}