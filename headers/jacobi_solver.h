//
// Created by Daniyar Itegulov on 29/03/16.
//

#ifndef COMPUTATION_METHODS_HW2_NG_JACOBI_SOLVER_H
#define COMPUTATION_METHODS_HW2_NG_JACOBI_SOLVER_H

#include <iterative_solver.h>
#include <vector>
#include <memory>
#include <cmath>

class jacobi_solver : public iterative_solver<double> {
public:
    using iterative_solver::solve;

    matrix<double> solve(const matrix<double> &coefficients, const matrix<double> &free,
                         const matrix<double> &initial_approx, size_t iterations) override {
        size_t n = coefficients.rows;
        std::vector<std::vector<double>> tmp(n, std::vector<double>(1));
        std::unique_ptr<matrix<double>> cur = std::make_unique<matrix<double>>(initial_approx);
        for (size_t iteration = 0; iteration < iterations; iteration++) {
            for (size_t i = 0; i < n; i++) {
                tmp[i][0] = free[i][0];
                for (int g = 0; g < n; g++) {
                    if (i != g) tmp[i][0] -= coefficients[i][g] * (*cur)[g][0];
                }
                tmp[i][0] /= coefficients[i][i];
            }
            double norm = std::fabs((*cur)[0][0] - tmp[0][0]);
            for (int h = 0; h < n; h++)
                if (fabs((*cur)[h][0] - tmp[h][0]) > norm)
                    norm = std::fabs((*cur)[h][0] - tmp[h][0]);
            if (norm < 1e-3) break;
            cur = std::make_unique<matrix<double>>(matrix<double>(tmp));
        }
        return *cur;
    }
};

#endif //COMPUTATION_METHODS_HW2_NG_JACOBI_SOLVER_H
