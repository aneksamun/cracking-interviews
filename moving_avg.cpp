/*
 Calculates moving average.

 Given
  ns: [1, 2, 3, 4]
  window: 4
 produces: 1 + 2 + 3 + 4 / 4 = 2.5

 Given
  ns: [1, 2, 3, 4]
  window: 2
 produces: [((1 + 2) / 2) ((2 + 3) / 2) + ((3 + 4) / 2)] = [1.5, 2.5, 3.5]

*/

#include <iostream>
#include <vector>
#include <numeric>

using namespace std;

template <typename T>
vector<T> slice(vector<T> const &source, size_t start_pos, size_t end_pos) {
    return vector<T>(source.begin() + start_pos, source.begin() + end_pos);
}

vector<double> calculate_moving_average(vector<size_t> const &ns, size_t window) {
    vector<double> moving_avg;
    auto total = (ns.size() - window) + 1;
    
    for (auto i = 0; i < total; i++) {
        auto sliced = slice(ns, i, i + window);
        auto sum = reduce(sliced.begin(), sliced.end());
        moving_avg.push_back(sum / (double) window);
    }
    
    return moving_avg;
}

int main(int argc, const char * argv[]) {
    auto moving_avg = calculate_moving_average({1, 2, 3, 4}, 4);
    
    for (auto average : moving_avg) {
        cout << average << endl;
    }
    
    return 0;
}
