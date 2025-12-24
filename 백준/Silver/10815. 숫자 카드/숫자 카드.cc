#include <iostream>
#include <algorithm>
#include <set>

using std::cin;
using std::cout;
using std::string;

std::set<int> s;

int main() {
    cin.tie(NULL);
    std::ios_base::sync_with_stdio(false);

    int nLen, mLen;
    cin>>nLen;
    int input;
    for(int i=0;i<nLen;i++) {
        cin>>input;
        s.insert(input);
    }
    cin>>mLen;
    for(int i=0;i<mLen;i++) {
        cin>>input;
        if(s.find(input)==s.end())
            cout<<"0 ";
        else
            cout<<"1 ";
    }

    return 0;
}
