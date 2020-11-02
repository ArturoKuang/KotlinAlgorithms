package data_structures

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class LinkedListTest {
    @Test
    fun addTest() {
        var list = LinkedList<Int>()
        for(i in 0..100) {
            list.add(i)
        }

        for(i in 0..100) {
            Assertions.assertTrue(list.get(i) == i)
        }
    }

    @Test
    fun getTest() {
        var list = LinkedList<Int>()
        for(i in 0..100) {
             list.add(i)
        }

        Assertions.assertTrue(list.get(50) == 50)
    }

    @Test
    fun removeTest() {
        var list = LinkedList<Int>()
        for(i in 0..100) {
            list.add(i)
        }

        Assertions.assertTrue(list.remove(10) != null)
        Assertions.assertTrue(list.remove(50) != null)
    }

    @Test
    fun removeEmptyListTest() {
        var  list = LinkedList<Int>()
        try {
            list.removeFirst()
            list.remove(0)
            Assertions.fail<String>("NoSuchElementException expected")
        } catch (expectedException: NoSuchElementException) { }
    }
}