package sorts

class MergeSort : Sort {

    override fun <T : Comparable<T>> sortArr(arr: Array<T>) {
        val aux = arr.clone()
        sort(arr, aux, 0, arr.size -1)
    }

    private fun <T : Comparable<T>> sort(arr: Array<T>, aux: Array<T>, low: Int, high: Int) {
        if(low >= high)
            return

        val mid = (low+high) / 2
        sort(arr, aux, low, mid)
        sort(arr, aux, mid + 1, high)
        merge(arr, aux, low, mid, high)
    }

    private fun <T: Comparable<T>> merge(arr: Array<T>, aux: Array<T>, low: Int, mid: Int, high: Int) {
        System.arraycopy(arr, low, aux, low, high - low + 1)

        var lowIndex = low
        var highIndex = mid + 1
        for (i in low..high) {
            when {
                lowIndex > mid -> {
                    arr[i] = aux[highIndex++]
                }
                highIndex > high -> {
                    arr[i] = aux[lowIndex++]
                }
                aux[highIndex] < aux[lowIndex] -> {
                    arr[i] = aux[highIndex++]
                }
                else -> {
                    arr[i] = aux[lowIndex++]
                }
            }
        }
    }
}