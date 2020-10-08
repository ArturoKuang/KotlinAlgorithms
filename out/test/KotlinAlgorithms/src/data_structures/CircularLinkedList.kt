package data_structures

class CircularLinkedList {
    private var size: Int = 0
    private var head: Node? = null
    private var tail: Node? = null

    private class Node(var data: Int) {
        var next: Node? = null
    }

    fun isEmpty(): Boolean = size == 0

    fun addAtFront(element: Int) {
        if(head == null && tail == null) {
            addHeadAndTail(element)
        } else {
            var newHead: Node? = Node(element)
            newHead?.next = head
            head = newHead
            tail?.next = newHead
        }
        size++
    }

    fun addAtEnd(element: Int) {
        if(head == null && tail == null) {
            addHeadAndTail(element)
        } else {
            var newTail = Node(element)
            newTail.next = head

            tail?.next = newTail
            tail = newTail
        }
        size++
    }

    private fun addHeadAndTail(element: Int) {
        head = Node(element)
        tail = head

        head!!.next = tail
    }

    @Throws
    fun remove(element: Int): Boolean {
        if(size <= 0) {
            throw NoSuchElementException()
        }

        var old = searchNode(element) ?: return false
        val newNode = old.next

        old.data = newNode!!.data
        old.next = newNode.next
        size--
        return true
    }

    fun search(element: Int): Boolean = searchNode(element) != null

    private fun searchNode(element: Int): Node? {
        var runner: Node? = head ?: return null

        do {
            if(runner?.data == element) {
                return runner
            }
            runner = runner?.next
        } while (runner != head)

        return null
    }

    fun toList(): List<Int> {
        var list = mutableListOf<Int>()
        var runner: Node? = head ?: return list

        do {
            list.add(runner!!.data)
            runner = runner.next
        } while(runner != head)

        return list
    }
}