package ru.ifmo.ctddev.segal.hw2;

import golem.matrix.Matrix;
import org.jetbrains.annotations.NotNull;

/**
 * @author itegulov
 */
public interface SystemSolver<T> {

    @NotNull Matrix<T> solve(@NotNull Matrix<T> coefficients, @NotNull Matrix<T> free);
}
