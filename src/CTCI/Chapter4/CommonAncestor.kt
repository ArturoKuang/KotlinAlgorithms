package CTCI.Chapter4

data class Result(var isAncestor: Boolean = false, var node: TreeNode? = null)


fun isCommonAncestor(root: TreeNode?, nodeA: TreeNode?, nodeB: TreeNode?): TreeNode? {
    val result = isCommonAncestorHelper(root, nodeA, nodeB)
    if (result.isAncestor) {
        return result.node
    }
    return null
}

fun isCommonAncestorHelper(root: TreeNode?, nodeA: TreeNode?, nodeB: TreeNode?): Result {
    if (root == null) {
        return Result()
    }

    if (root == nodeA && root == nodeB) {
        return Result(true, root)
    }

    val rx = isCommonAncestorHelper(root.left, nodeA, nodeB)
    if(rx.isAncestor) {
        return rx
    }

    val ry = isCommonAncestorHelper(root.right, nodeA, nodeB)
    if(ry.isAncestor) {
        return ry
    }

    if(rx.node != null && ry.node != null) {
        return Result(true, root)
    } else if (root == nodeA || root == nodeB){
        val isAncestor: Boolean = rx.node != null || ry.node != null
        return Result(isAncestor, root)
    } else {
        val ancestorNode = if(rx.node != null)
            rx.node
        else
            ry.node
        return Result(false, ancestorNode)
    }
}


fun main() {
    val root = createTree()
    val nodeA = root?.left?.right
    val nodeB = root?.right?.right?.right
    BTreePrinter.printNode<Int>(root)
    println(isCommonAncestor(root, nodeA, nodeB))
}