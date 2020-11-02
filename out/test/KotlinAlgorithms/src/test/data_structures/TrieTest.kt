package data_structures

import org.junit.jupiter.api.Test
import kotlin.test.assertFalse

class TrieTest {

    @Test
    fun search() {
        var trie = Trie()
        var wordList = listOf("Programming", "is", "a", "way", "of", "life")
        for (word in wordList) {
            trie.insert(word)
        }

        for (word in wordList) {
            assert(trie.find(word))
        }

        assertFalse(trie.find("hand"))
    }

    @Test
    fun delete() {
        var trie = Trie()
        var wordList = listOf("Programming", "is", "a", "way", "of", "life")
        for (word in wordList) {
            trie.insert(word)
        }

        trie.remove("Programm")
        for (word in wordList) {
            trie.remove(word)
            assertFalse(trie.find(word), "word: $word")
        }
    }
}