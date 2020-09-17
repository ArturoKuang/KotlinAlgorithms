package interview_cake

import kotlin.math.max
import kotlin.math.min

class MergingMeetingTimes {
    fun merge(meetingRanges: List<Meeting>): List<Meeting> {
        var mergedRanges = mutableListOf<Meeting>()
        var sortedMeetings = meetingRanges.sorted()

        mergedRanges.add(meetingRanges.first())
        for(meeting in sortedMeetings) {
            val lastMergedMeeting = mergedRanges.last()
            if(meeting.startTime <= lastMergedMeeting.endTime) {
                lastMergedMeeting.endTime = max(meeting.endTime, lastMergedMeeting.endTime)
            } else {
                mergedRanges.add(meeting)
            }
        }
        return mergedRanges
    }
}