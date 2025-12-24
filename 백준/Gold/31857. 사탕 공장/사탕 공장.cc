#include <iostream>

using std::cin;
using std::cout;

int n, r;

typedef struct node* nodePointer;
typedef struct node {
    char val;
    nodePointer llink;
    nodePointer rlink;
}node;
node storage[1000001]; int storageUsage=0;
nodePointer c[3]={nullptr, nullptr, nullptr};
nodePointer cr[3]={nullptr, nullptr, nullptr};

void insert(int conNum) {
    nodePointer ptr=nullptr, prev=nullptr;
    char input[500001];
    cin>>input;
    ptr = &storage[++storageUsage];
    ptr->val = input[0];
    c[conNum]=ptr;
    prev=ptr;
    for(int i=1;i<r;i++) {
        ptr = &storage[++storageUsage];
        prev->rlink=ptr;
        ptr->val = input[i];
        ptr->llink=prev;
        prev=ptr;
    }
    cr[conNum]=prev;
    for(int i=r;i<n;i++) {
        ptr = &storage[++storageUsage];
        prev->rlink=ptr;
        ptr->val = input[i];
        ptr->llink=prev;
        prev=ptr;
    }
    prev->rlink=c[conNum];
    c[conNum]->llink=prev;
}

inline void swapReference(nodePointer* a, nodePointer* b) {
    nodePointer temp=*a; *a=*b; *b=temp;
}

inline void crossFirst(nodePointer a, nodePointer b) {
    a->llink->rlink=b; b->llink->rlink=a;
    nodePointer temp=a->llink; a->llink=b->llink; b->llink=temp;
}

inline void crossLast(nodePointer a, nodePointer b) {
    a->rlink->llink=b; b->rlink->llink=a;
    nodePointer temp=a->rlink; a->rlink=b->rlink; b->rlink=temp;
}

inline void crossOperation(nodePointer* c1, nodePointer* c1p, nodePointer* c2, nodePointer* c2p) {
    //c1f, c2f : swap start location
    //c1l, c2l : swap finished location
    nodePointer c1f = *c1, c2f = *c2;
    nodePointer c1l = *c1p, c2l = *c2p;
    crossFirst(c1f, c2f);
    crossLast(c1l, c2l);
    swapReference( c1, c2);
    swapReference( c1p, c2p);
}

inline void operate(char input) {
    int index=0;
    if(input=='S') {
        if(r==n) {
            swapReference(&c[1], &c[2]);
            swapReference(&cr[1], &cr[2]);
        }
        else
            crossOperation(&c[1], &cr[1], &c[2], &cr[2]);
    }
    else if(input=='L') {
        cin>>index;
        c[index]=c[index]->rlink;
        cr[index]=cr[index]->rlink;
    }
    else if(input=='R') {
        cin>>index;
        c[index]=c[index]->llink;
        cr[index]=cr[index]->llink;
    }
    else if(input=='I') {
        r++;
        cr[1]=cr[1]->rlink;
        cr[2]=cr[2]->rlink;
    }
    else { //input=='S'
        r--;
        cr[1]=cr[1]->llink;
        cr[2]=cr[2]->llink;
    }
}

inline void printConveyer(int conNum) {
    nodePointer ptr=c[conNum];
    char output[5000001];
    for(int i=0;i<n;i++, ptr=ptr->rlink)
        output[i]=ptr->val;
    cout<<output<<"\n";
}

int main() {
    cin.tie(NULL);
    std::ios_base::sync_with_stdio(false);

    int q;
    cin>>n>>r>>q;
    insert(1);
    insert(2);
    char input;
    for(int i=0;i<q;i++) {
        cin>>input;
        operate(input);
    }
    printConveyer(1);
    printConveyer(2);

    return 0;
}
