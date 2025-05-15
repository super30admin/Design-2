//Time complexity : put(x) : O(1) , remove() : O(1)

#include<bits/stdc++.h>
using namespace std;
class MyHashMap {
private:
    static const int size = 10000;

    struct node {
        int key, value;
        node* nxt;
        node(int k, int v) : key(k), value(v), nxt(nullptr) {}
    };

    vector<node*> store;

    int hash(int key) {
        return key % size;
    }

    node* helper(node* head, int key) {
        node* prev = head;
        node* curr = head->nxt;
        while (curr != nullptr && curr->key != key) {
            prev = curr;
            curr = curr->nxt;
        }
        return prev;
    }

public:
    MyHashMap() {
        store.resize(size, nullptr);
    }

    void put(int key, int value) {
        int idx = hash(key);
        if (store[idx] == nullptr) {
            store[idx] = new node(-1, -1); 
        }
        node* prev = helper(store[idx], key);
        if (prev->nxt == nullptr) {
            prev->nxt = new node(key, value);
        } else {
            prev->nxt->value = value;
        }
    }

    int get(int key) {
        int idx = hash(key);
        if (store[idx] == nullptr) return -1;
        node* prev = helper(store[idx], key);
        if (prev->nxt == nullptr) return -1;
        return prev->nxt->value;
    }

    void remove(int key) {
        int idx = hash(key);
        if (store[idx] == nullptr) return;
        node* prev = helper(store[idx], key);
        if (prev->nxt == nullptr) return;
        node* temp = prev->nxt;
        prev->nxt = prev->nxt->nxt;
        delete temp;
    }
};

