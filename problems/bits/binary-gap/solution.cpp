#include <iostream>

using namespace std;

uint find_longest_gap(uint n) {
    uint max_gap = 0;
    uint current_gap = 0;
    bool gap_revealed = false;

    do {
        if (n & 1) {
            gap_revealed = true;
            max_gap = max(max_gap, current_gap);
            current_gap = 0;
        } else if (gap_revealed) 
            current_gap++;
        
        n >>= 1;
    } while (n > 0);

    return max_gap;
}

int main() {
    cout << "Enter a number: ";
    uint n;
    cin >> n;
    cout << "Longest binary gap: " << find_longest_gap(n) << endl;
    return 0;
}

