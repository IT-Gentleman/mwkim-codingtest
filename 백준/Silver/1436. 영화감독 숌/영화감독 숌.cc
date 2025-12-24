#include <iostream>
#include <string>

using std::cin;
using std::cout;

int main() {
    cin.tie(NULL);
    std::ios_base::sync_with_stdio(false);

    int n;
    cin>>n;
    int count=1, value=666;
    std::string temp;
    while(count<n) {
        temp=std::to_string(++value);
        if(temp.find("666")!=std::string::npos)
            count++;
    }
    cout<<value;

    return 0;
}
