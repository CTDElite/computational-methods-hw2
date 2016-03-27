package ru.ifmo.ctddev.segal.hw2

/**
 * Created by dimatomp on 27.03.16.
 */
sealed class IterativeStopPredicate {
    class NumIterations(val nIter: Int): IterativeStopPredicate()
    class EpsilonStop(val eps: Double): IterativeStopPredicate()
}

