package sorts

class QuickSort : Sort {
    override fun <T : Comparable<T>> sortArr(arr: Array<T>) {
        sortArr(arr, 0, arr.size - 1)
    }

    private fun <T : Comparable<T>> sortArr(arr: Array<T>, low: Int, high: Int) {
        if (low >= high)
            return

        val partitionIndex = partition(arr, low, high)
        sortArr(arr, low, partitionIndex - 1)
        sortArr(arr, partitionIndex + 1, high)
    }

    private fun <T : Comparable<T>> partition(arr: Array<T>, low: Int, high: Int): Int {
        val pivot =  arr[high]
        var partitionIndex = low

        for(index in low until high) {
            if(arr[index] < pivot) {
                arr.swap(partitionIndex, index)
                partitionIndex++
            }
        }
        arr.swap(partitionIndex, high)
        return partitionIndex
    }

}