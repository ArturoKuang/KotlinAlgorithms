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
        var partitionIndex = low - 1

        for(index in low until high) {
            if(arr[index] < pivot) {
                partitionIndex++
                arr.swap(partitionIndex, index)
            }
        }
        arr.swap(partitionIndex + 1, high)
        return partitionIndex + 1
    }

}