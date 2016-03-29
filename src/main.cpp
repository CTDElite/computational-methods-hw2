//
// Created by Ignat Loskutov on 28/03/16.
//
#include <iostream>
#include <vector>
#include <gmpxx.h>
#include "matrix.h"
#include "gauss_solver.h"

using namespace std;

int main() {
    matrix<mpq_class> m ({
                       {1, 2, 3},
                       {1, 2, 1},
                       {1, 1, 1},
                      });
    matrix<mpq_class> fr({
                                 {1},
                                 {2},
                                 {3},
                         });
    gauss_solver<mpq_class> solver;
    cout << m * solver.solve(m, fr);
}