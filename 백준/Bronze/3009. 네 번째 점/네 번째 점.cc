#include <iostream>

using std::cin;
using std::cout;

int main() {

    cin.tie(NULL);
    std::ios_base::sync_with_stdio(false);

    int row[2]={-1,-1}, col[2]={-1,-1};
    for(int i=0;i<3;i++) {
        int a, b;
        cin>>a>>b;
        for(int j=0;j<2;j++) {
            if(row[j]==-1)
                row[j]=a;
            else if(row[j]==a)
                row[j]=0;
            else
                continue;//other value;
            break;//changed value(value used)
        }
        for(int j=0;j<2;j++) {
            if(col[j]==-1)
                col[j]=b;
            else if(col[j]==b)
                col[j]=0;
            else
                continue;//other value;
            break;//changed value(value used)
        }
    }
    int rowRes, colRes;
    for(int j=0;j<2;j++) {
        if(row[j])
            rowRes=row[j];
        if(col[j])
            colRes=col[j];
    }
    cout<<rowRes<<" "<<colRes;

    return 0;
}
