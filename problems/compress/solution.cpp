#include <iostream>
#include <string>

using namespace std;

string compress(const string& s) {
    string result;
    int count = 1;

    for (int i = 0; i < s.size(); i++) {
        if (s[i] != s[i + 1]) {
            result += s[i] + to_string(count);
            count = 1;
        } else count++;
    }

    return result;
}

int main(int argc, char const *argv[]) {
    if (argc != 2) {
        cout << "Usage: " << argv[0] << " <string>" << endl;
        return 1;
    }
    cout << compress(argv[1]) << endl;
    return 0;
}

