package CTCI.Chapter4

import CTCI.Chapter4.BTreePrinter.printNode
import kotlin.random.Random

data class TreeNode(
        var data: Int,
        var left: TreeNode? = null,
        var right: TreeNode? = null) {


}

fun createMinimalBST(arr: IntArray): TreeNode? {
    return createMinimalBST(0, arr.size - 1, arr)
}

fun createMinimalBST(left: Int, right: Int, arr: IntArray): TreeNode? {
    if(left > right) {
        return  null
    }

    val middle = (left+right) / 2
    val node = TreeNode(arr[middle])
    node.left = createMinimalBST(left, middle - 1, arr)
    node.right = createMinimalBST(middle + 1, right, arr)
    return  node
}

fun main() {
    var arr = IntArray(10) {
        Random.nextInt(10)
    }
    arr.sort()
    println("Array: ${arr.joinToString()}")
    printNode<Int>(createMinimalBST(arr))
}