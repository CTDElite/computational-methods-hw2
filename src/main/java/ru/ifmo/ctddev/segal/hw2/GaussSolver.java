package ru.ifmo.ctddev.segal.hw2;

import org.jetbrains.annotations.NotNull;
import ru.ifmo.ctddev.segal.hw2.matrix.Matrix;
import scala.math.BigInt;
import spire.math.Number;
import spire.math.Rational;

/**
 * @author itegulov
 */
public class GaussSolver implements SystemSolver {

    @NotNull
    @Override
    public Matrix solve(@NotNull Matrix coefficients, @NotNull Matrix free) {
        Number[][] newArray = new Number[coefficients.rows()][coefficients.cols()];
        for (int i = 0; i < coefficients.rows(); i++) {
            for (int j = 0; j < coefficients.cols(); j++) {
                newArray[i][j] = coefficients.apply(i, j).$div((Number) Rational.apply(BigInt.apply(7), BigInt.apply(9)));
            }
        }
        return new Matrix(newArray);
    }

    // Fucking Java and it's fucking type system, which can't recognize that Number is mixed trait of Rational! Argggh!
    // This just don't work and won't work. I don't believe in friendship of Scala and Java anymore.
    public static void main(String[] args) {
        Number[][] array = {{(Number) Rational.apply(1), (Number) Rational.apply(2)}};
        Matrix answer = new GaussSolver().solve(new Matrix(array), new Matrix(array));
        System.out.println(answer);
    }
}
