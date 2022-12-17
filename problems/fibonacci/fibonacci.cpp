// Fibonacci seq: 1 1 2 3 5 8 13 21 34 55
//
// Enter position: 5
// Corresponding number: 8
// Even numbers sum: 10
//
// Enter position: 8
// Corresponding number: 34
// Even numbers sum: 44

#include <iostream>

int get_fibnum_at(int n) {
    int prev = 0, curr = 1;

    while (n > 0) {
        int temp = curr;
        curr += prev;
        prev = temp;
        n--;
    }

    return curr;
}

int sum_even_fibnum_until(int n) {
    int prev = 0, curr = 1, sum = 0;

    do {
        int tmp = curr;
        curr += prev;
        bool isOdd = curr & 1;
        if (!isOdd) sum += curr;
        prev = tmp;
    } while (--n > 0);

    return sum;
}

int main(int argc, const char* argv[]) {
    for (;;) {
        std::cout << "Enter position: ";
        int pos;
        std::cin >> pos;

        if (!std::cin)
            break;

        std::cout << "Corresponding number: " << get_fibnum_at(pos) << std::endl;
        std::cout << "Even numbers sum: " << sum_even_fibnum_until(pos) << std::endl;
        std::cout << "\nType any non-number to exit\n";
    }

    return 0;
}
