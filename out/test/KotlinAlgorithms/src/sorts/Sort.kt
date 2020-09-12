package sorts

interface Sort {
    fun <T: Comparable<T>> sortArr(arr: Array<T>)
}

fun <T> Array<T>.swap(i: Int, j: Int) {
    val tmp = this[i]
    this[i] = this[j]
    this[j] = tmp
}







