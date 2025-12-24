#include <iostream>
#include <algorithm>

using std::cin;
using std::cout;
using std::string;

unsigned long long int gcd(unsigned long long int a, unsigned long long int b) {
    unsigned long long int max, min;
    max=(a>b)?a:b; min=(a<b)?a:b;
    if(a==b)
        return a;
    while(min!=1) {
        unsigned long long int temp=max%min;
        if(temp) {
            max=min;
            min=temp;
        }
        else
            break;
    }
    return min;
}

void maxGongyak(unsigned long long int* list, int n) {
    for(int i=0;i<n-1;i++)
        list[i]=list[i+1]-list[i];
    unsigned long long int gcdVal=list[0];
    for(int i=1;i<n-1; i++)
        gcdVal = gcd(gcdVal, list[i]);
    unsigned long long int returnVal=0;
    for(int i=0;i<n-1; i++)
        returnVal+=(list[i]/gcdVal)-1;
    cout<<returnVal;
}

int main() {
    cin.tie(NULL);
    std::ios_base::sync_with_stdio(false);

    int n;
    cin>>n;
    unsigned long long int* input = new unsigned long long int[n];
    for(int i=0;i<n;i++)
        cin>>input[i];
    maxGongyak(input, n);

    delete[] input;
    return 0;
}
