package CTCI.Chapter2

import org.junit.jupiter.api.Test

fun removeDuplicates(linkedList: LinkedList) {
    val set = HashSet<Int>()
    var current = linkedList.head
    var uniqueHead = current

    while (current != null) {
        if(set.contains(current.data)) {
            uniqueHead?.next = current.next
        } else {
            uniqueHead = current
            set.add(current.data)
        }
        current = current.next
    }
}

class RemoveDuplicatesTest {
    @Test
    fun test() {
        val linkedList = LinkedList()
        linkedList.append(1)
        linkedList.append(2)
        linkedList.append(1)
        linkedList.append(3)
        linkedList.append(4)
        linkedList.append(4)
        linkedList.append(1)
        removeDuplicates(linkedList)
        println(linkedList)
        assert(checkDuplicates(linkedList))
    }

    private fun checkDuplicates(list: LinkedList): Boolean {
        val set = HashSet<Int>()
        var current = list.head
        while(current != null) {
            if(set.contains(current.data)) {
                return false
            }

            set.add(current.data)
            current = current.next
        }

        return true
    }
}