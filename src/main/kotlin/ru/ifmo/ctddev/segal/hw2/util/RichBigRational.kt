package ru.ifmo.ctddev.segal.hw2.util

import java.math.BigInteger

/**
 * @author itegulov
 */
class RichBigRational(val num: BigInteger, val den: BigInteger) : RichNumber<RichBigRational> {

    override fun times(other: RichBigRational): RichBigRational =
            RichBigRational(num * other.num, den * other.den)

    override fun plus(other: RichBigRational): RichBigRational {
        val numerator = num * other.den + other.num * den
        val denominator = den * other.den
        return RichBigRational(numerator, denominator)
    }

    override fun minus(other: RichBigRational): RichBigRational {
        val numerator = num * other.den - other.num * den
        val denominator = den * other.den
        return RichBigRational(numerator, denominator)
    }
}