package interview_cake

data class Meeting(var startTime: Int, var endTime: Int): Comparable<Meeting> {
    override fun compareTo(other: Meeting): Int {
        return this.startTime - other.startTime
    }
}