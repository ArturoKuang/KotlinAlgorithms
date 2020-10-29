package data_structures.graphs

import java.util.*

class Djikstra(private val graph: UDWeightedGraph<Int>) {

    data class Vertex(val node: Int, val distance: Double) : Comparable<Vertex> {
        override fun compareTo(other: Vertex): Int =
                (distance - other.distance).toInt()
    }

    private val priorityQueue = PriorityQueue<Vertex>()
    private val visited = mutableMapOf<Int, Boolean>().withDefault { false }

    fun shortestDistance(from: Int, to: Int): Double {
        val distTo: DoubleArray = DoubleArray(graph.vertices) { if (it == from) 0.0 else Double.POSITIVE_INFINITY }
        priorityQueue.add(Vertex(from, 0.0))
        while (priorityQueue.isNotEmpty()) {
            val currentVertex = priorityQueue.poll()
            visited[currentVertex.node] = true

            for (node in graph.adjacentEdges(currentVertex.node)) {
                if(visited[node.to] == true) {
                    continue
                }
                val newDist = distTo[node.from] + node.weight
                if(newDist < distTo[node.to]) {
                    distTo[node.to] = newDist
                    priorityQueue.add(Vertex(node.to, newDist))
                }
            }
        }

        return distTo[to]
    }
}

fun main() {
    //https://visualgo.net/en/graphds
    var graph = UDWeightedGraph<Int>()
    graph.addEdge(0, 1, 4)
    graph.addEdge(0, 2, 4)
    graph.addEdge(0, 3, 6)
    graph.addEdge(0, 4, 6)
    graph.addEdge(1, 2, 2)
    graph.addEdge(2,0, 4)
    graph.addEdge(2,1, 2)
    graph.addEdge(2,3, 8)
    graph.addEdge(3, 0, 6)
    graph.addEdge(3, 2, 8)
    graph.addEdge(3, 4, 9)
    graph.printAdjacent()

    val djikstra = Djikstra(graph)
    println(djikstra.shortestDistance(1, 4))
}