#include <iostream>
#include <algorithm>
#include <unordered_map>

using std::cin;
using std::cout;
using std::string;

std::unordered_map<string, int> m;

bool isAlpha(char input) {
    if(input>='0'&&input<='9')
        return false;
    return true;
}

int main() {
    cin.tie(NULL);
    std::ios_base::sync_with_stdio(false);

    int a, b;
    cin>>a>>b;
    string* list=new string[a+1];
    for(int i=1;i<=a;i++) {
        cin>>list[i];
        m.insert({list[i], i});
    }
    string input;
    for(int i=0;i<b;i++) {
        cin>>input;
        if(isAlpha(input[0])) {
            cout<<m.find(input)->second<<"\n";
        }
        else
            cout<<list[std::stoi(input)]<<"\n";
    }

    delete[] list;
    return 0;
}
