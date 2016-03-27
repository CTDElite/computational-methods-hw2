package ru.ifmo.ctddev.segal.hw2

/**
 * Created by dimatomp on 27.03.16.
 */
interface IterativeStopPredicate
data class NumIterations(val nIter: Int): IterativeStopPredicate
data class EpsilonStop(val eps: Double): IterativeStopPredicate
