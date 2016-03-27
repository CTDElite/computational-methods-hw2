package ru.ifmo.ctddev.segal.hw2;

import org.jetbrains.annotations.NotNull;
import ru.ifmo.ctddev.segal.hw2.matrix.Matrix;

import static ru.ifmo.ctddev.segal.hw2.matrix.Matrix.*;


/**
 * Created by dimatomp on 27.03.16.
 */
public interface IterativeSolver extends SystemSolver {
    @NotNull
    default Matrix solve(@NotNull Matrix coefficients, @NotNull Matrix free, @NotNull Matrix initialApprox) {
        return solve(coefficients, free, initialApprox, ITER_DEFAULT);
    }


    @NotNull
    default Matrix solve(@NotNull Matrix coefficients, @NotNull Matrix free, @NotNull IterativeStopPredicate stopPredicate) {
        return solve(coefficients, free, zeros(free.rows(), 1), stopPredicate);
    }

    @NotNull
    @Override
    default Matrix solve(@NotNull Matrix coefficients, @NotNull Matrix free) {
        return solve(coefficients, free, ITER_DEFAULT);
    }

    @NotNull
    Matrix solve(@NotNull Matrix coefficients,
                 @NotNull Matrix free,
                 @NotNull Matrix initialApprox,
                 @NotNull IterativeStopPredicate predicate);

    IterativeStopPredicate ITER_DEFAULT = new NumIterationsPredicate(100);
}
