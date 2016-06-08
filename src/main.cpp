//
// Created by Ignat Loskutov on 28/03/16.
//
#include <iostream>
#include <vector>
#include <gmpxx.h>
#include "matrix.h"
#include "gauss_solver.h"
#include <gradient_descent_solver.h>
#include <jacobi_solver.h>

using namespace std;

int main() {
    size_t n;
    cin >> n;
    vector<vector<double>> input(n, vector<double>(n));
    for (size_t i = 0; i < n; i++) {
        for (size_t j = 0; j < n; j++) {
            cin >> input[i][j];
        }
    }
    vector<vector<double>> free(n, vector<double>(1));
    for (size_t i = 0; i < n; i++) {
        cin >> free[i][0];
    }

    jacobi_solver jacobi;
    cout << "JACOBI: " << endl << jacobi.solve(input, free) << endl;

    gradient_descent_solver<double> gradient;
    cout << "GRADIENT: " << endl << gradient.solve(input, free) << endl;

    gauss_solver<double> solver;
    cout << "GAUSS: " << endl << solver.solve(input, free) << endl;
}