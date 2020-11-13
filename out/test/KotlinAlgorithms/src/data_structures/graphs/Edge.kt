package data_structures.graphs

data class Edge<T>(
        val from: T,
        val to: T,
        val weight: Int
)