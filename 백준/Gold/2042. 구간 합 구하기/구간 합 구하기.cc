#include <iostream>
#include <cmath>
using namespace std;

typedef struct segNode {
    int start;
    int end;
    long long value;
}segNode;

class segTree {
private:
    int length;
    segNode* node; //maxLength=1,000,000 -> 2^(ceil(log2(maxLen)+1)
public:
    segTree(int length);
    long long init(int index, int b, int c);
    void changeVal(int index, int changeIndex, long long val);
    long long returnVal(int index, int b, int c);
    ~segTree();
};

segTree::segTree(int length) {
    this->length = length;
    int height = (int)ceil(log2(length));
    //전체 트리 크기 : 2^(height+1) = 1<<(height+1)
    int newLength = pow(2, height + 1);
    int lastLength = pow(2, height);
    node = new segNode[newLength];
    this->init(1, 0, lastLength - 1);
    //   for (int i = 1; i <= (1<<height)-1; i++)
    //       cout << node[i].value << "\n";
}

long long segTree::init(int index, int b, int c) {
    //cout << index << " " << b << " " << c << "\n";
    node[index].start = b;
    node[index].end = c;
    if (b >= length) {
        node[index].value = 0LL;
        return 0LL;
    }
    if (b == c) {
        cin >> node[index].value;
        //cout << node[index].value << " inputed! at " << index << "\n";
        return node[index].value;
    }
    return node[index].value = this->init(index * 2, b, (b + c) / 2) + this->init(index * 2 + 1, (b + c) / 2 + 1, c);
}

void segTree::changeVal(int index, int changeIndex, long long val) {
    if (node[index].start == node[index].end) {
        node[index].value = val;
        return;
    }
    int mid = (node[index].start + node[index].end) / 2;
    if (changeIndex <= mid)
        this->changeVal(index * 2, changeIndex, val);
    else if (changeIndex >= mid + 1)
        this->changeVal(index * 2 + 1, changeIndex, val);
    node[index].value = node[index * 2].value + node[index * 2 + 1].value;
}

long long segTree::returnVal(int index, int b, int c) {
    //index : accessing tree's index -> initial call's index = 1
    //b & c : b~c-th num access
    if (b == node[index].start && c == node[index].end)
        return node[index].value;
    int mid = (node[index].start + node[index].end) / 2;
    if (c <= mid) //leftChildOnly
        return this->returnVal(index * 2, b, c);
    if (b >= mid + 1)
        return this->returnVal(index * 2 + 1, b, c);
    return this->returnVal(index * 2, b, mid) + this->returnVal(index * 2 + 1, mid + 1, c);
}

segTree::~segTree() {
    delete[] node;
}

int main(void) {
    cin.tie(NULL);
    std::ios_base::sync_with_stdio(false);

    int n, m, k;
    cin >> n >> m >> k;
    segTree tree(n);

    int a, b, c;
    long long val;
    for (int i = 0, j = 0; i < m || j < k;) {
        cin >> a >> b;
        switch (a) {
        case 1:
            cin >> val;
            tree.changeVal(1, b - 1, val); //b번째이기에 index b-1
            i++;
            break;
        case 2:
            cin >> c;
            cout << tree.returnVal(1, b - 1, c - 1) << "\n"; //번째이기에 -1
            j++;
            break;
        default:
            cin >> c;
        }
    }

    return 0;
}