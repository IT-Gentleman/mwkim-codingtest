#include <iostream>

using std::cin;
using std::cout;

int main() {

    cin.tie(NULL);
    std::ios_base::sync_with_stdio(false);

    int x, y, w, h;
    cin>>x>>y>>w>>h;
    cout<<std::min(std::min(x, w-x), std::min(y, h-y));

    return 0;
}
