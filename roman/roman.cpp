#include <iostream>
#include <vector>
#include <string>
#include <tuple>
#include <map>

using namespace std;

const vector<tuple<string, int>> mappings = {
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

string convert_to_roman(uint number) {
    string roman;
    for (auto& [numeral, value] : mappings) {
        while (number >= value) {
            roman += numeral;
            number -= value;
        }
    }
    return roman;
}

// IXIVV
// I < X, 0 + 10 - 1 = 9, i++
// I < V, 9 + 5 - 1 = 13, i++
// V < \0, 13 + 5 = 18, i++
uint convert_to_arabic(string roman) {
    uint arabic = 0;
    map<char, int> m;

    for (auto& [numeral, value] : mappings) {
        if (numeral.length() < 2) {
            m[numeral.c_str()[0]] = value;
        }
    }

    for (int i = 0; i < roman.length(); i++) {
        if (m[roman[i]] < m[roman[i + 1]]) {
            arabic += m[roman[i + 1]] - m[roman[i]];
            i++;
            continue;
        }
        arabic += m[roman[i]];
    }

    return arabic;
}

int main(int argc, const char* argv[]) {

    for (;;) {
        cout << "Enter number: ";
        int number;
        cin >> number;

        if (!cin) break;
        if (number <= 0) {
            cout << "Number must be positive!" << endl;
            break;
        }

        auto roman  = convert_to_roman(number);
        auto arabic = convert_to_arabic(roman);

        cout << "Roman: "  << roman  << endl;
        cout << "Arabic: " << arabic << endl;
        cout << endl << "Enter a non-number to exit" << endl;
    }

    return 0;
}
