#include <iostream>
#include <algorithm>
#include <string>

using std::cin;
using std::cout;

int main() {
    cin.tie(NULL);
    std::ios_base::sync_with_stdio(false);

    int n;
    cin>>n;
    std::string input;
    for(int i=0;i<n;i++) {
        int sum=0, jukrip=0;
        cin>>input;
        for(int j=0;j<input.length();j++) {
            if(input[j]=='O')
                sum+=++jukrip;
            else
                jukrip=0;
        }
        cout<<sum<<"\n";
    }

    return 0;
}
