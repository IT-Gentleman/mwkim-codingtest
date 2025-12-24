#include <iostream>
#include <algorithm>
#include <cmath>

using std::cin;
using std::cout;
using std::string;

bool isSosu(unsigned long long int input) {
    unsigned long long int sqrtInt = sqrt(input);
    if(sqrt(input) - sqrtInt > 0) {
        for(unsigned long long int i = 2; i<=sqrtInt; i++)
            if(input%i==0)
                return false;
        return true;
    }
    return false;
}

int main() {
    cin.tie(NULL);
    std::ios_base::sync_with_stdio(false);

    unsigned long long int a, b;
    cin>>a>>b;
    for(unsigned long long int j=a;j<=b;j++)
        if(isSosu(j))
            cout<<j<<"\n";
    return 0;
}
