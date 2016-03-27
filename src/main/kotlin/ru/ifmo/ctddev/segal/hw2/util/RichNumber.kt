package ru.ifmo.ctddev.segal.hw2.util

interface  RichNumber<T : RichNumber<T>> {
    operator fun times(other: T): T

    operator fun plus(other: T): T

    operator fun minus(other: T): T
}