package data_structures.graphs

import org.junit.jupiter.api.Test
import java.util.*
import kotlin.math.min
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

var id = 0
var sccCount = 0
val stack = Stack<Int>()

private const val UNVISITED = -1
//strongly connected components
fun findSCC(graph: DirectedWeightGraph<Int>): List<Int> {
    var ids = MutableList<Int>(graph.nodeCount) { UNVISITED }
    var low = MutableList<Int>(graph.nodeCount) { 0 }
    var onStack = MutableList<Boolean>(graph.nodeCount) { false }

    for(node in graph.vertices()) {
        if(ids[node] == UNVISITED) {
            continue
        }

        dfsSCC(graph, node, ids, low, onStack)
    }
    return low
}


fun dfsSCC(
        graph: DirectedWeightGraph<Int>,
        node: Int,
        ids: MutableList<Int>,
        low: MutableList<Int>,
        onStack: MutableList<Boolean>) {

    stack.push(node)
    onStack[node] = true
    low[node] = id
    ids[node] = id
    id++

    val neighbors = graph.adjacentVertices(node)
    for (neighbor in neighbors) {
        if(ids[neighbor] == UNVISITED) {
            dfsSCC(graph, neighbor, ids, low, onStack)
        }
        if(onStack[neighbor]) {
            low[neighbor] = min(low[neighbor], low[node])
        }
    }

    if(ids[node] == low[node]) {
        while (stack.isNotEmpty()) {
            var stackNode = stack.pop()
            onStack[stackNode] = false

            low[stackNode] = sccCount
            if (stackNode == node) break
        }

        sccCount++
    }
}



class CycleTest() {

    @Test
    fun testDirectedGraph() {
        var graph = createDGCycle()
        assert(findCyclesDirectedGraph(graph))

        println(findSCC(graph))
    }

    private fun createDGCycle(): DirectedWeightGraph<Int> {
        val graph = DirectedWeightGraph<Int>()
        graph.addEdge(0, 1, 1)
        graph.addEdge(0, 2, 1)
        graph.addEdge(1, 2, 1)
        graph.addEdge(1, 3, 1)
        graph.addEdge(2, 1, 1)
        graph.addEdge(2, 0, 1)
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


        val graph2 = UDWeightedGraph<String>()
        graph.addEdge("d", "a", 1)
        graph.addEdge("d", "c", 1)
        graph.addEdge("d", "e", 1)
        graph.addEdge("a", "e", 1)

        assertFalse(findCyclesUndirectedGraph(graph2))
    }
}