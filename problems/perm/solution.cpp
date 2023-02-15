#include <unordered_set>
#include <iostream>

using namespace std;

bool is_perm(int* a, int n) {
    unordered_set<int> s;
    for (int i = 0; i < n; i++)
        s.insert(a[i]);

    if (s.size() == n)
        return false;

    for (int i = 1; i <= n; i++) {
        if (s.find(i) == s.end())
            return false;
    }
}

int main() {
    is_perm(new int[3]{1, 2, 3}, 3);
    return 0;
}

