#include <iostream>

using std::cin;
using std::cout;

int main() {

    cin.tie(NULL);
    std::ios_base::sync_with_stdio(false);

    int a, b;
    cin>>a>>b;
    while(a&&b) {
        if(a%b==0)
            cout<<"multiple\n";
        else if(b%a==0)
            cout<<"factor\n";
        else
            cout<<"neither\n";
        cin>>a>>b;
    }

    return 0;
}
