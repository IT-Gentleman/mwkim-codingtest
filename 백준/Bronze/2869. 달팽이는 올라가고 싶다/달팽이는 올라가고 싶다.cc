#include <iostream>
#include <cmath>

using std::cin;
using std::cout;

int main() {

    cin.tie(NULL);
    std::ios_base::sync_with_stdio(false);

    int a, b, v;
    cin>>a>>b>>v;
    cout << (int)ceil(1.0*(v-a)/(a-b)) + 1;

    return 0;
}
