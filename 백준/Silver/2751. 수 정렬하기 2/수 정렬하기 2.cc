#include <iostream>
#include <algorithm>

using std::cin;
using std::cout;

int* heap;
int last=0; //using from index 1
int n;

void heapInsert(int* heap, int input) {
    int index=++last;
    heap[index]=input;
    for(int i=index; i>1; i/=2) {
        if(heap[i]<heap[i/2])
            std::swap(heap[i], heap[i/2]);
        else
            break;
    }
}
int heapPop(int* heap) {
    int index = last--;
    int returnVal = heap[1];
    std::swap(heap[index], heap[1]);
    for(int i=1, toSwap=0;i<last;toSwap=0) {
        int smaller;
        if(i*2+1<=last) {
            //i*2+1>=last 포함
            smaller = (heap[i*2]<heap[i*2+1])?0:1;
            if(heap[i]>heap[i*2+smaller])
                toSwap = i*2 + smaller;
        }
        else if(i*2<=last) {
            if(heap[i]>heap[i*2])
                toSwap=i*2;
        }
        if(toSwap) {
            std::swap(heap[toSwap], heap[i]);
            i=toSwap;
        }
        else
            break;
    }
    return returnVal;
}

int main() {
    cin.tie(NULL);
    std::ios_base::sync_with_stdio(false);

    int input;
    cin>>n;
    heap=new int[n+1];

    for(int i=0;i<n;i++) {
        cin>>input;
        heapInsert(heap, input);
    }
    for(int i=0;i<n;i++)
        cout<<heapPop(heap)<<"\n";

    delete[] heap;

    return 0;
}
