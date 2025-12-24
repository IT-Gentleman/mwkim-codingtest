#include <iostream>

using std::cin;
using std::cout;

int main() {

    cin.tie(NULL);
    std::ios_base::sync_with_stdio(false);

    int input;
    cin>>input;
    for(int sosu=2;sosu<=input && input>1; sosu++)
            while(input%sosu==0) {
                cout<<sosu<<"\n";
                input/=sosu;
            }
    return 0;
}
