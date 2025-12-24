#include <iostream>
#include <cmath>

using std::cin;
using std::cout;

int main() {

    cin.tie(NULL);
    std::ios_base::sync_with_stdio(false);

    int n;
    cin>>n;
    int jari = (int)log10(n);
    int i;
    for(i=n-9*(jari+1); i<=(n-(jari+1)); i++) {
        int value=n, temp=i;
        for(int j=jari; j>=0; j--) {
            int tP=(int)pow(10, j);
            value-=(temp/tP);
            temp%=tP;
        }
        value-=i;
        if(!value)
            break;
    }
    if(i>(n-(jari+1)))
        cout<<0;
    else
        cout<<i;
    return 0;
}
