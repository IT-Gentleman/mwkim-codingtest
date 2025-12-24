#include <iostream>
#include <algorithm>

using std::cin;
using std::cout;
using std::string;

void printVal(long long int a, long long int b) {
    long long int returnVal=1;
    for(long long int i=2; a!=1 && b!=1 && i<=std::min(a, b); i++) {
        while(a%i==0 && b%i==0) {
            a/=i; b/=i;
            returnVal*=i;
        }
    }
    returnVal*=a*b;
    cout<<returnVal<<"\n";
}

int main() {
    cin.tie(NULL);
    std::ios_base::sync_with_stdio(false);

    long long int a, b;
    cin>>a>>b;
    printVal(a, b);

    return 0;
}
