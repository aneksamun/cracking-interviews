#include <iostream>

using namespace std;

uint count_population(int n) {
    uint count = 0;
    while(n) {
        count += n & 1;
        n >>= 1;
    }
    return count;
}

int main(int argc, const char* argv[]) {
    cout << "Counts one bits in a number" << endl;
    cout << "Enter number: ";
    int num;
    cin >> num;

    if (!cin) {
        cout << "Value is not valid number!" << endl;
        return EXIT_FAILURE;
    }

    cout << "Total: " << count_population(num) << endl;
    return EXIT_SUCCESS;
}
