package data_structures

class BinaryTree<T>: Collection<T> {

    class Node<T>(var data: T) {
        var left: Node<T>? = null
        var right: Node<T>? = null
    }

    public override var size: Int = 0
        private set

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
}