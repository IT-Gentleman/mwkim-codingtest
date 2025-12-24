#include <iostream>
#include <algorithm>
#include <unordered_map>

using std::cin;
using std::cout;
using std::string;

std::unordered_map<int, int> hashMap;

void insert(int value) {
    std::unordered_map<int, int>::iterator iter = hashMap.find(value);
    if(iter==hashMap.end())
        hashMap.insert({value, 1});
    else {
        int count = iter->second;
        hashMap[value]=count + 1;
    }
}

int pop(int value) {
    std::unordered_map<int, int>::iterator iter = hashMap.find(value);
    if(iter==hashMap.end())
        return 0;
    return iter->second;
}

int main() {
    cin.tie(NULL);
    std::ios_base::sync_with_stdio(false);

    int n, m;
    cin>>n;
    for(int i=0;i<n;i++) {
        int input;
        cin>>input;
        insert(input);
    }
    cin>>m;
    for(int i=0;i<m;i++) {
        int input;
        cin>>input;
        cout<<pop(input)<<" ";
    }
    return 0;
}
