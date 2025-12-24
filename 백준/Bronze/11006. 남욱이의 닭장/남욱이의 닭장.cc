#include<iostream>
int main(void){
    int a,b,c;
    std::cin>>a;
    for(int i=0;i<a;i++){
        std::cin>>b>>c;
        std::cout<<2*c-b<<" "<<b-c<<std::endl;
    }
    return 0;
}