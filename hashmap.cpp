// Time Complexity : O(1) as the size of linkedlist is constant (100) at each index
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// Using open chaining, made an primary array of size 10,000  so that each column have at most 100 elements in the linkedlist
#include <iostream>
#include <vector>
using namespace std;

class MyHashMap {
private:
    int size = 10000;
    struct Node
    {
        int key,value;
        Node* next;
        Node(int k,int v,Node* addr)
        {
            key=k;
            value=v;
            next=addr;
        }
    };
    //10^6 / 100 so that each column have at most 100 elements;
    vector<Node*> hashMap;
    int hash1(int key)
    {
        return key%size;
    }
public:
 MyHashMap() : hashMap(size, nullptr) {
        for(int i = 0;i<size;i++)
        {
            hashMap[i] = new Node(-1,-1,nullptr);
        }
    }
    Node* find(int key)
    {
        Node* curr = hashMap[hash1(key)]; Node* prev = nullptr;
        while(curr!=nullptr)
        {
            if(curr->key==key)
                break;
            prev = curr;
            curr = curr->next;
        }
        return prev;

    }
    void put(int key, int value) {

        Node* temp = find(key);
        //if temp->next!=nullptr then key already present and hence we just update
        if(temp->next==nullptr)
        {
            temp->next = new Node(key,value,nullptr);
        }
        else
        {
            temp->next->value= value;
        }
        
    }
    
    int get(int key) {

        Node* temp = find(key);
        //if temp->next!=nullptr then key already present and hence we don't need to do anything;
        if(temp->next==nullptr)
        {
            return -1;
        }
        return temp->next->value;
        
    }
    
    void remove(int key) {

        Node* temp = find(key);
        //if temp->next==nullptr then key is not present present and hence we don't need to do anything;
        if(temp->next!=nullptr)
        {
            Node* toDelete = temp->next;
            temp->next = toDelete->next;
            delete toDelete;
        }
        
    }
};