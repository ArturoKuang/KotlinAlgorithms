package algorithms

//fun subsets(nums: IntArray): List<List<Int>> {
//    val result = mutableListOf(emptyList<Int>())
//    nums.forEach { num ->
//        val newAdditions = result.map { it + num }
//        println("${newAdditions.joinToString()}")
//        result.addAll(newAdditions)
//    }
//    return result
//}

//Backtracking --------------------------------------------------------------
fun subsets(nums: IntArray): List<List<Int>> {
    var result = mutableListOf<List<Int>>()
    if(nums.isEmpty()) return result
    backtrack(nums, 0, result, mutableListOf<Int>(), hashSetOf<List<Int>>())
    return result
}

fun backtrack(nums: IntArray, start: Int, result: MutableList<List<Int>>, list: MutableList<Int>, hashSet: HashSet<List<Int>>)
{
    if(hashSet.contains(list)) {
        println("early exit")
        return
    }
    result.add(list.toMutableList())
    hashSet.add(list)
    for(i in start until nums.size){
        list.add(nums[i])
        backtrack(nums, i+1, result, list, hashSet)
        list.remove(nums[i])
    }
}

fun main() {
    val nums = intArrayOf(1,2,3,6,10,9,13,13)
    println(subsets(nums).joinToString())
}