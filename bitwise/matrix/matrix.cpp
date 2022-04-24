#include <iostream>

/**
 * @brief   Prints a matrix from left to right.
 * @details 00000001
 *          00000010
 *          00000100
 *          00001000
 *          00010000
 *          00100000
 *          01000000
 *          10000000
 */
void left2right() {
    int a = 1;

    for (int i = 0; i < 8; i++) {
        for (int j = 128; j > 0; j /= 2) 
            std::cout << ((a & j) ? "1" : "0");
        std::cout << std::endl;
        a <<= 1;
    }
}

/**
 * @brief   Prints a matrix from right to left.
 * @details 10000000
 *          01000000
 *          00100000
 *          00010000
 *          00001000
 *          00000100
 *          00000010
 *          00000001
 */
void right2left() {
    int a = 128;

    for (int i = 0; i < 8; i++) {
        for (int j = 128; j > 0; j /= 2) 
            std::cout << ((a & j) ? "1" : "0");
        std::cout << std::endl;
        a >>= 1;
    }
}

int main(int argc, const char * argv[]) {
    std::cout << "Prints matrix" << std::endl << std::endl;
    left2right();
    std::cout << std::endl;
    right2left();
    return 0;
}
