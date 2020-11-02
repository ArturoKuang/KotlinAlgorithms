package data_structures

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.lang.Exception
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class BinaryTreeTest {
    private val testList = listOf(50, 40, 30, 20, 80, 60, 70)

    @Test
    fun removeEmptyTree() {
        var tree = BinaryTree<Int>()
        try {
            removeAndAssert(tree)
        } catch (expectedException: Exception) { }
    }

    private fun removeAndAssert(tree: BinaryTree<Int>) {
        tree.remove(10)
        Assertions.fail<String>("Can not remove from an empty tree")
    }

    @Test
    fun addTest() {
        var tree = createBinaryTreeFromList(testList)
        assertTrue(tree.containsAll(testList), "Not all added elements were found in the tree")
    }

    @Test
    fun isBinarySearchTreeTest() {
        val tree = createBinaryTreeFromList(testList)
    }

    @Test
    fun sizeTest() {
        val listSize = 1000
        val numRemove = 200
        val list = (0..listSize).toList()
        val tree = createBinaryTreeFromList(list)
        for(i in 0..numRemove) {
            tree.remove(i)
        }
        assertEquals(tree.size, listSize - numRemove, "Size of tree is wrong")
    }

    @Test
    fun removeTest() {
        var tree = createBinaryTreeFromList(testList)

        isNodeRemoved(tree,20)
        isNodeRemoved(tree,30)
        isNodeRemoved(tree,50)
    }

    private fun isNodeRemoved(tree: BinaryTree<Int>, value: Int) {
        tree.remove(value)
        Assertions.assertFalse(tree.find(value), "Did not removed node when remove() was called")
    }


    private fun createBinaryTreeFromList(list: List<Int>): BinaryTree<Int> {
        var tree = BinaryTree<Int>()
        for (element in list) {
            tree.add(element)
        }
        return tree
    }
}