#include <iostream>

using std::cin;
using std::cout;

int main() {

    cin.tie(NULL);
    std::ios_base::sync_with_stdio(false);

    int n, k;
    cin>>n>>k;
    int i=0, count=0;
    while(i<n) {
        if(n%++i==0)
            count++;
        if(count==k)
            break;
    }
    if(count==k)
        cout<<i;
    else
        cout<<"0";

    return 0;
}
