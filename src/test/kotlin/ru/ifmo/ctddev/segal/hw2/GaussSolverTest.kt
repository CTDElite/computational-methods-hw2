package ru.ifmo.ctddev.segal.hw2

import org.junit.Test
import golem.*

import org.junit.Assert.*

/**
 * @author itegulov
 */
class GaussSolverTest {

    @Test
    fun solve() {
        val coefficients = mat[1, 2, 3 end
                               4, 5, 6 end
                               7, 8, 9]
        val free = mat[1, 2, 3]

        assertEquals(GaussSolver.solve(coefficients, free), coefficients)
    }
}