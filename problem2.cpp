// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//Design Hashmap (https://leetcode.com/problems/design-hashmap/)

// Your code here along with comments explaining your approach

#include <iostream>
using namespace std;

class MyHashMap {
private:
    const int SIZE = 10007; 

    struct Node {
        int key, value;
        Node* next;
        Node(int k, int v) : key(k), value(v), next(nullptr) {}
    };

    Node* buckets[SIZE];

    int hash(int key) {
        return key % SIZE;
    }

public:
    MyHashMap() {
        for (int i = 0; i < SIZE; ++i)
            buckets[i] = nullptr;
    }

    void put(int key, int value) {
        int idx = hash(key);
        Node* head = buckets[idx];

        Node* curr = head;
        while (curr) {
            if (curr->key == key) {
                curr->value = value; 
                return;
            }
            curr = curr->next;
        }

        // Insert new node at the front
        Node* newNode = new Node(key, value);
        newNode->next = head;
        buckets[idx] = newNode;
    }

    int get(int key) {
        int idx = hash(key);
        Node* curr = buckets[idx];
        while (curr) {
            if (curr->key == key)
                return curr->value;
            curr = curr->next;
        }
        return -1; // Not found
    }

    void remove(int key) {
        int idx = hash(key);
        Node* curr = buckets[idx];
        Node* prev = nullptr;

        while (curr) {
            if (curr->key == key) {
                if (prev)
                    prev->next = curr->next;
                else
                    buckets[idx] = curr->next;
                delete curr;
                return;
            }
            prev = curr;
            curr = curr->next;
        }
    }

    ~MyHashMap() {
        for (int i = 0; i < SIZE; ++i) {
            Node* curr = buckets[i];
            while (curr) {
                Node* next = curr->next;
                delete curr;
                curr = next;
            }
        }
    }
};
