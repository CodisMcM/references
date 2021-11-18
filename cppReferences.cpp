#include <iostream>
#include <cstdlib>
#include <string>

using namespace std;

struct bst {
    int value;
    bool visited;
    bst* lchild;
    bst* rchild;
    bst* parent;
};




bst* insertNode(bst* root, int value) {

    bst* newNode = new bst;
    newNode->value = value;
    newNode->lchild = NULL;
    newNode->rchild = NULL;
    if(!root){
        root = newNode;
        newNode->parent = NULL;
        cout << "Inserting: " << newNode->value << endl;

        return root;
    }

    bst* curr = root;
    
    while(curr->lchild || curr->rchild) {
        if(curr->value > value) {
            if(curr->rchild) {
                curr = curr->rchild;
            }
            else {
                curr->rchild = newNode;
                newNode->parent = curr;
                cout << "Inserting: " << newNode->value << endl;
                return root;
            }
        }
        else {
            if(curr->lchild) {
                curr = curr->lchild;
            }
            else{
                curr->lchild = newNode;
                newNode->parent = curr;
                cout << "Inserting: " << newNode->value << endl;

                return root;
            }
        }
    }

    if(newNode->value > curr->value){
        curr->rchild= newNode;
        newNode->parent = curr;
        cout << "Inserting: " << newNode->value << endl;

        return root;
    }
    curr->rchild = newNode;
    newNode->parent = curr;
    cout << "Inserting: " << newNode->value << endl;

    return root;
}   

bst* printHelper(bst* node, int select) {

    switch(select) {
        case 1:
            if(!node)
                return NULL;
            printHelper(node->lchild, select);
            cout << node->value << endl;
            printHelper(node->rchild, select);
            break;
        case 2:
            if(!node)
                return NULL;
            cout << node->value << endl;
            printHelper(node->lchild, select);
            printHelper(node->rchild, select);
            break;
        case 3:
            if(!node)
                return NULL;
            printHelper(node->lchild, select);
            printHelper(node->rchild, select);
            cout << node->value << endl;
            break;
        case 4:
            if(!node)
                return NULL;
            
            

    }

    return NULL;

}


void printNodes(bst* root) {

    while(true) {
        cout << "Which print would you like to run?" << endl;
        cout << "1. In-order Traversal" << endl;
        cout << "2. Pre-order Traversal" << endl;
        cout << "3. Post-order Traversal" << endl;
        cout << "4. Level-order Traversal" << endl;
        cout << "5. Quit" << endl;

        int select; 
        cin >> select;
        cout << endl;
        if(select == 5){
            break;
        }
        printHelper(root, select);

    }
    

    return;

}





int main (int argc, char* argv[]) {

    srand(time(NULL));


    

    bst* root;

    for(int i = 0; i < 10; i++){
        root = insertNode(root, (rand() % 20));
    }

    printNodes(root);


    return 0;
}



// g++ -std=c++11 -Wall cppReferences.cpp -o exe