#include <iostream>

int factorial(int n) {
    int fac = 1;
    for (int i = 1; i <= n; i++)
        fac *= i;
    return fac;
}

int main(int argc, const char * argv[]) {
    std::cout << factorial(0) << std::endl;
    return 0;
}

