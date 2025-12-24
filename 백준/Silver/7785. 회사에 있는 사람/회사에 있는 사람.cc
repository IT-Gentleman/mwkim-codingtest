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

    int nLen;
    cin>>nLen;
    string input, dist;
    for(int i=0;i<nLen;i++) {
        cin>>input>>dist;
        if(dist=="enter")
            s.insert(input);
        else
            s.erase(input);
    }
    for(std::set<string>::iterator iter = s.end(); iter!=s.begin();)
        cout<<*(--iter)<<"\n";

    return 0;
}
