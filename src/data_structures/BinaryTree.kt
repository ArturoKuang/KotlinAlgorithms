package data_structures

class BinaryTree<T>: Collection<T> {

    class Node<T>(var data: T) {
        var left: Node<T>? = null
        var right: Node<T>? = null
    }

    public override var size: Int = 0
        private set
    private var parent: Node<T>? = null

    fun add(data: T) {

    }

    fun remove(data: T): Node<T>? {

    }

    fun find(data: T): Boolean {

    }

    fun find(node: Node<T>?): Boolean {

    }

    override fun contains(element: T): Boolean {
        TODO("Not yet implemented")
    }

    override fun containsAll(elements: Collection<T>): Boolean {
        TODO("Not yet implemented")
    }

    override fun isEmpty(): Boolean {
        TODO("Not yet implemented")
    }

    override fun iterator(): Iterator<T> {
        TODO("Not yet implemented")
    }

    fun checkBinarySearchTree(): Boolean {

    }
}