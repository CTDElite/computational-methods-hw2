package ru.ifmo.ctddev.segal.hw2.util

/**
 * @author itegulov
 */
class RichDouble(val value: Double) : RichNumber<RichDouble> {

    override fun times(other: RichDouble): RichDouble {
        return RichDouble(value * other.value)
    }

    override fun plus(other: RichDouble): RichDouble {
        return RichDouble(value + other.value)
    }

    override fun minus(other: RichDouble): RichDouble {
        return RichDouble(value - other.value)
    }
}