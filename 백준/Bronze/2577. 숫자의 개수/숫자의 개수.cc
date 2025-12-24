#include <iostream>
#include <algorithm>
#include <string>

using std::cin;
using std::cout;

int main() {
    cin.tie(NULL);
    std::ios_base::sync_with_stdio(false);

    int jugi[10];
    for(int i=0;i<10;i++)
        jugi[i]=0;
    int mul=1;
    int input;
    for(int i=0;i<3;i++) {
        cin>>input;
        mul*=input;
    }
    std::string res = std::to_string(mul);
    for(int i=0;i<res.length();i++)
        jugi[res[i]-'0']++;
    for(int i=0;i<10;i++)
        cout<<jugi[i]<<"\n";
    return 0;
}
