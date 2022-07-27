// Enter 4 items: 1 2 3 1
// Enter item positions to find: 1
// 0 3 

#include <iostream>
#include <vector>

using namespace std;

template <typename T, size_t N>
istream& operator>>(istream& is, T(&arr)[N]) {
    copy_n(istream_iterator<T>(is), N, arr);
    return is;
}

template <typename T>
vector<size_t> find_positions(const T x, const T* source, size_t n) {
    vector<size_t> positions;

    for (size_t i = 0; i < n; i++) {
        if (source[i] == x) {
            positions.push_back(i);
        }
    }

    return positions;
}

int main(int argc, const char* argv[]) {
    const int N = 4;
    string source[N];
    string target;

    cout << "Enter " << N << " items: ";
    cin >> source;

    cout << "Enter item positions to find: ";
    cin >> target;

    for (auto pos : find_positions(target, source, N))
        cout << pos << " ";

    cout << endl;
    return 0;
}
