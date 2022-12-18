#include <iostream>
#include "nybble.hpp"

int main(int argc, const char * argv[]) {
    
    Nybble nybble1 = Nybble(1);
    Nybble nybble2 = Nybble(10);

    Nybble nybble3 = nybble1 + nybble2;
    Nybble nybble4 = nybble3 + 1;
    Nybble nybble5 = ++nybble4;

    int multiplication = nybble1 * 10;
    Nybble nybble6 = Nybble(multiplication);

    std::cout << "Nybble 1: " << nybble1 << std::endl;
    std::cout << "Nybble 2: " << nybble2 << std::endl;
    std::cout << "Nybble 1 + Nubble 2 + 2 = " << nybble5 << std::endl;
    std::cout << "Nubble 1 * 10 = " << multiplication << std::endl;
    std::cout << "Whether Nybble 1 equal to (Nubble 1 * 10)? " << std::boolalpha << (nybble2 == nybble6) << std::endl;
    std::cout << "Whether Nybble 1 > Nubble 2? " << std::boolalpha << (nybble1 > nybble2) << std::endl;
    std::cout << "Whether Nybble 1 < Nubble 2? " << std::boolalpha << (nybble1 < nybble2) << std::endl;
    
    return 0;
}
