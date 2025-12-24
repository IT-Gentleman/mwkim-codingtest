#include <iostream>

int main(void){
    int a, b;
    std::cin >> a >> b;
    std::cout.precision(15);
    std::cout << (double)a/(double)b;
}