#include <iostream>

using std::cin;
using std::cout;

int main() {

    cin.tie(NULL);
    std::ios_base::sync_with_stdio(false);

    int input[3];
    for(int i=0;i<3;i++)
        cin>>input[i];
    int max=0, minSum=0;
    for(int i=0;i<3;i++) {
        if(input[i]>max) {
            minSum+=max;
            max=input[i];
        }
        else
            minSum+=input[i];
    }
    cout<<minSum+std::min(max, minSum-1);
    return 0;
}
