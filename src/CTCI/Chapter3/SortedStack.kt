package CTCI.Chapter3

import java.util.*

fun sortStack(stack: ArrayDeque<Int>) {
    val sortedStack = ArrayDeque<Int>()

    while(stack.isNotEmpty()) {
        val temp = stack.pop()
        while (sortedStack.isNotEmpty() && sortedStack.peek() > temp) {
            stack.push(sortedStack.pop())
        }
        sortedStack.push(temp)
    }

    while (sortedStack.isNotEmpty()) {
        stack.push(sortedStack.pop())
    }
}

fun main() {
    val size = 10
    val stack = ArrayDeque<Int>()
    repeat(size) {
        stack.push(Random().nextInt(9))
    }
    println("unsorted stack $stack")
    sortStack(stack)
    println("sorted stack $stack")
}