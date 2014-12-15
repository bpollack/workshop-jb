package ii_conventions

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<MyDate> {
    override fun compareTo(other: MyDate): Int {
        val first = array(year, month, dayOfMonth)
        val second = array(other.year, other.month, other.dayOfMonth)
        for (idx in 0..2) {
            if (first[idx] < second[idx]) return -1
            if (first[idx] > second[idx]) return 1
        }
        return 0
    }
}

enum class TimeInterval {
    DAY
    WEEK
    YEAR
}

data class TimeDelta(public val unit: TimeInterval, public val amount: Int)

class DateRange(public override val start: MyDate, public override val end: MyDate) : Iterable<MyDate>, Range<MyDate> {
    override fun contains(item: MyDate): Boolean = start <= item && item <= end

    override fun iterator() = object : Iterator<MyDate> {
        var current = start
        override fun hasNext() = current <= end
        override fun next(): MyDate {
            val ret = current
            current = current.addTimeIntervals(TimeInterval.DAY, 1)
            return ret
        }
    }
}

fun MyDate.rangeTo(end: MyDate): DateRange = DateRange(this, end)
fun MyDate.plus(unit: TimeInterval) = addTimeIntervals(unit, 1)
fun MyDate.plus(delta: TimeDelta) = addTimeIntervals(delta.unit, delta.amount)
fun TimeInterval.times(amount: Int) = TimeDelta(this, amount)