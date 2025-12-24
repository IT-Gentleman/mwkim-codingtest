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
    for(int i=1; i<=n; i++) {
        short int cont=0;
        for(int j=1; j<lev; j++)
            if(arr[j]==i)
                cont=1;
        if(cont)
            continue;
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