#include <iostream>

using std::cin;
using std::cout;

int main() {

    cin.tie(NULL);
    std::ios_base::sync_with_stdio(false);

    int input[3];
    for(int i=0;i<3;i++)
        cin>>input[i];
    while(input[0]!=0) {
        int max=0, yee=0, minSum=0;;
        int comp[3][2]={{0,1}, {0,2}, {1,2}};
        for(int i=0;i<3;i++) {
            if(input[i]>max) {
                minSum+=max;
                max=input[i];
            }
            else
                minSum+=input[i];
            if(input[comp[i][0]]==input[comp[i][1]]) {
                if(yee==1)
                    yee=-1;
                else if(yee==0)
                    yee=1;
            }
        }
        if(max>=minSum)
            cout<<"Invalid\n";
        else {
            if(yee==1)
                cout<<"Isosceles\n";
            else if(yee==0)
                cout<<"Scalene\n";
            else //yee==-1
                cout<<"Equilateral\n";
        }
        for(int i=0;i<3;i++)
            cin>>input[i];
    }
    return 0;
}
