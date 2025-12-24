#include <iostream>

using std::cin;
using std::cout;

int main() {

    cin.tie(NULL);
    std::ios_base::sync_with_stdio(false);

    int input[3];
    for(int i=0;i<3;i++)
        cin>>input[i];
    int yee=0;
    int comp[3][2]={{0,1}, {0,2}, {1,2}};
    int sum=0;
    for(int i=0;i<3;i++) {
        sum+=input[i];
        if(input[comp[i][0]]==input[comp[i][1]]) {
            if(yee==1)
                yee=-1;
            else if(yee==0)
                yee=1;
        }
    }
    if(sum!=180)
        cout<<"Error";
    else {
        if(yee==1)
            cout<<"Isosceles";
        else if(yee==0)
            cout<<"Scalene";
        else //yee==-1
            cout<<"Equilateral";
    }
    return 0;
}
