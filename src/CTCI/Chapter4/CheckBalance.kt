package CTCI.Chapter4

import kotlin.math.abs
import kotlin.math.max

fun checkBalance(root: TreeNode?): Boolean {
    return checkHeight(root) != Int.MIN_VALUE
}

fun checkHeight(node: TreeNode?): Int {
    if(node == null) {
        return -1
    }

    val leftHeight = checkHeight(node.left)
    if(leftHeight == Int.MIN_VALUE) {
        return Int.MIN_VALUE
    }

    val rightHeight = checkHeight(node.right)
    if(rightHeight == Int.MIN_VALUE) {
        return Int.MIN_VALUE
    }

    return if(abs(leftHeight - rightHeight) > 1) {
        Int.MIN_VALUE
    } else {
        max(leftHeight, rightHeight) + 1
    }
}

fun main() {
    val root = createTree()
    BTreePrinter.printNode<Int>(root)
    println(checkBalance(root))
}