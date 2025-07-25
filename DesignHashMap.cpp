#include<iostream>
#include<vector>
using namespace std;
/*
->Building a Hash map without using any standard library function
->we use Linear chaining(linked lists) here to handle collisions
->use initial storage as vector buckets and each bucket holds a linked list
->Used a dummy node and a getPrev method to simplify operations
TC: O(1), SC:O(n)
*/
class MyHashMap {
    struct Node{
        int key, value;
        Node* next;
        Node(int k,int v) : key(k), value(v), next(nullptr) {}
    };

    vector<Node*> storage;
    int buckets;

    int getHash(int key){//primary hash fucntion
        return key%buckets;
    }
    Node* getPrev(Node* head, int key){
        Node* prev=nullptr;
        Node* curr=head;
        while(curr && curr->key != key){
            prev=curr;
            curr=curr->next;
        }
        return prev;
    }

public:
    MyHashMap() {
        buckets=10000;//creating a bucket of size 1000 or 10000
        storage=vector<Node*>(buckets, nullptr);
    }
    
    void put(int key, int value) {
        int index=getHash(key);
        if(!storage[index]){
            storage[index]=new Node(-1,-1);//creating a dummy node
            storage[index]->next=new Node(key, value);
            return;
        }
        Node* prev=getPrev(storage[index],key);
        if(!prev->next){
            prev->next=new Node(key, value);
        }
        prev->next->value=value;
    }
    
    int get(int key) {
        int index=getHash(key);
        if(!storage[index]) return -1;
        Node* prev=getPrev(storage[index],key);
        if(!prev->next) return -1;
        return prev->next->value;
    }
    
    void remove(int key) {
        int index=getHash(key);
        if(!storage[index]) return;
        Node* prev=getPrev(storage[index],key);
        if(!prev->next) return;
        Node* temp=prev->next;
        prev->next=temp->next;
        delete temp;
    }
};

int main(){

}