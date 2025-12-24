#include <iostream>
#include <algorithm>

using std::cin;
using std::cout;
using std::string;

void printVal(int a, int b) {
    int returnVal=1;
    for(int i=2; a!=1 && b!=1 && i<=std::min(a, b); i++) {
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

    int n, a, b;
    cin>>n;
    for(int i=0;i<n;i++) {
        cin>>a>>b;
        printVal(a, b);
    }

    return 0;
}
