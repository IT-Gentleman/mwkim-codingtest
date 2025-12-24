//i love heap sort
#include <iostream>
#include <algorithm>
#include <utility>

using std::cin;
using std::cout;
using std::string;

string* heap;
int last=0; //using from index 1
int n;

int nodeComp(string n1, string n2) {
    if(n1.length()<n2.length())
        return 0;
    if(n1.length()==n2.length())
        for(int j=0;j<n1.length(); j++) {
            if(n1[j]<n2[j])
                return 0;
            if(n1[j]>n2[j])
                return 1;
        }
    return 1; //>
}

int nodeCompSwap(string* n1, string* n2) {
    if(*n1=="it")
        cout<<"";
    if(*n1==*n2)
        return 1; //no need to compare more, no swap needed
    if(n1->length()<n2->length()) {
        std::swap(*n1, *n2);
        return 1;
    }
    if(n1->length()==n2->length())
        for(int j=0;j<n1->length(); j++) {
            if(n1[j]<n2[j]) {
                std::swap(*n1, *n2);
                return 1;
            }
            if(n1[j]>n2[j])
                return 0;
        }
    return 0; //>
}

void heapInsert(string* heap) {
    int index=++last;
    cin>>heap[index];
    for(int i=index; i>1; i/=2)
        if(!nodeCompSwap(&heap[i], &heap[i/2])) //swap happened
            break;
}
string lastReturn;
void heapPop(string* heap) {
    int index = last--;
    if(heap[1]!=lastReturn) {
        lastReturn.assign(heap[1]);
        cout<<heap[1]<<"\n";
    }
    std::swap(heap[index], heap[1]);
    for(int i=1, toSwap=0;i<last;toSwap=0) {
        int smaller;
        if(i*2+1<=last) {
            //i*2+1>=last 포함
            smaller = nodeComp(heap[i*2], heap[i*2+1]);
            if(nodeComp(heap[i],heap[i*2+smaller]))
                toSwap = i*2 + smaller;
        }
        else if(i*2<=last) {
            if(nodeComp(heap[i],heap[i*2]))
                toSwap=i*2;
        }
        if(toSwap) {
            std::swap(heap[toSwap], heap[i]);
            i=toSwap;
        }
        else
            break;
    }
}

int main() {
    cin.tie(NULL);
    std::ios_base::sync_with_stdio(false);

    int input;
    cin>>n;
    heap=new string[n+1];

    for(int i=0;i<n;i++) {
        heapInsert(heap);
    }
    for(int i=0;i<n;i++)
        heapPop(heap);

    delete[] heap;

    return 0;
}
