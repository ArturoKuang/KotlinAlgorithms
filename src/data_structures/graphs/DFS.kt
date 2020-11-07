package data_structures.graphs

class DFS(private val graph: UDWeightedGraph<String>) {

    fun checkPathExist(start: String, end: String): Boolean {
        val visited = mutableMapOf<String, Boolean>().withDefault { false }
        return traverse(start, end, visited)
    }

    private fun traverse(currentNode: String, end: String, visited: MutableMap<String, Boolean>): Boolean {
        if(visited[currentNode] == true) {
            return false
        }

        var result = false
        if(currentNode == end) {
            result = true
        }

        visited[currentNode] = true
        val neighbors = graph.adjacentVertices(currentNode)
        for (next in neighbors) {
             result = result || traverse(next, end, visited)
        }

        return result
    }
}

fun main() {

    val graph = UDWeightedGraph<String>()
    //https://visualgo.net/en/graphds
    //          b
    //         /  \
    //        a -- c
    //        | \ /
    //        |  d
    //        | /
    //        e
    graph.addEdge("a", "b", 1)
    graph.addEdge("a", "c", 1)
    graph.addEdge("a", "d", 1)
    graph.addEdge("a", "e", 1)
    graph.addEdge("b", "c", 1)
    graph.addEdge("c","a", 1)
    graph.addEdge("c","b", 1)
    graph.addEdge("c","d", 1)
    graph.addEdge("d", "a", 1)
    graph.addEdge("d", "c", 1)
    graph.addEdge("d", "e", 1)
    val dfs = DFS(graph)

    println(dfs.checkPathExist("a", "e"))
}