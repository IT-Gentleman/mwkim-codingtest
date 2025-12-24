#include <iostream>

using std::cin;
using std::cout;

int main() {

    cin.tie(NULL);
    std::ios_base::sync_with_stdio(false);

    int a, b, sosu, sum=0, min=0;
    cin >> a >> b;
    for(int input=a; input<=b; input++){
        for(sosu=2;sosu<=input/2; sosu++) {
            if(input%sosu==0)
                break;
        }
        if(input!=1 && sosu>input/2) {
            if(!min)
                min=input;
            sum+=input;
        }
    }
    if(!sum)
        cout<<"-1";
    else
        cout<<sum<<"\n"<<min;;
    return 0;
}
