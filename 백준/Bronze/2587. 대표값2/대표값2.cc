#include <iostream>

using std::cin;
using std::cout;

int main() {
    cin.tie(NULL);
    std::ios_base::sync_with_stdio(false);

    int n, i, j;
    n=5;
    int input;
    int* list = new int[n];
    int sum=0;
    for(i=0;i<n;i++) {
        cin>>input;
        sum+=input;
        for(j=0;j<i;j++) //j 최종값은 삽입되어야할 위치
            if(input < list[j])
                break;
        for(int l=i; l>=j+1; l--)
            list[l]=list[l-1];
        list[j]=input;
    }
    cout<<sum/5<<"\n"<<list[2];
    delete[] list;
    return 0;
}
