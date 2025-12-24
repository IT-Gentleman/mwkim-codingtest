//heapsort & struct
#include <iostream>
#include <algorithm>

using std::cin;
using std::cout;

typedef struct coord {
    int x;
    int y;
}coord;

coord* heap;
int last=0; //using from index 1
int n;

void heapInsert(coord* heap, int inputX, int inputY) {
    int index=++last;
    heap[index].x=inputX;
    heap[index].y=inputY;
    for(int i=index; i>1; i/=2) {
        if(heap[i].x<heap[i/2].x)
            std::swap(heap[i], heap[i/2]);
        else if(heap[i].x==heap[i/2].x && heap[i].y<heap[i/2].y)
            std::swap(heap[i], heap[i/2]);
        else
            break;
    }
}
coord heapPop(coord* heap) {
    int index = last--;
    coord returnVal = heap[1];
    std::swap(heap[index], heap[1]);
    for(int i=1, toSwap=0;i<last;toSwap=0) {
        int smaller;
        if(i*2+1<=last) {
            if(heap[i*2].x==heap[i*2+1].x) //y comp
                smaller = (heap[i*2].y<heap[i*2+1].y)?0:1;
            else //x comp
                smaller = (heap[i*2].x<heap[i*2+1].x)?0:1;
            if(heap[i].x==heap[i*2+smaller].x && heap[i].y>heap[i*2+smaller].y) //y comp
                toSwap = i*2 + smaller;
            else if(heap[i].x>heap[i*2+smaller].x)
                toSwap = i*2 + smaller;
        }
        else if(i*2<=last) {
            if(heap[i].x==heap[i*2].x && heap[i].y>heap[i*2].y)
                toSwap=i*2;
            else if(heap[i].x>heap[i*2].x)
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

    int x, y;
    cin>>n;
    heap=new coord[n+1];

    for(int i=0;i<n;i++) {
        cin>>x>>y;
        heapInsert(heap, x, y);
    }
    for(int i=0;i<n;i++) {
        coord output = heapPop(heap);
        cout<<output.x << " " << output.y<<"\n";
    }

    delete[] heap;

    return 0;
}
