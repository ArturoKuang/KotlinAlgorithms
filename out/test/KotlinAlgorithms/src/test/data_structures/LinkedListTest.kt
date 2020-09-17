package data_structures

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class LinkedListTest {
    @Test
    fun emptyTest() {
        //LinkedList<Int> list = LinkedList<Int>()
        //Assertions.assertThrows(list.remove())
    }

    @Test
    fun addTest() {
//        LinkedList<Int> list = LinkedList<Int>()
//        for(i in 0..100) {
//            list.add(i)
//        }
//
//        for(i in 0..100) {
//            Assertions.assertTrue(list.get(i) == i)
//        }
    }

    @Test
    fun getTest() {
//        LinkedList<Int> list = LinkedList<Int>()
//        for(i in 0..100) {
//             list.add(i)
//        }
//
//        Assertions.assertTrue(list.get(50) == 50)
//        Assertions.assertThrows(list.get(1000))
    }

    @Test
    fun removeTest() {
//        LinkedList<Int> list = LinkedList<Int>()
//        for(i in 0..100) {
//            list.add(i)
//        }
//
//        list.remove(10)
//        list.remove()
//
//        for (i in 0..100) {
//            if(i != 10 && i != 0) {
//                Assertions.assertTrue(list.get(i) == i)
//            }
//        }
    }

    @Test
    fun removeThrowTest() {
        //LinkedList<Int> list = LinkedList<Int>()
        //Assertions.assertThrows(list.remove())
        var list = LinkedList<Int>()
        list.add(1)
        list.add(2)
        list.add(3)
        list.remove(1)
        println(list.toString())
    }
}