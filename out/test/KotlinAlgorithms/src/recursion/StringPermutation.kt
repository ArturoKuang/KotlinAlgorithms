package recursion

import java.util.*


class StringPermutation {

    fun generatePermutation(input: String): Set<String> {
        if(input.length <= 1) {
            return setOf(input)
        }

        val allCharsExceptLast = input.substring(0, input.length - 1)
        val lastChar = input.last()

        val permutationExceptLast = generatePermutation(allCharsExceptLast)
        val permutations = HashSet<String>()

        for(permutation in permutationExceptLast) {
            for(position in 0..allCharsExceptLast.length) {
                val permutation = permutation.substring(0, position) + lastChar +
                        permutation.substring(position)
                permutations.add(permutation)
            }
        }

        return  permutations
    }

//    fun generatePermutation(inputString: String): Set<String> {
//
//        // base case
//        if (inputString.length <= 1) {
//            return HashSet(listOf(inputString))
//        }
//        val allCharsExceptLast = inputString.substring(0, inputString.length - 1)
//        val lastChar = inputString[inputString.length - 1]
//
//        // recursive call: get all possible permutations for all chars except last
//        val permutationsOfAllCharsExceptLast = generatePermutation(allCharsExceptLast)
//
//        // put the last char in all possible positions for each of the above permutations
//        val permutations: MutableSet<String> = HashSet()
//        for (permutationOfAllCharsExceptLast in permutationsOfAllCharsExceptLast) {
//            for (position in 0..allCharsExceptLast.length) {
//                val permutation = (permutationOfAllCharsExceptLast.substring(0, position) + lastChar
//                        + permutationOfAllCharsExceptLast.substring(position))
//                permutations.add(permutation)
//            }
//        }
//        return permutations
//    }
}