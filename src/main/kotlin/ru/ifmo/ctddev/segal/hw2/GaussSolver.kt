package ru.ifmo.ctddev.segal.hw2

import golem.matrix.Matrix

/**
 * @author itegulov
 */
object GaussSolver : SystemSolver<Double> {

    override fun solve(coefficients: Matrix<Double>, free: Matrix<Double>): Matrix<Double> {
        return coefficients
    }
}