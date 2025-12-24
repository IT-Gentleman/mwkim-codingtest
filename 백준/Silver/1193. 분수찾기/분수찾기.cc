#include <iostream>

using std::cin;
using std::cout;

int main() {

    cin.tie(NULL);
    std::ios_base::sync_with_stdio(false);

    int input;
    cin >> input;

    int index=0, sum=0;
    while(sum<input)
        sum+=(++index);
    int son, mother, deltaSon, deltaMother;
    switch(index%2) {
        //input=2: 1/2, input=3: 2/1
        case 1:
            son=1, mother=index;
            deltaSon=1, deltaMother=-1;
            break;
        case 0:
            son=index, mother=1;
            deltaSon=-1, deltaMother=1;
            break;
    }
    while((sum--)-input) {
        son+=deltaSon;
        mother+=deltaMother;
    }
    cout << son << "/" << mother;


    return 0;
}
