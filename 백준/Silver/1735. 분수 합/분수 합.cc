#include <iostream>
#include <algorithm>

using std::cin;
using std::cout;
using std::string;

int printVal(int a, int b) {
    int returnVal=1;
    for(int i=2; a!=1 && b!=1 && i<=std::min(a, b); i++) {
        while(a%i==0 && b%i==0) {
            a/=i; b/=i;
            returnVal*=i;
        }
    }
    returnVal*=a*b;
    return returnVal;
}

void printGiyak(int a, int b) {
    for(int i=2; a!=1 && b!=1 && i<=std::min(a, b); i++) {
        while(a%i==0 && b%i==0) {
            a/=i; b/=i;
        }
    }
    cout<<a<<" "<<b;
}

void sum(long long int a, long long int b, long long int c, long long int d) {
    long long int boonmo = printVal(b, d);
    long long int boonja = a*boonmo/b + c*boonmo/d;
    printGiyak(boonja, boonmo);
}

int main() {
    cin.tie(NULL);
    std::ios_base::sync_with_stdio(false);

    int a, b, c, d;
    cin>>a>>b>>c>>d;
    sum(a, b, c, d);

    return 0;
}
