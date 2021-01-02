package CTCI.Chapter4


private const val ARRAY_SIZE = 10
fun createTree(): TreeNode? {
    val arr = IntArray(ARRAY_SIZE) { it }
    return createMinimalBST(arr)
}