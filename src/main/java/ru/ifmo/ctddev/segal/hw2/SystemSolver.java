package ru.ifmo.ctddev.segal.hw2;

import org.jetbrains.annotations.NotNull;
import ru.ifmo.ctddev.segal.hw2.matrix.Matrix;

/**
 * @author itegulov
 */
public interface SystemSolver {

    @NotNull
    Matrix solve(@NotNull Matrix coefficients, @NotNull Matrix free);
}
