#include <iostream>

#define COMPARE(x,y) (((x) < (y)) ? -1: ((x) == (y)) ? 0 : 1)

using std::cin;
using std::cout;

int main(void){
    int a, b;
    cin >> a >> b;
    switch(COMPARE(a,b)){
        case 1:
            cout << ">";
            break;
        case 0:
            cout << "==";
            break;
        case -1:
            cout << "<";
    }
    return 0;
}