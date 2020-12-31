package CTCI.Chapter2

import java.lang.StringBuilder

data class Node(var data: Int, var next: Node? = null) {
    override fun toString(): String {
        var current: Node? = this
        val sb = StringBuilder()
        sb.append("[ ")
        while (current?.next != null) {
            sb.append("${current.data}, ")
            current = current.next
        }
        sb.append("${current?.data}")
        sb.append(" ]")
        return sb.toString()
    }
}

class LinkedList() {
    var tail: Node? = null
    var head: Node? = null

    constructor(list: List<Int>): this() {
        for(element in list) {
            this.append(element)
        }
    }

    fun append(element: Int): Node? {
        if (head == null) {
            head = Node(element)
            tail = head
        }

        tail?.next = Node(element)
        tail = tail?.next
        return tail
    }

    override fun toString(): String {
        return head.toString()
    }
}

// 1 2 1 4 4 3 5 2 1
fun createLinkedList(): LinkedList {
    return LinkedList(listOf(1,2,1,4,4,3,5,2,1))
}