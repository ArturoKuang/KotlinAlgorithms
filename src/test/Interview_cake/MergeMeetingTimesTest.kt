package Interview_cake

import interview_cake.Meeting
import interview_cake.MergingMeetingTimes
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class MergeMeetingTimesTest() {
    @Test
    fun testMeetingRange() {
        val meetings = listOf<Meeting>(Meeting(0, 1), Meeting(3, 5), Meeting(4, 8), Meeting(10, 12), Meeting(9, 10))
        val expectedMeetings = listOf<Meeting>(Meeting(0, 1), Meeting(3, 8), Meeting(9, 12))

        val mergingMeetingTimes = MergingMeetingTimes()

        Assertions.assertEquals(mergingMeetingTimes.merge(meetings), expectedMeetings)
    }
}