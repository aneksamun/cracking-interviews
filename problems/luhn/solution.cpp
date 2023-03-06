#include <iostream>

using namespace std;

bool luhn(const string& number) {
    int sum = 0;
    bool isSecond = false;

    for (int i = number.size() - 1; i >= 0; i--) {
        int digit = number[i] - '0';

        if (isSecond) {
            digit *= 2;
            if (digit > 9) 
                digit -= 9;
        }

        sum += digit;
        isSecond = !isSecond;
    }

    return sum % 10 == 0;
}

int main(int argc, char* argv[]) {
    if (argc != 2) {
        cout << "Usage: " << argv[0] << " <number>" << endl;
        return 1;
    }

    string number = argv[1];
    cout << boolalpha << luhn(number) << endl;
    return 0;
}

