#include <iostream>

using namespace std;

int find_most_frequent_elem(int* array, const int n, const int max) {
    int* occurrences = new int[max + 1];
    int most_frequent_elem = -1;

    for (auto i = 0; i < n; i++) {
        auto curr_elem = array[i];
        occurrences[curr_elem]++;
        if (occurrences[curr_elem] > occurrences[most_frequent_elem]) 
            most_frequent_elem = curr_elem;
    }

    delete[] occurrences;
    return most_frequent_elem;
}

int main() {
    int size = 6, max = 3;
    int array[] = {1, 2, 3, 3, 1, 3};
    cout << find_most_frequent_elem(array, size, max) << endl;
    return 0;
}
