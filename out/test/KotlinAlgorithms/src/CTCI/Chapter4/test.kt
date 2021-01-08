package CTCI.Chapter4

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}


/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    fun deleteDuplicates(head: ListNode?): ListNode? {
        var currentNode = head
        var prev = head

        while(currentNode?.next != null) {
            var next = currentNode.next
            if(currentNode.`val` != next?.`val`) {
                prev = currentNode
            }

            if(currentNode.`val` == next?.`val`) {
                var currentDuplicate: ListNode? = currentNode
                var endDuplicate: ListNode? = currentNode

                while(endDuplicate?.next != null &&
                        endDuplicate.`val` == endDuplicate.next?.`val`) {
                    endDuplicate = endDuplicate.next
                }


                if(endDuplicate?.next == null) {
                    prev?.next = null
                    currentDuplicate = null
                } else {
                    removeNodes(currentDuplicate, endDuplicate)
                }

                next = currentDuplicate
            }
            currentNode = next
        }

        return head
    }

    fun removeNodes(node: ListNode?, nodeB: ListNode?) {
        node ?: return
        nodeB?: return

        node.`val` = nodeB.next?.`val`!!
        node.next = nodeB.next?.next
    }
}

fun main() {
    val list = listOf(2, 2, 3, 4, 4, 4)
    val root = ListNode(1)
    var currentNode: ListNode? = root
    for(element in list) {
        currentNode?.next = ListNode(element)
        currentNode = currentNode?.next
    }

    val s = Solution()
    printList(root)
    s.deleteDuplicates(root)
    printList(root)
}

fun printList(root: ListNode?) {
    println("-----------------------------")
    var currentNode: ListNode? = root
    while(currentNode != null) {
        println(currentNode.`val`)
        currentNode = currentNode.next
    }
    println("-----------------------------")
}