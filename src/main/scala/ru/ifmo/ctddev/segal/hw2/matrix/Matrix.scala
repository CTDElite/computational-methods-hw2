package ru.ifmo.ctddev.segal.hw2.matrix

import spire.math._

/**
  * @author itegulov
  */
case class Matrix(array: Array[Array[Number]]) {

  def apply(i: Int, j: Int) = array(i)(j)
  def update(i: Int, j: Int, value: Number) = array(i)(j) = value

  def *(other: Matrix): Matrix = {
    if (array(0).length != other.array.length)
      throw new IllegalStateException("This matrices can't be multiplied")
    val n = array.length
    val m = other.array(0).length
    val ans: Array[Array[Number]] = Array.fill(n, m)(Number.zero)
    for (i <- 0 until n)
      for (j <- 0 until m)
        for (k <- other.array.indices)
          ans(i)(j) += array(i)(k) * other.array(k)(j)
    Matrix(ans)
  }

  def +(other: Matrix): Matrix = {
    if (array.length != other.array.length || array(0).length != other.array(0).length)
      throw new IllegalStateException("This matrices can't be added")
    val n = array.length
    val m = array(0).length
    val ans: Array[Array[Number]] = Array.fill(n, m)(Number.zero)
    for (i <- 0 until n)
      for (j <- 0 until m)
        ans(i)(j) += array(i)(j) + other.array(i)(j)
    Matrix(ans)
  }

  def -(other: Matrix): Matrix = {
    if (array.length != other.array.length || array(0).length != other.array(0).length)
      throw new IllegalStateException("This matrices can't be subtracted")
    val n = array.length
    val m = array(0).length
    val ans: Array[Array[Number]] = Array.fill(n, m)(Number.zero)
    for (i <- 0 until n)
      for (j <- 0 until m)
        ans(i)(j) += array(i)(j) - other.array(i)(j)
    Matrix(ans)
  }

  def rows: Int = array.length

  def cols: Int = array(0).length
}

object Matrix {

  def zeros(n: Int, m: Int): Matrix = Matrix(Array.fill(n, m)(Number.zero))
}