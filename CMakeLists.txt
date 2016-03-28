cmake_minimum_required (VERSION 2.6)

project (computation-methods-hw2-ng)

set(CMAKE_CXX_COMPILER clang++)
set(CMAKE_CXX_FLAGS "${CMAKE_CSS_FLAGS} -std=c++14 -Wall -Wextra -Wconversion -pedantic")

include_directories(headers)


include_directories(${EIGEN_INCLUDE_DIRS})
set(SRC_LIST src/main.cpp headers/gauss_solver.h)

add_executable(main ${SRC_LIST})
