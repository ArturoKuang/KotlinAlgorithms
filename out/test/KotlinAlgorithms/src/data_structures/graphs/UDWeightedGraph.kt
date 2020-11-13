package data_structures.graphs

import java.util.*

class UDWeightedGraph<T> {
    var adjacent = mutableMapOf<T, MutableSet<Edge<T>>>()
    var edges = 0
    val nodeCount
        get() = adjacent.keys.count()

    fun addEdge(from: T, to: T, weight: Int) {
        var edge = Edge(from, to, weight)
        if(adjacent[from] == null) {
            adjacent[from] = mutableSetOf()
        }

        if(adjacent[to] == null) {
            adjacent[to] = mutableSetOf()
        }

        adjacent[from]?.add(edge)
        edge = Edge(to, from, weight)
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
        return adjacent[from] ?: throw(NoSuchElementException())
    }

    fun adjacentVertices(from: T): Collection<T> {
        return adjacent[from]?.map { it -> it.to } ?: throw(NoSuchElementException())
    }

    fun vertices(): Collection<T> {
        return adjacent.keys
    }

    fun printAdjacent() {
        adjacent.forEach { (t, u) ->
            println("$t: ${u.joinToString()} ")
        }
    }

}

