#include <iostream>
#include <algorithm>
#include <set>

using std::cin;
using std::cout;
using std::string;

std::set<string> inputs;
std::set<string> result;

void insert(string value) {
    if(inputs.find(value)==inputs.end())
        inputs.insert(value);
    else
        result.insert(value);
}

int main() {
    cin.tie(NULL);
    std::ios_base::sync_with_stdio(false);

    int n, m;
    cin>>n>>m;
    for(int i=0;i<n+m;i++) {
        string input;
        cin>>input;
        insert(input);
    }
    cout<<result.size()<<"\n";
    for(std::set<string>::iterator iter = result.begin(); iter!=result.end(); iter++)
        cout<<*iter<<"\n";
    
    return 0;
}
