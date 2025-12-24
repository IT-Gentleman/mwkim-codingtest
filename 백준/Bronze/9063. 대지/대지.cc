#include <iostream>

using std::cin;
using std::cout;

int main() {

    cin.tie(NULL);
    std::ios_base::sync_with_stdio(false);

    int x[2]={10000, -10000}, y[2]={10000,-10000};
    int n, a, b;
    cin>>n;
    for(int i=0;i<n;i++) {
        cin>>a>>b;
        x[0]=std::min(x[0], a);
        x[1]=std::max(x[1], a);
        y[0]=std::min(y[0], b);
        y[1]=std::max(y[1], b);
    }
    cout<<(x[1]-x[0])*(y[1]-y[0]);
    return 0;
}
