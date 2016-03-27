package ru.ifmo.ctddev.segal.hw2

/**
  * @author itegulov
  */
sealed trait IterativeStopPredicate

case class NumIterationsPredicate(iterations: Int) extends IterativeStopPredicate

case class EpsPredicate(eps: Double) extends IterativeStopPredicate
