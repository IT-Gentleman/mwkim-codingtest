#include <iostream>

using std::cin;
using std::cout;

int* list;
int n, max;

int sum(int summation, int index, int remain) {
    if(summation>max)
        return 0;
    if(remain==0)
        return summation;
    if(index==n) //&&remain!=0 (index is out of range)
        return 0;
    return std::max(sum(summation+list[index], index+1, remain-1), sum(summation, index+1, remain));
}

int main() {

    cin.tie(NULL);
    std::ios_base::sync_with_stdio(false);

    cin>>n>>max;
    list = new int[n];
    for(int i=0;i<n;i++)
        cin>>list[i];
    cout<<sum(0, 0, 3);

    delete[] list;
    return 0;
}
