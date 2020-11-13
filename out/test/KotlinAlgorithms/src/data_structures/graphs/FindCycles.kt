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

    if(recStack[node]) {
        return true
    }

    if(visited[node]) {
        return false
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

fun findCyclesUndirectedGraph(graph: UDWeightedGraph<Int>): Boolean {
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

    private fun createDGNoCycle(): DirectedWeightGraph<Int> {
        val graph = DirectedWeightGraph<Int>()
        graph.addEdge(0, 1, 1)
        graph.addEdge(2, 3, 1)
        return graph
    }

    @Test
    fun undirectedGraph() {

    }
}