// Converts decimal to binary
// 7 => 00000111
// 8 => 00001000

#include <iostream>

auto to_binstr(int num) {
    std::string bin = "";
    
    for (int t = 128; t > 0; t /= 2) {
        bin += (num & t) != 0 ? "1" : "0";
    }
    
    return bin;
}

int main(int argc, const char * argv[]) {
    std::cout << "Decimal to Binary converter \n\n";
    
    for (;;) {
        std::cout << "Enter number: ";
        int num;
        std::cin >> num;
        
        if (!std::cin)
            break;
        
        std::cout << to_binstr(num) << std::endl;
        std::cout << "\nType any non-number to exit\n";
    }

    return 0;
}
