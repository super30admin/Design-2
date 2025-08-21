// Time Complexity : O(1) amortized for get, put and remove
// Space Complexity : O(1), since input size is capped at 1e6 for the question
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Since we have a max input value of 1e6, we use 10000 as the primary array size, giving us a maximum of 100 collisions per index, which is reasonable.
// We use linear chaining here to avoid collisions, declare a primary array of nullptrs and whenever there is a collision, insert it in a linked list node forming a linear chain at each index.
// We use dummy node to help with complications/edge cases with deleting/inserting at the head of the linked list, etc.

#include <iostream>
using namespace std;

class MyHashMap {
private:
    struct Node { // llist node since we are going with linear chaining
        int key;
        int value;
        Node* next;
        Node(int key, int value){
            this->key = key;
            this->value = value;
            this->next = nullptr;
        }
    };
    Node** storage; // primary array
    int buckets; // primary array size

    int getPrimaryHash(int key){ // get index of key in the primary array
        return key % buckets;
    }

    Node* getPrevious(Node* prev, int key){ // helper function to traverse the llist and stop at the node before the node to be deleted/modified/returned
        Node* curr = prev->next;
        while(curr && curr->key != key){
            prev = curr;
            curr = curr->next;
        }
        return prev;
    }
public:
    MyHashMap() { // ctor
        buckets = 10000; // 1e4 since we have a max input value of 1e6 and we are going for linear chaining
        storage = new Node*[buckets](); // array of size 1e4, initialized to nullptrs
    }

    ~MyHashMap() { // dtor
        for (int i = 0; i < buckets; i++) {
            Node* prev = storage[i];
            while (prev) {
                Node* next = prev->next;
                delete prev; // free each node in each llist created
                prev = next;
            }
        }
        delete[] storage; // free the mem allocated for the primary array as well
    }
    
    void put(int key, int value) {
        // get primary array index
        int index = getPrimaryHash(key);
        if(!storage[index]) { // if we dont have a llist at that index
            // create a dummy node
            storage[index] = new Node(-1, -1);
            // assign next node as the key-value pair provided
            storage[index]->next = new Node(key, value);
            return;
        }
        Node* prev = getPrevious(storage[index], key);
        if(!prev->next) { // key doesn't exist in the llist, create a new node
            prev->next = new Node(key, value);
        } else { // key already exists, overwrite the value
            prev->next->value = value;
        }
    }
    
    int get(int key) {
        // get primary array index
        int index = getPrimaryHash(key);
        if(!storage[index]) { // if we dont have a llist at that index
            return -1;
        }
        Node* prev = getPrevious(storage[index], key);
        if(!prev->next){ // key does not exist
            return -1;
        }
        return prev->next->value; // return value
    }
    
    void remove(int key) {
        // get primary array index
        int index = getPrimaryHash(key);
        if(!storage[index]) { // if we dont have a llist at that index, then there is no key as well
            return;
        }
        Node* prev = getPrevious(storage[index], key);
        if(!prev->next) { // key does not exist in the llist
            return;
        }
        Node* curr = prev->next; // break the chain and rewire
        prev->next = curr->next;
        delete curr; // free deleted node to avoid memory leaks
    }
};

int main() {
    MyHashMap hashmap;
    hashmap.put(1,100);
    cout<<"Insert {1, 100}"<<endl;
    hashmap.put(1001,10000);
    cout<<"Insert {1001, 10000}"<<endl;
    hashmap.put(1,101);
    cout<<"Insert {1, 101} (overwrite prev value for key 1)"<<endl;
    hashmap.remove(1001);
    cout<<"Remove 1001"<<endl;
    cout<<"Get value for 1001: "<<hashmap.get(1001)<<endl;
    cout<<"Get value for 1: "<<hashmap.get(1)<<endl;
 }