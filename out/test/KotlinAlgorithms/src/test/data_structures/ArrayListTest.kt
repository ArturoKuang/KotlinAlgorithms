package data_structures

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class ArrayListTest {

    @Test
    fun add(){
        var arr = ArrayList()
        var result = mutableListOf<Int>()

        for(i in 0..100) {
            arr.add(i)
            result.add(i)
        }

        assertEquals(arr.toList(), result)
    }

    @Test
    fun remove() {
        var arr = ArrayList()
        var result = mutableListOf<Int>()
        for(i in 0..100) {
            arr.add(i)
            result.add(i)
        }

        for(i in 0..100 step 2) {
            arr.remove(i)
            result.remove(i)
        }

        assertEquals(arr.toList(), result)
    }

    @Test
    fun insert() {
        var arr = ArrayList()
        var result = mutableListOf<Int>()
        for(i in 0..100) {
            arr.add(i)
            result.add(i)
        }

        for(i in 0..100 step 2) {
            arr.insert(i, i)
            result.add(i, i)
        }

        assertEquals(arr.toList(), result)
    }

    @Test
    fun find() {
        var arr = ArrayList()
        arr.add(1)
        arr.add(2)

        assert(arr.find(1))
        assertFalse(arr.find(5))
    }
}