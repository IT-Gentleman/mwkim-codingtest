#include <iostream>

using std::cin;
using std::cout;

int main() {

    cin.tie(NULL);
    std::ios_base::sync_with_stdio(false);

    int input;
    cin>>input;
    while(input!=-1) {
        int sum=0;
        int* yak=new int[input];
        int index=-1;
        for(int i=1; i<input; i++)
            if(input%i==0) {
                sum+=i;
                yak[++index]=i;
            }
        if(sum==input) {
            cout<<input<<" = ";
            for(int i=0; i<index; i++)
                cout<<yak[i]<<" + ";
            cout<<yak[index]<<"\n";
        }
        else
            cout<<input<<" is NOT perfect.\n";
        delete[] yak;
        cin>>input;
    }
    return 0;
}
