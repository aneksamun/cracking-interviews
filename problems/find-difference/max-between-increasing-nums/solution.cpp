#include <iostream>
#include <sstream>
#include <vector>

using namespace std;

int find_max_difference(vector<int> nums) {
    int res = -1;
    int min_so_far = numeric_limits<int>::max();
    for (auto elem : nums) {
        // compare every next element to find min element
        min_so_far = min(min_so_far, elem);
        // substract element with min element
        if (elem > min_so_far)
            // and update result if difference is greater
            res = max(res, elem - min_so_far);
    }
    return res;
}

int main(int argc, char const* argv[]) {
    vector<int> numbers;
    string line; 
    int number;

    cout << "Enter numbers: ";
    getline(cin, line);
    istringstream iss(line);
    while (iss >> number)
        numbers.push_back(number);

    cout << "Max difference between increasing numbers: "
         << find_max_difference(numbers) << endl;

    return 0;
}
