/*
Enter the number of rows: 6
1 
1 1 
1 2 1 
1 3 3 1 
1 4 6 4 1 
1 5 10 10 5 1 
*/

#include <iostream>

using namespace std;

void pascal_triangle(int n) {
    for (int i = 0; i < n; i++) {
        int c = 1;
        for (int j = 0; j <= i; j++) {
            cout << c << " ";
            c = c * (i - j) / (j + 1);
        }
        cout << endl;
    }
}

int main() {
    int n;
    cout << "Enter the number of rows: ";
    cin >> n;
    pascal_triangle(n);
    return 0;
}

