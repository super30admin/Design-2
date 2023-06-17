// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

#include <iostream>
#include <vector>
  
using namespace std;

class MyHashMap {
    struct Node{
        int data[2];
        Node *next;

        Node(int key, int val){
            data[0] = key;
            data[1] = val;
            next = nullptr;
        }
    };

    int size = 10000;
    vector<Node*> hashMap;


public:
    MyHashMap() {
        hashMap = vector<Node*>(size, nullptr);
    }

    void put(int key, int value) {
        int hashKey = key % size;
        Node* curr = hashMap[hashKey];
        if (curr == nullptr) {
            hashMap[hashKey] = new Node(key, value);
            return;
        }

        while (curr != nullptr) {
            if (curr->data[0] == key) {
                curr->data[1] = value; // Update the value if key already exists
                return;
            }

            if (curr->next == nullptr) {
                curr->next = new Node(key, value); // append if key dosent exists
                return;
            }

            curr = curr->next;
        }
    }
    
    int get(int key) {
        int hashKey = key % size;
        Node* curr = hashMap[hashKey];
        while (curr != nullptr) {
            if (curr->data[0] == key) {
                return curr->data[1];
            }
            curr = curr->next;
        }
        return -1;

    }
    
    void remove(int key) {
        int hashKey = key % size;
        Node* curr = hashMap[hashKey];
        Node* prev = nullptr;
        while (curr != nullptr) {
            if (curr->data[0] == key) {
                if (prev == nullptr) {
                    hashMap[hashKey] = curr->next;
                } else {
                    prev->next = curr->next;
                }
                delete curr;
                return;
            }
            prev = curr;
            curr = curr->next;
        }
    }
};