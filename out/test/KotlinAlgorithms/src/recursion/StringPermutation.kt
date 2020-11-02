package recursion

import java.util.*


class StringPermutation {

    fun generatePermutation(input: String): Set<String> {
        if (input.length <= 1) {
            return setOf(input)
        }

        val allCharsExceptLast = input.substring(0, input.length - 1)
        val lastChar = input.last()

        val permutationExceptLast = generatePermutation(allCharsExceptLast)
        val permutations = HashSet<String>()

        for (permutation in permutationExceptLast) {
            for (position in 0..allCharsExceptLast.length) {
                val permutation = permutation.substring(0, position) + lastChar +
                        permutation.substring(position)
                permutations.add(permutation)
            }
        }

        return permutations
    }
}