#include <iostream>
#include <algorithm>

using std::cin;
using std::cout;

int main() {
    cin.tie(NULL);
    std::ios_base::sync_with_stdio(false);

    int input, sum=0;
    for(int i=0;i<5;i++) {
        cin>>input;
        sum+=(input*input);
    }
    cout<<sum%10;

    return 0;
}
