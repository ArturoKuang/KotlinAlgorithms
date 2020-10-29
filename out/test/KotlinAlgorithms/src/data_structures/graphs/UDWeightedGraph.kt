package data_structures.graphs

import java.util.*
import kotlin.NoSuchElementException as NoSuchElementException1

class UDWeightedGraph<T> {
    data class Edge<T>(
            val from: T,
            val to: T,
            val weight: Int
    )

    var adjacent = mutableMapOf<T, MutableSet<Edge<T>>>()
    var edges = 0
    val vertices
        get() = adjacent.keys.count()

    fun addEdge(from: T, to: T, weight: Int) {
        var edge = Edge(from, to, weight)
        if(adjacent[from] == null) {
            adjacent[from] = mutableSetOf<Edge<T>>()
        }

        if(adjacent[to] == null) {
            adjacent[to] = mutableSetOf<Edge<T>>()
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

    fun printAdjacent() {
        adjacent.forEach { (t, u) ->
            println("$t: ${u.joinToString()} ")
        }
    }

}

