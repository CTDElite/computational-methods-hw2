//
// Created by aleksei on 3/29/16.
//

#ifndef COMPUTATION_METHODS_HW2_NG_GRADIENT_DESCENT_SOLVER_H
#define COMPUTATION_METHODS_HW2_NG_GRADIENT_DESCENT_SOLVER_H

#include "iterative_solver.h"
template <class T>
class gradient_descent_solver : public iterative_solver<T> {
public:
    matrix<T> solve(const matrix<T> &coefficients, const matrix<T> &free,
                    const matrix<T> &initial_approx, size_t iterations) {
        matrix<T> xp(initial_approx);
        matrix<T> fp(coefficients * xp - free);
        const matrix<T> W = coefficients.transpose();

        for (size_t iter = 0; iter < iterations; iter++) {
            matrix<T> h = (coefficients * W * fp);
            T nup = (fp.transpose() * h).getAsT() / (h * h.transpose()).getAsT();
            xp = xp - (W * fp) * nup;
            fp = coefficients * xp - free;
        }
        return xp;
    }
};

#endif //COMPUTATION_METHODS_HW2_NG_GRADIENT_DESCENT_SOLVER_H
