package ii_conventions

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<MyDate> {
    override fun compareTo(other: MyDate): Int =
            if (other == this) 0
            else if (other.year > year) -1
            else if (other.month > month) -1
            else if (other.dayOfMonth > dayOfMonth) -1
            else 1
}

enum class TimeInterval {
    DAY
    WEEK
    YEAR
}

class DateRange(public val start: MyDate, public val end: MyDate)
