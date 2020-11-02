package interview_cake

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class InFlightEntertainment {
    @Test
    fun emptyListTest() {
        val moviesTimes = emptyList<Int>()
        val flightLength = 60
        testListFalse(moviesTimes, flightLength)
    }

    @Test
    fun moviesFoundTest() {
        val moviesTimes = listOf(20,30,50,90,40,100,10)
        val flightLength = 60
        testListTrue(moviesTimes, flightLength)
    }

    @Test
    fun moviesNotFoundTest() {
        val moviesTimes = listOf(20,90,50,45,70,80)
        val flightLength = 60
        testListFalse(moviesTimes, flightLength)
    }

    private fun testListFalse(moviesTimes: List<Int>, flightLength: Int) {
        Assertions.assertFalse(
                canTwoMoviesFillFlight(moviesTimes, flightLength),
                "movies exceeded time length")
    }

    private fun testListTrue(moviesTimes: List<Int>, flightLength: Int) {
        Assertions.assertTrue(
                canTwoMoviesFillFlight(moviesTimes, flightLength),
                "movies could not be found")
    }

    private fun canTwoMoviesFillFlight(
            moviesTimes: List<Int>,
            flightLength: Int): Boolean {

        var set = HashSet<Int>()
        for (time in moviesTimes) {
            var complementTime = flightLength - time
            if (set.contains(time)) {
                return true
            } else {
                set.add(complementTime)
            }
        }

        return false
    }
}