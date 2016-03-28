//
// Created by ignat on 28.03.16.
//

#ifndef COMPUTATION_METHODS_HW2_GAUSS_SOLVER_H
#define COMPUTATION_METHODS_HW2_GAUSS_SOLVER_H


#include "system_solver.h"
#include <cassert>

template <class T>
struct gauss_solver : system_solver<T> {
    /// FIXME: doesn't work for matrix with zeros on the main diagonal
    matrix<T> solve(const matrix<T> &coefficients, const matrix<T> &free) override {
        assert(coefficients.cols == coefficients.rows);
        assert(free.rows == coefficients.rows);
        assert(free.cols == 1);
        std::vector<std::vector<T>> data = coefficients.data;
        std::vector<std::vector<T>> free_data = free.data;

        for (size_t row = 0; row < coefficients.rows; ++row)
            for (size_t col = 0; col < row; ++col) {
                T coeff = data[row][col] / data[col][col];
                data[row] -= data[col] * coeff;
                free_data[row] -= free_data[col] * coeff;
            }

        for (size_t row = coefficients.rows - 1;; --row) {
            for (size_t col = row + 1; col < coefficients.cols; ++col) {
                T coeff = data[row][col] / data[col][col];
                data[row] -= data[col] * coeff;
                free_data[row] -= free_data[col] * coeff;
            }
            free_data[row] = free_data[row] / data[row][row];
            data[row] = data[row] / data[row][row];
            if (row == 0) break;
        }
        return free_data;
    }
};

#endif //COMPUTATION_METHODS_HW2_GAUSS_SOLVER_H
