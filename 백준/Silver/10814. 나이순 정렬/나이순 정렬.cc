#include <iostream>
#include <algorithm>
#include <utility>

using std::cin;
using std::cout;
using std::string;

typedef struct linkedNode* linkedList;
typedef struct linkedNode {
    string name;
    linkedList link;
}linkedNode;
linkedList* list;

void makeNode(int age, string name) {
    linkedList newNode;
    newNode = new linkedNode;
    newNode->name.assign(name);
    newNode->link=nullptr;
    if(list[age]) {
        linkedList temp = list[age];
        while(temp->link)
            temp=temp->link;
        temp->link=newNode;
    }
    else
        list[age]=newNode;
}

void printNode(int age) {
    linkedList temp = list[age];
    while(temp) {
        cout<<age<<" "<<temp->name<<"\n";
        temp=temp->link;
    }
}

int main() {
    cin.tie(NULL);
    std::ios_base::sync_with_stdio(false);

    list = new linkedList[201];

    int n, age;
    string name;
    cin>>n;

    for(int i=0;i<n;i++) {
        cin>>age>>name;
        makeNode(age, name);
    }

    for(int i=1;i<=200;i++)
        printNode(i);

    return 0;
}
