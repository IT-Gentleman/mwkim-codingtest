#include <iostream>

using std::cin;
using std::cout;

int n, m;
int arr[10];

void func(int lev, int n, int m) {
    if(lev>m) {
        for(int i=1; i<lev; i++) {
            cout << arr[i] << " ";
        }
        cout << "\n";
        return;
    }
    for(int i=arr[lev-1]+1; i<=n; i++) {
        arr[lev]=i;
        func(lev+1, n, m);
    }
}

int main() {
    cin.tie(NULL);
    std::ios_base::sync_with_stdio(false);

    cin >> n >> m;

    func(1, n, m);

    return 0;
}
