package ru.ifmo.ctddev.segal.hw2;

import golem.matrix.Matrix;
import org.jetbrains.annotations.NotNull;

/**
 * Created by dimatomp on 27.03.16.
 */
public interface IterativeSolver<T> extends SystemSolver<T> {
    @NotNull default Matrix<T> solve(@NotNull Matrix<T> coefficients, @NotNull Matrix<T> free, @NotNull Matrix<T> initialApprox) {
        return solve(coefficients, free, initialApprox, ITER_DEFAULT);
    }


    @NotNull default Matrix<T> solve(@NotNull Matrix<T> coefficients, @NotNull Matrix<T> free, @NotNull IterativeStopPredicate stopPredicate) {
        return solve(coefficients, free, free.getFactory().zeros(free.numCols()), stopPredicate);
    }

    @NotNull @Override default Matrix<T> solve(@NotNull Matrix<T> coefficients, @NotNull Matrix<T> free) {
        return solve(coefficients, free, ITER_DEFAULT);
    }

    @NotNull Matrix<T> solve(@NotNull Matrix<T> coefficients,
                             @NotNull Matrix<T> free,
                             @NotNull Matrix<T> initialApprox,
                             @NotNull IterativeStopPredicate predicate);

    IterativeStopPredicate ITER_DEFAULT = new NumIterations(100);
}
