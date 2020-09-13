package recursion

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

const val UTF8_COUNT = 256

class StringPermutationTest() {

    private val stringPermutation: StringPermutation = StringPermutation()

    @Test
    fun singleLetterTest() {
        val result = stringPermutation.generateInputString("a")
        Assertions.assertEquals(result, listOf("a"))
    }

    @Test
    fun twoLetterTest() {
        val result = stringPermutation.generateInputString("ab")
        Assertions.assertEquals(result, listOf("ab", "ba"))
    }

    @Test
    fun threeLetterTest() {
        val result = stringPermutation.generateInputString("abc")
        Assertions.assertEquals(result, listOf("abc", "acb", "bac", "bca", "cba", "cab"))
    }

    @Test
    fun nLetterTest() {
        val string = "dsaokjhdwqovcx"
        val result = stringPermutation.generateInputString(string)
        var set = HashSet<String>()
        for (permutation in result) {
            Assertions.assertTrue(checkPermutation(string, permutation))
            Assertions.assertTrue(set.contains(permutation))
            set.add(permutation)
        }
    }

    private fun checkPermutation(result: String, b: String): Boolean {
        var charTable = intArrayOf(UTF8_COUNT)

        for(letter in result) {
            charTable[letter.toInt()]++
        }

        for(letter in b) {
            val letterIndex = letter.toInt()
            charTable[letterIndex]--
            if(charTable[letterIndex] < 0) {
                return  false
            }
        }

        return  true
    }

}