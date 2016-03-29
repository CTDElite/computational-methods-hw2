import numpy as np
from numpy.linalg import norm, cond
from numpy.matlib import identity, zeros

def seidel_method(A, b, x_init=None, n_steps=100, eps=None, log=False):
    #A, b = replace_zeroes(A, b)
    B1 = np.mat([[A[i, j] / A[i, i] if i < j else 0 for j in range(len(b))] for i in range(len(b))])
    B2 = np.mat([[A[i, j] / A[i, i] if i > j else 0 for j in range(len(b))] for i in range(len(b))])
    b = np.mat([[b[i] / A[i, i]] for i in range(len(b))])
    if eps:
        B2n = norm(B2, ord=2)
        Bn = norm(B1 + B2, ord=2)
    B1 = (identity(len(b)) + B1).I
    x = x_init.copy() if x_init else np.mat([[0]] * len(b))
    my_steps = 0
    while n_steps == None or my_steps < n_steps:
        x1 = B1 * (b - B2 * x)
        my_steps += 1
        if eps and norm(x1 - x) <= eps: #norm(x1 - x) <= (1 - Bn) * eps / B2n:
            break
        x = x1
    if log:
        print('Seidel:', my_steps, 'iterations')
    return x1

if __name__ == '__main__':
    print('Enter the matrix:')
    A = [list(map(float, input().split()))]
    for i in range(len(A[0]) - 1):
        while True:
            next = list(map(float, input().split()))
            if len(next) != len(A[0]):
                print('Wrong number of coefficients, type again')
                continue
            break
        A.append(next)
    while True:
        b = list(map(float, input('Enter the free value: ').split()))
        if len(b) != len(A):
            print('Wrong number of free values, type again')
            continue
        break
    A = np.mat(A, dtype=float)
    solution = seidel_method(A, b, log=True, eps=1e-4).T
    print('Seidel solution:', solution)
    print('A * solution:', solution * A.T)
    print('Matrix conditional number:', cond(A))
