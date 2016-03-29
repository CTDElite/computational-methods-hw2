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
#include <memory>

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

    unique_ptr<iterative_solver<double>> jacobi = make_unique<jacobi_solver>();
    cout << "JACOBI: " << endl << jacobi->solve(input, free) << endl;

    unique_ptr<iterative_solver<double>> gradient = make_unique<gradient_descent_solver<double>>();
    cout << "GRADIENT: " << endl << gradient->solve(input, free) << endl;

    gauss_solver<double> solver;
    cout << "GAUSS: " << endl << solver.solve(input, free) << endl;
}