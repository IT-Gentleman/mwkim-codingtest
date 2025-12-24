#include <iostream>

using std::cin;
using std::cout;

int main() {
    cin.tie(NULL);
    std::ios_base::sync_with_stdio(false);

    int n, k, i, j;
    cin>>n>>k;
    int input;
    int* list = new int[n];
    for(i=0;i<n;i++) {
        cin>>input;
        for(j=0;j<i;j++) //j 최종값은 삽입되어야할 위치
            if(input < list[j])
                break;
        for(int l=i; l>=j+1; l--)
            list[l]=list[l-1];
        list[j]=input;
    }
    cout<<list[n-k];
    delete[] list;
    return 0;
}
