#include <iostream>
#include <algorithm>
#include <string>

using std::cin;
using std::cout;

int main() {
    cin.tie(NULL);
    std::ios_base::sync_with_stdio(false);

    int now, prev;
    cin>>prev;
    cin>>now;
    bool gooboon=(prev<now)?true:false;
    prev=now;
    for(int i=2;i<8;i++) {
        cin>>now;
        if(gooboon ^ (prev<now)) {
            cout<<"mixed";
            return 0;
        }
        prev=now;
    }
    if(gooboon)
        cout<<"ascending";
    else
        cout<<"descending";
    return 0;
}
