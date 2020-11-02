package recursion

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

const val UTF8_COUNT = 256

class StringPermutationTest() {

    private val stringPermutation: StringPermutation = StringPermutation()

    @Test
    fun singleLetterTest() {
        val result = stringPermutation.generatePermutation("a")
        Assertions.assertEquals(result, setOf("a"))
    }

    @Test
    fun twoLetterTest() {
        val result = stringPermutation.generatePermutation("ab")
        Assertions.assertEquals(result, setOf("ab", "ba"))
    }

    @Test
    fun threeLetterTest() {
        val result = stringPermutation.generatePermutation("abc")
        Assertions.assertEquals(result, setOf("abc", "acb", "bac", "bca", "cba", "cab"))
    }

    @Test
    fun nLetterTest() {
        val string = "abcdefgh"
        val result = stringPermutation.generatePermutation(string)
        var set = HashSet<String>()
        for (permutation in result) {
            Assertions.assertTrue(checkPermutation(string, permutation))
            Assertions.assertFalse(set.contains(permutation))
            set.add(permutation)
        }
    }

    private fun checkPermutation(result: String, b: String): Boolean {
        var charTable = Array<Int>(UTF8_COUNT) { 0 }

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