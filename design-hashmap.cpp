/*
TC : O(1) amortized
SC: O(n)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
Logic:
Implementing chaining collision resolution, this gives better space but with a time trade off. But here we can use
10^4 instead of 10^3 that we used in secondary array thing, so that the chains are smaller reducing time

*/
class Node   {
    public:
    int key;
    int value;
    Node* next;
    Node(int key, int value)    {
        this->key = key, this->value = value, this->next = NULL;
    }
};

class MyHashMap {
    vector<Node*> hashmap;
    int getBucket(int key)  {
        return key % 100000;
    }
    Node* findKeyPrev(Node* prev, int key)   {
        Node* cur = prev->next;
        while(cur != NULL)  {
            if(cur->key == key) return prev;
            prev = prev->next, cur = cur->next;
        }
        return NULL;
    }
public:
    MyHashMap() {
        hashmap = vector<Node*>(100000, new Node(-1,-1));
    }
    
    void put(int key, int value) {
        int bucket = getBucket(key);
        auto prev = findKeyPrev(hashmap[bucket], key);
        if(prev == NULL)    {
            auto newNode = new Node(key, value);
            newNode->next = hashmap[bucket]->next, hashmap[bucket]->next = newNode;
        }        
        else    {
            prev->next->value = value;
        }
    }
    
    int get(int key) {
        int bucket = getBucket(key);
        auto prev = findKeyPrev(hashmap[bucket], key);
        return (prev == NULL) ? -1 : prev->next->value;
    }
    
    void remove(int key) {
        int bucket = getBucket(key);
        auto prev = findKeyPrev(hashmap[bucket], key);
        if(prev)    {
            auto cur = prev->next;
            prev->next = prev->next->next;
            delete(cur);
        }
    }
};