package data_structures

class Trie {
    private var root: TrieNode = TrieNode()

    fun insert(word: String) {
        var currentNode: TrieNode = root

        for(char in word) {
            currentNode = currentNode.children.computeIfAbsent(char) {
                TrieNode()
            }
        }
        currentNode.isWord = true
    }

    fun find(word: String): Boolean {
        var currentNode: TrieNode = root

        for(i in word.indices) {
            val character = word[i]
            val node: TrieNode = currentNode.children[character] ?: return false
            currentNode = node
        }
        return true
    }

    fun remove(word: String) {
        remove(root, word, 0)
    }

    private fun remove(current: TrieNode, word: String, index: Int) : Boolean {
        if(index == word.length) {
            if(!current.isWord) {
                return false
            }
            current.isWord = false
            return current.children.isEmpty()
        }

        var ch: Char = word[index]
        val node: TrieNode = current.children[ch] ?: return false

        val shouldDeleteCurrentNode: Boolean = remove(node, word, index + 1)
                && !node.isWord

        if(shouldDeleteCurrentNode) {
            current.children.remove(ch)
            return current.children.isEmpty()
        }

        return false
    }
}