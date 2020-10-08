package data_structures

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFails
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class CircularLinkedLIstTest {

    @Test
    fun addAtFrontTest() {
        var list = CircularLinkedList()
        val expected = listOf(10, 20)
        list.addAtFront(20)
        list.addAtFront(10)

        assertEquals(list.toList(), expected)
    }

    @Test
    fun isEmptyTest() {
        var list = CircularLinkedList()
        assert(list.isEmpty())

        list.addAtFront(5)
        list.remove(5)
        assert(list.isEmpty())
    }

    @Test
    fun addAtEndTest(){
        var list = CircularLinkedList()
        val expected = listOf(10, 20)
        list.addAtEnd(10)
        list.addAtEnd(20)

        assertEquals(list.toList(), expected)
    }

    @Test
    fun searchTest() {
        var list = CircularLinkedList()
        for(i in 0..100) {
            list.addAtEnd(i)
        }

        assert(list.search(10))
        assert(list.search(89))
        assertFalse(list.search(-1))
    }

    @Test
    fun deleteNodeTest() {
        var list = CircularLinkedList()
        for(i in 0..100) {
            list.addAtEnd(i)
        }

        list.remove(10)
        assertFalse(list.search(10))
    }

    @Test
    fun deleteEmptyTest() {
        var list = CircularLinkedList()
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