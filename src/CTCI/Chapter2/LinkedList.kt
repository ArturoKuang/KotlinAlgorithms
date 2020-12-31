package CTCI.Chapter2

import java.lang.StringBuilder

data class Node(var data: Int, var next: Node? = null)

class LinkedList {
    var tail: Node? = null
    var head: Node? = null

    fun append(element: Int): Node? {
        if(head == null) {
            head = Node(element)
            tail = head
        }

        tail?.next = Node(element)
        tail = tail?.next
        return tail
    }

    override fun toString(): String {
        var current = head
        val sb = StringBuilder()
        sb.append("[ ")
        while(current?.next != null) {
            sb.append("${current.data}, ")
            current = current.next
        }
        sb.append("${current?.data}")
        sb.append(" ]")
        return sb.toString()
    }
}