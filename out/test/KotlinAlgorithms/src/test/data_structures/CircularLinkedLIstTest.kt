package data_structures

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse

class CircularLinkedLIstTest {

    @Test
    fun addAtFrontTest() {
        val list = CircularLinkedList()
        val expected = listOf(10, 20)
        list.addAtFront(20)
        list.addAtFront(10)

        assertEquals(list.toList(), expected)
    }

    @Test
    fun isEmptyTest() {
        val list = CircularLinkedList()
        assert(list.isEmpty())

        list.addAtFront(5)
        list.remove(5)
        assert(list.isEmpty())
    }

    @Test
    fun addAtEndTest(){
        val list = CircularLinkedList()
        val expected = listOf(10, 20)
        list.addAtEnd(10)
        list.addAtEnd(20)

        assertEquals(list.toList(), expected)
    }

    @Test
    fun searchTest() {
        val list = CircularLinkedList()
        for(i in 0..100) {
            list.addAtEnd(i)
        }

        assert(list.search(10))
        assert(list.search(89))
        assertFalse(list.search(-1))
    }

    @Test
    fun deleteNodeTest() {
        val list = CircularLinkedList()
        for(i in 0..100) {
            list.addAtEnd(i)
        }

        list.remove(10)
        assertFalse(list.search(10))
    }

    @Test
    fun deleteEmptyTest() {
        val list = CircularLinkedList()
        throwSuchElementException {
            list.remove(10)
        }
    }

    private fun throwSuchElementException(f: () -> Unit ) {
        try {
            f()
            Assertions.fail<String>("NoSuchElementException expected")
        } catch (expectedException: NoSuchElementException) { }
    }
}