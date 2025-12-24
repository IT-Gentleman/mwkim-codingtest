#include <iostream>

using std::cin;
using std::cout;

int n, m;
int arr[10];
int input[10];

void func(int lev) {
    if(lev>m) {
        for(int i=1; i<lev; i++) {
            cout << arr[i] << " ";
        }
        cout << "\n";
        return;
    }
    for(int i=1; i<=n; i++) {
        short int cont=0;
        for(int j=0; j<lev; j++)
            if(arr[j]>input[i-1])
                cont=1;
        if(cont)
            continue;
        arr[lev]=input[i-1];
        func(lev+1);
    }
}

int main() {
    cin.tie(NULL);
    std::ios_base::sync_with_stdio(false);

    int inp, i, j;

    cin >> n >> m;
    for(i=0; i<n; i++) {
        cin >> inp;
        for(j=0; j<i; j++)
            if(inp<input[j])
                break;
        for(int k=i; k>j; k--)
            input[k]=input[k-1];
        input[j]=inp;
    }

    func(1);

    return 0;
}
