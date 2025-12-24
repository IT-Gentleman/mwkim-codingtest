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

    int n;
    cin>>n;
    unsigned long long int input;
    for(int i=0;i<n;i++) {
        cin>>input;
        for(unsigned long long int j=input;;j++)
            if(isSosu(j)) {
                cout<<j<<"\n";
                break;
            }
    }


    return 0;
}
