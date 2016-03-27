package ru.ifmo.ctddev.segal.hw2

import ru.ifmo.ctddev.segal.hw2.matrix.Matrix

import spire.math._

/**
  * @author itegulov
  */
object Main extends App {

  val array: Array[Array[Number]] = Array(Array(1, 2, 3), Array(4, 5, 6), Array(7, 8, 9))
  val matrix: Matrix = Matrix(array)
  val newMatrix: Matrix = Matrix(Array.fill(3, 3)(Number.zero))
  val n = matrix.rows
  val m = matrix.cols

  for (i <- 0 until n)
    for (j <- 0 until m)
      newMatrix(i, j) = matrix(i, j) / Rational(7, 9)

  for (i <- 0 until n) {
    for (j <- 0 until m)
      print(newMatrix(i, j) + " ")
    println()
  }
}
