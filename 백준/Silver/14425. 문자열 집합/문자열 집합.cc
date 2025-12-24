#include <iostream>
#include <algorithm>
#include <set>

using std::cin;
using std::cout;
using std::string;

std::set<string> s;

int main() {
    cin.tie(NULL);
    std::ios_base::sync_with_stdio(false);

    int nLen, mLen;
    cin>>nLen>>mLen;
    string input;
    for(int i=0;i<nLen;i++) {
        cin>>input;
        s.insert(input);
    }
    int count=0;
    for(int i=0;i<mLen;i++) {
        cin>>input;
        if(s.find(input)==s.end());
        else
            count++;
    }
    cout<<count;

    return 0;
}
