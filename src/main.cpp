//
// Created by Ignat Loskutov on 28/03/16.
//
#include <iostream>
#include <vector>
#include "matrix.h"
#include "gauss_solver.h"

using namespace std;

int main() {
    matrix<double> m ({{1, 2, 3},
                       {4, 5, 6},
                       {7, 8, 8}});
    gauss_solver<double> solver;
    cout << m * solver.solve(m, {{ {1},
                               {2},
                               {3} }});
}