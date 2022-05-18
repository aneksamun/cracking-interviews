#include <iostream>
using namespace std;

bool is_palindrome(const string& str) {
    for (int i = 0; i < str.size() / 2; i++)
        if (str[i] != str[str.size() - i - 1])
            return false;
    return true;
}

bool is_palindrome2(const string& str) {
    const int len = str.size() - 1;
    for (int i = 0, j = len; i <= len && j >= 0; i++, j--)
        if (str[i] != str[j])
            return false;
    return true;
}

bool is_palindrome3(const string& str) {
    return str == string(str.rbegin(), str.rend());
}

int main(int argc, const char* argv[]) {
    cout << "Enter string: ";
    string s;
    cin >> s;
    cout << "Is palindrome: " << boolalpha << is_palindrome(s) << endl;
}
