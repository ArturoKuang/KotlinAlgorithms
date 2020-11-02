package data_structures.graphs

import java.util.*

class BFS(private val graph: UDWeightedGraph<String>) {

    fun shortestPath(start: String, end: String): List<String> {
        val paths = solve(start)
        return reconstructPath(paths, start, end)
    }

    private fun solve(start: String): MutableMap<String, String> {
        val prev = mutableMapOf<String, String>()
        val queue: Queue<String> = LinkedList<String>()
        var visited = mutableMapOf<String, Boolean>().withDefault { false }

        queue.add(start)
        visited[start] = true

        while(queue.isNotEmpty()) {
            val currentNode = queue.poll()
            val neighbors = graph.adjacentVertices(currentNode)
            for (nextNode in neighbors) {
                if(visited[nextNode] == true) {
                    continue
                }

                visited[nextNode] = true
                prev[nextNode] = currentNode
                queue.add(nextNode)
            }
        }

        return prev
    }

    private fun reconstructPath(prev: MutableMap<String, String>, start: String, end: String): List<String> {
        val result = mutableListOf<String>()
        var currentNode: String? = end

        while (prev[currentNode] != null && currentNode != null) {
            result.add(currentNode)
            currentNode = prev[currentNode]
        }
        result.add(start)
        result.reverse()

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
    val shortestPathGenerator = BFS(graph)

    println(shortestPathGenerator.shortestPath("b", "c").joinToString())
}