#include <iostream>

class Nybble {
private:
    int value;
public:
    Nybble() { value = 0; }
    Nybble(const int value) { this->value = value & 0xF; }

    operator int() const { return value; }

    Nybble operator+(const Nybble& other) {
        return Nybble((value + other.value) & 0xF);
    }

    Nybble operator+(const int other) {
        return Nybble((value + other) & 0xF);
    }

    // Prefix increment
    Nybble& operator++() {
        this->value++;
        this->value &= 0xF;
        return *this;
    }

    // Postfix increment
    Nybble operator++(int) {
        Nybble temp = *this;
        ++*this;
        return temp;
    }

    bool operator>(const Nybble& other) {
        return value > other.value;
    }

    bool operator<(const Nybble& other) {
        return value < other.value;
    }

    bool operator==(const Nybble& other) {
        return value == other.value;
    }

    operator std::string() {
        return std::to_string(value);
    }
};
