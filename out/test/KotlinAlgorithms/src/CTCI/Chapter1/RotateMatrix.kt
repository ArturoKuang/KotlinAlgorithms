package CTCI.Chapter1

import org.junit.jupiter.api.Test

//Times visited : 1
fun rotateMatrix(matrix: MutableList<MutableList<Int>>) {
    val length = matrix.size - 1
    for (layer in 0 until matrix.size / 2) {
        val first = layer
        val last = length - layer
        for (i in first until last) {
            val offset = i - first
            var top = matrix[first][i]
            // left -> top
            matrix[first][i] = matrix[last - offset][first]
            // bottom -> left
            matrix[last - offset][first] = matrix[last][last - offset]
            // right -> bottom
            matrix[last][last - offset] = matrix[i][last]
            // top -> right
            matrix[i][last] = top
        }
    }
}


private const val SIZE = 10

fun main() {
    val matrix = MutableList(SIZE) { col ->
        MutableList(SIZE) { row ->
            (row * col) % 10
        }
    }

    printMatrix(matrix)
    rotateMatrix(matrix)
    println("\nRotated")
    printMatrix(matrix)

}

private fun printMatrix(matrix: MutableList<MutableList<Int>>) {
    println("MATRIX:\n${matrix.joinToString("\n")}")
}