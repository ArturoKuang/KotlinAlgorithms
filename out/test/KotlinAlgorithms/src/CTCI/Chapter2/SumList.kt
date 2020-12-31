package CTCI.Chapter2

fun sumList(l1: LinkedList, l2: LinkedList): Node? {
    return sumListHelper(l1.head, l2.head, 0)
}

fun sumListHelper(l1: Node?, l2: Node?, carry: Int = 0): Node? {
    if(l1 == null && l2 == null && carry == 0) {
        return null
    }

    var sum = carry
    if(l1 != null) {
        sum += l1.data
    }
    if(l2 != null) {
        sum += l2.data
    }

    val result = Node(sum % 10)
    val more = sumListHelper(l1?.next, l2?.next, if (sum >= 10) 1 else 0 )
    result.next = more

    return result
}

fun main() {
    val l1 = LinkedList(listOf(9,9,9,9))
    val l2 = LinkedList(listOf(9,9))

    sumList(l1, l2)
    println(sumList(l1, l2))
}