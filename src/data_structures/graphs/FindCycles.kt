package data_structures.graphs

import org.junit.jupiter.api.Test
import kotlin.test.assertFalse

fun findCyclesDirectedGraph(graph: DirectedWeightGraph<Int>): Boolean {
    val isVisited = MutableList<Boolean>(graph.nodeCount) { false }
    val recStack = MutableList<Boolean>(graph.nodeCount) { false }

    for(node in graph.vertices()) {
        if(dfsCycleDetect(graph, node, isVisited, recStack))
            return true
    }

    return false
}

private fun dfsCycleDetect(
        graph: DirectedWeightGraph<Int>,
        node: Int,
        visited: MutableList<Boolean>,
        recStack: MutableList<Boolean>): Boolean {

    if(visited[node]) {
        return false
    }

    if(recStack[node]) {
        return true
    }

    visited[node] = true
    recStack[node] = true
    val neighbors = graph.adjacentVertices(node)
    for(neighbor in neighbors) {
        if(dfsCycleDetect(graph, node, visited, recStack))
            return true
    }

    recStack[node] = false
    return false
}

fun findCyclesUndirectedGraph(graph: UDWeightedGraph<String>): Boolean {
    var visited = mutableSetOf<String>()
    for(node in graph.vertices()){
        if(visited.contains(node)) {
            continue
        }

        if(dfsCycleUDGraph(graph, visited, node, "")) {
            return true
        }
    }

    return false
}

private fun dfsCycleUDGraph(
        graph: UDWeightedGraph<String>,
        visited: MutableSet<String>,
        current: String,
        parent: String): Boolean {

    visited.add(current)
    val neighbors = graph.vertices()

    for(neighbor in neighbors) {
        if(parent == neighbor)
            continue

        if(visited.contains(neighbor)) {
            return true
        }

        if(dfsCycleUDGraph(graph, visited, neighbor, current)) {
            return true
        }
    }
    return false
}


class CycleTest() {

    @Test
    fun testDirectedGraph() {
        var graph = createDGCycle()
        assert(findCyclesDirectedGraph(graph))
    }

    private fun createDGCycle(): DirectedWeightGraph<Int> {
        val graph = DirectedWeightGraph<Int>()
        graph.addEdge(0, 1, 1)
        graph.addEdge(0, 2, 1)
        graph.addEdge(1, 2, 1)
        graph.addEdge(1, 3, 1)
        graph.addEdge(2, 1, 1)
        graph.addEdge(3, 1, 1)
        graph.addEdge(3, 4, 1)
        graph.addEdge(4, 2, 1)
        graph.addEdge(4, 3, 1)
        graph.addEdge(4, 5, 1)
        graph.addEdge(5, 6, 1)
        return graph
    }

    @Test
    fun undirectedGraph() {
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
        assert(findCyclesUndirectedGraph(graph))
    }
}