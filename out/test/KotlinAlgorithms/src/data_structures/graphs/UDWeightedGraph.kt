package data_structures.graphs

import java.util.*

class UDWeightedGraph<T> {
    data class Edge<T>(
            val from: T,
            val to: T,
            val weight: Int
    )

    var adjacent = mutableMapOf<T, MutableSet<Edge<T>>>()
    var edges = 0

    fun addEdge(from: T, to: T, weight: Int) {
        val edge = Edge(from, to, weight)
        if(adjacent[from] == null) {
            adjacent[from] = mutableSetOf<Edge<T>>()
        }

        if(adjacent[to] == null) {
            adjacent[to] = mutableSetOf<Edge<T>>()
        }

        adjacent[from]?.add(edge)
        adjacent[to]?.add(edge)
        edges++
    }

    fun edges(): Collection<Edge<T>> {
        val set = mutableSetOf<Edge<T>>()
        adjacent.flatMap { (_, v) -> v }.forEach {
            set.add(it)
        }
        return set
    }

    fun adjacentEdges(from: T): Collection<Edge<T>> {
        return adjacent[from]!!
    }

    fun adjacentVertices(from: T): Collection<T> {
        return adjacent[from]!!.map { it -> it.to }
    }

    fun printAdjacent() {
        adjacent.forEach { (t, u) ->
            println("$t: ${u.joinToString()} ")
        }
    }

}

fun main() {
    var graph = UDWeightedGraph<String>()
    graph.addEdge("a", "b", 10)
    graph.addEdge("a", "c", 10)
    graph.addEdge("a", "d", 10)
    graph.addEdge("a", "e", 10)
    graph.addEdge("a", "b", 10)
    graph.addEdge("c", "d", 5)
    graph.printAdjacent()

    println(graph.adjacentEdges("a").joinToString())
}