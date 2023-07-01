/*
This is implementation of a hashMap with buckets pointing to a linked list which is made up of key value pairs.
// Time Complexity : 
hash method : O(1)
findNode method : O(1) but amortized it's  O(m) , where m is the length of linked list.
put method : same as above.
get method : same as above.
remove method : same as above. 


// Space Complexity : O(k + m), k = number of buckets , m = 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : yes, on line 22 i was getting garbage returned when accessing a node after creation. and it got fixed after i renamed the params of the constructor Node with an underscore _.


*/
class Node {
public:
    int value; 
    int key;
    Node * next;
    Node(int _key, int _value) {
        key = _key;
        value = _value;
        next = nullptr;
    }
};

class MyHashMap {
public:
    vector<Node *> storage;
    int buckets; // size of the hashMap ie 10000
    MyHashMap() {
        buckets = 10000;
        vector<Node *> temp(buckets);
        storage = temp;
    }

    int hash(int key) {
        return key % buckets;
    }

    Node * findNode(Node * head, int searchKey) {
        // returns the previous node of the target node with value searchKey or returns the last node when not found.
        Node * curr = head;
        while(curr != nullptr && curr->next != nullptr && curr->next->key != searchKey) {
            curr = curr->next;
        }
        return curr;
    }
    
    void put(int key, int value) {
        int bucket = hash(key);
        if(storage[bucket] == nullptr) {
            Node * dummyNode = new Node(INT_MIN, INT_MIN); // create a dummy node for the starting node.
            storage[bucket] = dummyNode;
        }
        Node * prev = findNode(storage[bucket], key);
        if(prev->next == nullptr) {
            prev->next = new Node(key, value);
        } else {
            prev->next->value = value;
        }

    }

    
    
    int get(int key) {
        int bucket = hash(key);
        if(storage[bucket] == nullptr) {
            return -1;
        }
        Node * prev = findNode(storage[bucket], key);
        if(prev->next == nullptr) {
            return -1;
        }
        return prev->next->value;
    }
    
    void remove(int key) {
        int bucket = hash(key);
        if(storage[bucket] == nullptr) {
            return ;
        }
        Node * prev = findNode(storage[bucket], key);
        if(prev->next == nullptr) {
            return ;
        }
        prev->next = prev->next->next;
    }
};

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap* obj = new MyHashMap();
 * obj->put(key,value);
 * int param_2 = obj->get(key);
 * obj->remove(key);
 */
