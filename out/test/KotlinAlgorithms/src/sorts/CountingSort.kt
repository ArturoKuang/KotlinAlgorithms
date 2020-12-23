package sorts

fun counting_sort(list: MutableList<Int>) {
    val countingArray = IntArray(if (list.max() == null) 0 else list.max()!! + 1)
    for (item in list) countingArray[item]++

    var cursor = 0
    for (index in countingArray.indices) {
        val value = index
        val numberOfOccurrences = countingArray[index]
        if (numberOfOccurrences > 0)
            repeat(numberOfOccurrences) {
                list[cursor++] = value
            }
        println("Num occurrences: $numberOfOccurrences, value: $value, cursor: $cursor, list: $list")
    }
}


fun main() {
    val unsortedList = mutableListOf(50, 90, 10, 2, 4, 6, 53, 34, 2, 1)
    counting_sort(unsortedList)

    println(unsortedList)
}