package datastructures

class SLList {
    constructor(data: Int) {
        root = Node()
        root.data = data
    }

    class Node() {
        var data: Int? = null
        var next: Node? = null
    }

    private var root: Node? = null
    private var size: Int = 0
    
    fun insert(data: Int) {

    }
    fun removeFirst() {}
    fun removeLast() {}
    fun remove(data: Int) {}
    fun getSize(): Int { return this.size }
    fun search(data: Int): Node? { }
}