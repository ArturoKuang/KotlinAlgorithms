package data_structures

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class BinaryTreeTest {
    @Test
    fun removeEmptyTree() {
        var tree = BinaryTree<Int>()
        try {
            removeAndAssert(tree)
        } catch (expectedException: NoSuchElementException) { }
    }

    private fun removeAndAssert(tree: BinaryTree<Int>) {
        tree.remove(10)
        Assertions.fail<String>("Expected No such NoSuchElementException()")
    }

    @Test
    fun addTest() {
        val list = (0..100).toList()
        var tree = createBinaryTreeFromList(list)

        assertTrue(tree.containsAll(list), "Not all added elements were found in the tree")
    }

    @Test
    fun isBinarySearchTreeTest() {
        val list = (0..100).toList()
        val tree = createBinaryTreeFromList(list)
        assertTrue(tree.checkBinarySearchTree(), "This is not a valid binary search tree")
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
        val list = listOf(20, 30, 40, 50, 60, 70, 80)
        var tree = createBinaryTreeFromList(list)

        isNodeRemoved(tree,20)
        isNodeRemoved(tree,30)
        isNodeRemoved(tree,50)

    }

    private fun isNodeRemoved(tree: BinaryTree<Int>, value: Int) {
        val removedNode = tree.remove(value)
        Assertions.assertFalse(tree.find(removedNode), "Did not removed node when remove() was called")
        Assertions.assertFalse(tree.checkBinarySearchTree(), "Tree is not a BinarySearchTree after removing")
    }


    private fun createBinaryTreeFromList(list: List<Int>): BinaryTree<Int> {
        var tree = BinaryTree<Int>()
        for (element in list) {
            tree.add(element)
        }
        return tree
    }
}