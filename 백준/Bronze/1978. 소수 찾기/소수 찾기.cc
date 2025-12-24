#include <iostream>

using std::cin;
using std::cout;

int main() {

    cin.tie(NULL);
    std::ios_base::sync_with_stdio(false);

    int n, count=0;
    cin >> n;
    for(int i=0;i<n;i++) {
        int input, sosu;
        cin>>input;
        for(sosu=2;sosu<=input/2; sosu++) {
            if(input%sosu==0)
                break;
        }
        if(input!=1 && sosu>input/2)
            count++;
    }
    cout<<count;
    return 0;
}
