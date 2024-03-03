// Time Complexity : worse case O{100) which is nothing but O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : unable to use 2D bool vector as tought in class

/*
Leetcode : https://leetcode.com/problems/design-hashmap/)

Design a HashMap without using any built-in hash table libraries.

Implement the MyHashMap class:

MyHashMap() initializes the object with an empty map.
void put(int key, int value) inserts a (key, value) pair into the HashMap. If the key already exists in the map, update the corresponding value.
int get(int key) returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key.
void remove(key) removes the key and its corresponding value if the map contains the mapping for the key.
*/

// Your code here along with comments explaining your approach

/*
Code explanation : 
Hash Map stores key and value pair. One key can have only one value.
Node structure can be used to store both key and value.

Primary array will store pointers to each linked list.
for 0 to 1,000,000 data, we can have primary array into 10,000 elements and 
seconday array of 100 elements.

As secondary array is linked list, we need to iterate each element from head to find the key.
Therefore, it is better to use smaller elements in linked list. Hence, we are not using
primary array of 1000 elements and secondary array of 1000 elements as we have used in hashset.

Hashfunct gives index to primary array. Function is key%10000

We need to implement additional search function which will be used by all add, delete, find functions
We are using single linked list and not doubly link list; therefore we need to get
pointer to previous node from search function.
*/

class MyHashMap {
    class Node{
        public: 
            int key;
            int val;
            Node* next;

            Node(int key, int val) : key(key), val(val), next(nullptr) {}
    };

private:
        int size = 100000;
        Node* arr[100000];

public:
    MyHashMap() {
        // Initialize all elements to nullptr to avoid potential errors
        // C++ does not initialize to nullptr by default.
        // for pointers, use nullptr instead of NULL in c++
        for (int i = 0; i < size; ++i) {
            arr[i] = nullptr;
        }
    }

    int hashFunct (int key){
        return key%size;
    }
    
    Node* search(int key, int hash1){
        Node* prev = nullptr;
        Node* current = arr[hash1];
        while(current != nullptr && current->key != key){
            prev = current;
            current = current->next;
        }
        return prev;
    }

    // We are adding dummy node to start of each linked list, as this simplifies algorithm
    // else we need to check if node is head or not for put or delete.
    // Time Complexity : worse case O{100) which is nothing but O(1), becasue linked list
    // will be of size 100 only.
    void put(int key, int value) {
        int hash1 = hashFunct(key);
        if(arr[hash1] == nullptr){
            arr[hash1] = new Node(-1,-1); // adding dummy node, simplifies coding
        }
        Node* prev = search(key, hash1);
        if (prev->next == nullptr){
            prev->next = new Node(key, value);
        } else {
            prev->next->val = value;
        }
    }
    
    // Time Complexity : worse case O{100) which is nothing but O(1)
    int get(int key) {
        int hash1 = hashFunct(key);
        if(arr[hash1] == nullptr){
            return -1;
        }
        Node* prev = search(key, hash1);
        if (prev->next == nullptr){
            return -1;
        } 
        return prev->next->val;

    }
    
    // Time Complexity : worse case O{100) which is nothing but O(1)
    void remove(int key) {
        int hash1 = hashFunct(key);
        if(arr[hash1] == nullptr){
            return;
        }
        Node* prev = search(key, hash1);
        if (prev->next == nullptr){
            return;
        }
        Node* tmp = prev->next;
        prev->next = prev->next->next;
        tmp->next = nullptr;
    }
};

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap* obj = new MyHashMap();
 * obj->put(key,value);
 * int param_2 = obj->get(key);
 * obj->remove(key);
 */