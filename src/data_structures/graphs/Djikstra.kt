package data_structures.graphs

import java.util.*
import kotlin.random.Random

class Djikstra(private val graph: UDWeightedGraph<Int>, val from: Int) {

    data class Vertex(val node: Int, val distance: Double) : Comparable<Vertex> {
        override fun compareTo(other: Vertex): Int =
                (distance - other.distance).toInt()
    }

    private val priorityQueue = PriorityQueue<Vertex>()
    private val visited = mutableMapOf<Int, Boolean>().withDefault { false }
    private val distTo = mutableMapOf<Int, Double>()
    private val edgeTo: Array<UDWeightedGraph.Edge<Int>?> = arrayOfNulls(graph.nodeCount)

    init {
        for (vertex in graph.vertices()) {
            distTo[vertex] = Double.POSITIVE_INFINITY
        }

        distTo[from] = 0.0
        priorityQueue.add(Vertex(from, 0.0))
        while (priorityQueue.isNotEmpty()) {
            val currentVertex = priorityQueue.poll()
            visited[currentVertex.node] = true

            for (edge in graph.adjacentEdges(currentVertex.node)) {
                if(visited[edge.to] == true) {
                    continue
                }

                val newDist = distTo[edge.from]!! + edge.weight
                val oldDist = distTo[edge.to]!!
                if(newDist < oldDist) {
                    edgeTo[edge.to] = edge
                    distTo[edge.to] = newDist
                    priorityQueue.add(Vertex(edge.to, newDist))
                }
            }
        }
    }

    fun shortestDistance(to: Int): Double {
        return distTo[to]!!
    }

    fun pathTo(v: Int): Collection<Int> {
        val path = mutableListOf<Int>()
        var e = edgeTo[v]
        while (e != null) {
            path.add(e.to)
            e = edgeTo[e.from]
        }
        path.add(from)
        return path.reversed()
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

    val djikstra = Djikstra(graph, 1)

    println(djikstra.shortestDistance(4))
    println(djikstra.pathTo(4).joinToString())
}