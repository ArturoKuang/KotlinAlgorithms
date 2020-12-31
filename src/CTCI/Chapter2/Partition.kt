package CTCI.Chapter2

fun partition(linkedList: LinkedList, pivot: Int): Node? {
    var head: Node? = linkedList.head
    var tail: Node? = linkedList.head
    var currentNode = linkedList.head

    while(currentNode != null) {
        val next = currentNode.next
        if(currentNode.data < pivot) {
            currentNode.next = head
            head = currentNode
        } else {
            tail?.next = currentNode
            tail = currentNode
        }
        currentNode = next
    }
    tail?.next = null
    return head
}

fun main() {
    val list = createLinkedList()
    val head = partition(list, 3)
    println(head)
}