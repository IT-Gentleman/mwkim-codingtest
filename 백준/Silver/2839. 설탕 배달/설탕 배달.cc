#include <iostream>

using std::cin;
using std::cout;

int main() {
    cin.tie(NULL);
    std::ios_base::sync_with_stdio(false);

    int n3=0, n5=0;
    int n;
    cin >> n;
    n5 = n / 5;
    while(n-(n5*5+n3*3)){
        if((n - (n5*5 + ++n3*3))<0)
            n5--;
        if(n5<0) { //n5==-1
            n3=0;
            break;
        }
    }
    cout<<n5+n3;

    return 0;
}
