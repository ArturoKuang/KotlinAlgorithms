package data_structures

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import kotlin.math.exp
import kotlin.test.assertEquals
import kotlin.test.assertFails

class CircularLinkedLIstTest {

    @Test
    fun addAtFrontTest() {
        CircularLinkedList list = CircularLinkedList()
        val expected = listOf(10, 20)
        list.addAtFront(20)
        list.addAtFront(10)

        assertEquals(list.toList(), expected)
    }

    @Test
    fun isEmptyTest() {
        CircularLinkedList list = CircularLinkedList()
        assert(list.isEmpty())

        list.addAtFront(5)
        list.delete(5)
        assert(list.isEmpty())
    }

    @Test
    fun addAtEndTest(){
        CircularLinkedList list = CircularLinkedList()
        val expected = listOf(10, 20)
        list.addAtEnd(10)
        list.addAtEnd(20)

        assertEquals(list.toList(), expected)
    }

    @Test
    fun searchTest() {
        CircularLinkedList list = CircularLinkedList()
        for(i in 0..100) {
            list.addAtEnd(i)
        }

        assert(list.search(10))
        assert(list.search(89))
    }

    @Test
    fun deleteNodeTest() {
        CircularLinkedList list = CircularLinkedList()
        for(i in 0..100) {
            list.addAtEnd(i)
        }

        list.remove(10)
        assertFails(list.search(10))
    }

    @Test
    fun deleteEmptyTest() {
        CircularLinkedList list = CircularLinkedList()
        throwSuchElementException {
            list.remove(10)
        }
    }

    fun throwSuchElementException(f: () -> Unit ) {
        try {
            f()
            Assertions.fail<String>("NoSuchElementException expected")
        } catch (expectedException: NoSuchElementException) { }
    }
}