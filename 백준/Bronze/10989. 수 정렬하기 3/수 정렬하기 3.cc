#include <iostream>
#include <algorithm>

using std::cin;
using std::cout;

int main() {
    cin.tie(NULL);
    std::ios_base::sync_with_stdio(false);

    unsigned long long n;
    cin>>n;
    int* count = new int[10001];
    std::fill(&count[1], &count[10000], 0);
    int input;
    for(unsigned int i=0; i<n;i++) {
        cin>>input;
        count[input]++;
    }
    for(int i=1;i<=10000;i++)
        for(int j=0;j<count[i]; j++)
            cout<<i<<"\n";

    return 0;
}
