package data_structures

data class TrieNode(
        var character: HashMap<Char, TrieNode>,
        val content: String,
        val isWord: Boolean
) {
}