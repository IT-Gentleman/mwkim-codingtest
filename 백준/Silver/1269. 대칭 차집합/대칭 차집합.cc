#include <iostream>
#include <algorithm>
#include <set>

using std::cin;
using std::cout;
using std::string;

std::set<int> inputs;

void insert(int value) {
    if(inputs.find(value)==inputs.end())
        inputs.insert(value);
    else
        inputs.erase(value);
}

int main() {
    cin.tie(NULL);
    std::ios_base::sync_with_stdio(false);

    int n, m;
    cin>>n>>m;
    for(int i=0;i<n+m;i++) {
        int input;
        cin>>input;
        insert(input);
    }
    cout<<inputs.size();

    return 0;
}
