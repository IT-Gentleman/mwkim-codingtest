#include <iostream>

using std::cin;
using std::cout;


int main() {

    cin.tie(NULL);
    std::ios_base::sync_with_stdio(false);

    int a1, a0, c, n0;
    cin>>a1>>a0>>c>>n0;
    if(a1>c)
        cout<<0;
    else {
        if(a1*n0+a0>c*n0)
            cout<<0;
        else
            cout<<1;
    }

    return 0;
}
