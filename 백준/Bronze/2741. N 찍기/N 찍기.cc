#include <iostream>
#include <algorithm>

using std::cin;
using std::cout;

int main() {
    cin.tie(NULL);
    std::ios_base::sync_with_stdio(false);

    int input;
    cin>>input;
    for(int i=0;i<input;i++)
        cout<<i+1<<"\n";
    return 0;
}
