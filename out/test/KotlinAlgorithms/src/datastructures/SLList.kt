package datastructures

class SLList {
    constructor(data: Int) {
        root = Node(data)
    }

    class Node(var data: Int? = null, var next: Node? = null) { }

    private var root: Node? = null
}