package interview_cake

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class WorldCloudTest() {

    @Test
    fun noPunctuationTest() {
        val input = "I ate at a pizza store tonight i went to the zoo"
        val expectedOutput = mapOf(
                "i" to 2,
                "ate" to 1,
                "at" to 1,
                "a" to 1,
                "pizza" to 1,
                "store" to 1,
                "tonight" to 1,
                "went" to 1,
                "to" to 1,
                "the" to 1,
                "zoo" to 1)

        val wordCloud = WordCloud().createWordCloud(input)
        Assertions.assertEquals(expectedOutput, wordCloud, "createWorldCloud() unexpected word count")
    }

    @Test
    fun punctuationTest() {
        val input =   "We came, we saw, we conquered...then we ate Bill's (Mille-Feuille) cake." +
                " The bill came to five dollars."

        val expectedOutput = mapOf(
                "we" to 4,
                "came" to 2,
                "saw" to 1,
                "saw" to 1,
                "conquered" to 1,
                "then" to 1,
                "ate" to 1,
                "bill's" to 1,
                "mille-feuille" to 1,
                "cake" to 1,
                "the" to 1,
                "bill" to 1,
                "came" to 2,
                "to" to 1,
                "five" to 1,
                "dollars" to 1)

        val wordCloud = WordCloud().createWordCloud(input)
        Assertions.assertEquals(expectedOutput, wordCloud, "createWorldCloud() unexpected word count")
    }
}