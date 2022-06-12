#include <iostream>
#include <vector>
#include <string>
#include <tuple>

using namespace std;

const vector<tuple<string, int>> numerals = {
    tuple("M", 1000),
    tuple("CM", 900),
    tuple("D", 500),
    tuple("CD", 400),
    tuple("C", 100),
    tuple("XC", 90),
    tuple("L", 50),
    tuple("XL", 40),
    tuple("X", 10),
    tuple("IX", 9),
    tuple("V", 5),
    tuple("IV", 4),
    tuple("I", 1)
};

string convert(int number) {
    string roman;
    for (auto& [symbol, value] : numerals) {
        while (number >= value) {
            roman += symbol;
            number -= value;
        }
    }
    return (roman == "" ? "-//-" : roman);
}

int main(int argc, const char* argv[]) {
    for (;;) {
        cout << "Enter number: ";
        int number;
        cin >> number;

        if (!cin) break;

        cout << "Roman numeral: " << convert(number) << endl;
        cout << "\nType non-number to exit\n";
    }
    return 0;
}
