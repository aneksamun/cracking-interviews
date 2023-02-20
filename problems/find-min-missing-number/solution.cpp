#include <iostream>
#include <vector>
#include <unordered_set>

using namespace std;

int find_min_missing_elem(const vector<int>& nums) {
    vector<int> positive;
    copy_if(nums.begin(), nums.end(), back_inserter(positive), [](int n) { return n > 0; });

    unordered_set<int> unique(positive.begin(), positive.end());

    if (positive.empty())
        return 1;

    for (int i = 1; i <= positive.size(); i++)
        if (unique.find(i) == unique.end())
            return i;

    return 0;
}

int main() {
    cout << find_min_missing_elem({ -1, -3 }) << endl;
    return 0;
}

