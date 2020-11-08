package sorts


data class Edge(var from: Int, var to: Int, var weight: Int)

private fun dfs(
        i: Int, at: Int, visited: BooleanArray, ordering: IntArray, graph: Map<Int, List<Edge>>): Int {

    var index = i
    visited[at] = true
    val edges = graph[at]

    edges?.forEach { (_, to) ->
        if (!visited[to]) {
            index = dfs(index, to, visited, ordering, graph)
        }
    }

    ordering[i] = at
    return index - 1
}

fun topologicalSort(graph: Map<Int, List<Edge>>, numNodes: Int): IntArray {
    val ordering = IntArray(numNodes)
    val visited = BooleanArray(numNodes)
    var i = numNodes - 1

    for (at in 0 until numNodes) {
        if (!visited[at])
        {
            i = dfs(i, at, visited, ordering, graph)
        }
    }

    return ordering
}

fun dagShortestPath(graph: Map<Int, List<Edge>>, from: Int, to: Int): Array<Int> {

}

fun main() {
    val N = 7
    val graph = mutableMapOf<Int, MutableList<Edge>>()
    for(i in 0 until N) {
        graph[i] = mutableListOf<Edge>()
    }
    graph[0]?.add(Edge(0, 1, 3))
    graph[0]?.add(Edge(0, 5, 3))
    graph[0]?.add(Edge(0, 2, 2))
    graph[1]?.add(Edge(1, 3, 1))
    graph[1]?.add(Edge(1, 2, 6))
    graph[2]?.add(Edge(2, 3, 1))
    graph[2]?.add(Edge(2, 4, 10))
    graph[3]?.add(Edge(3, 4, 5))
    graph[5]?.add(Edge(5, 4, 7))

    val ordering: IntArray = topologicalSort(graph, N)
    println(ordering.contentToString())

    val dists: Array<Int> = dagShortestPath(graph, 0, N)

    // Find the shortest path from 0 to 4 which is 8.0
    println(dists[4])

    // Find the shortest path from 0 to 6 which
    // is null since 6 is not reachable!
    println(dists[6])
}
