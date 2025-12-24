#include <iostream>
#include <algorithm>
#include <set>

using std::cin;
using std::cout;
using std::string;

std::set<string> *inputs;

int main() {
    cin.tie(NULL);
    std::ios_base::sync_with_stdio(false);

    string input;
    cin>>input;
    inputs = new std::set<string>[input.length()];
    for(int i=0;i<input.length(); i++) {
        for(int j=1; j+i<=input.length(); j++)
            inputs[j-1].insert(input.substr(i, j));
    }
    int result=0;
    for(int i=0;i<input.length();i++)
        result+=inputs[i].size();
    cout<<result;
    return 0;
}
