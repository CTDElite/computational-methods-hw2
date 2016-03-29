//
// Created by aleksei on 3/29/16.
//

#ifndef COMPUTATION_METHODS_HW2_NG_GRADIENT_DESCENT_SOLVER_H
#define COMPUTATION_METHODS_HW2_NG_GRADIENT_DESCENT_SOLVER_H

#include "iterative_solver.h"
#include <memory>
#include <iostream>

template <class T>
class gradient_descent_solver : public iterative_solver<T> {
public:
    matrix<T> solve(const matrix<T> &coefficients, const matrix<T> &free,
                    const matrix<T> &initial_approx, size_t iterations) {
        std::unique_ptr<matrix<T>> xp = std::make_unique<matrix<T>>(initial_approx);
        std::unique_ptr<matrix<T>> fp = std::make_unique<matrix<T>>(coefficients * (*xp) - free);
        matrix<T> W = coefficients.transpose();

        std::cout << *fp << std::endl;
        std::cout << std::endl;
        std::cout << *xp << std::endl;
        std::cout << std::endl << std::endl;

        for (size_t iter = 0; iter < iterations; iter++) {
            T delta = ((fp->transpose() * (*fp)).getAsT()) / (((coefficients * (*fp)).transpose() * (*fp)).getAsT());
            xp = xp - (fp) * delta;

            /*matrix<T> h(coefficients * W * (*fp));
            T nup = (fp->transpose() * h).getAsT() / (h.transpose() * h).getAsT();
            xp = std::make_unique<matrix<T>>((*xp) - (W * (*fp)) * nup);
            fp = std::make_unique<matrix<T>>(coefficients * (*xp) - free);
            */std::cout << *fp << std::endl;
            std::cout << std::endl;
            std::cout << *xp << std::endl;
            std::cout << std::endl << std::endl;
        }
        return *xp;
    }
};

#endif //COMPUTATION_METHODS_HW2_NG_GRADIENT_DESCENT_SOLVER_H
