#include <iostream>
#include <algorithm>
#include <unordered_map>
#include <climits>

using std::cin;
using std::cout;
using std::string;

int* heap;
int last=0; //using from index 1
int n;

std::unordered_map<int, int> hashMap;

int nodeComp(int n1, int n2) {
    if(n1<n2)
        return 0;
    return 1; //>
}

int nodeCompSwap(int* n1, int* n2) {
    if(*n1==*n2)
        return 1; //no need to compare more, no swap needed
    if(*n1<*n2) {
        std::swap(*n1, *n2);
        return 1;
    }
    return 0; //>
}

void heapInsert(int* heap, int input) {
    int index=++last;
    heap[index]=input;
    for(int i=index; i>1; i/=2)
        if(!nodeCompSwap(&heap[i], &heap[i/2])) //swap happened
            break;
}
int lastReturn;
int heapPop(int* heap) {
    int index = last--;
    int returnVal=INT_MAX;
    if(heap[1]!=lastReturn) {
        lastReturn=heap[1];
        returnVal=heap[1];
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
    return returnVal;
}

int main() {
    cin.tie(NULL);
    std::ios_base::sync_with_stdio(false);

    cin>>n;
    heap=new int[n+1];
    int* array = new int[n];

    int input;
    for(int i=0;i<n;i++) {
        cin>>input;
        heapInsert(heap, input);
        array[i]=input;
    }

    int output;
    for(int i=0, j=0;i<n;i++) {
        output=heapPop(heap);
        if(output!=INT_MAX)
            hashMap.insert({output, j++});
    }

    for(int i=0;i<n;i++)
        cout<<hashMap[array[i]]<<" ";

    delete[] array;
    delete[] heap;

    return 0;
}
