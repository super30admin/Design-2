// Design HashMap
// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Node {
public:
    int key, val;
    Node *next;

    Node(int key, int val) {
        this->key = key;
        this->val = val;
        this->next = nullptr;
    }
};

class MyHashMap {
public:
    vector<Node*> nodes;
    MyHashMap() {
        nodes.resize(10000);
    }

    int hash1(int key) {
        return key % 10000;
    }

    Node* find(Node *head, int key) {
        Node *prev = nullptr;
        Node *curr = head;
        while(curr != nullptr && curr->key != key) {
            prev = curr;
            curr = curr->next;
        }
        return prev;
    }

    void put(int key, int value) {
        int idx = hash1(key);
        if(nodes[idx] == nullptr) {
            nodes[idx] = new Node(-1, -1);
        }
        Node *prev = find(nodes[idx], key);
        if(prev->next == nullptr) {
            prev->next = new Node(key, value);
        }
        else {
            prev->next->val = value;
        }
    }

    int get(int key) {
        int idx = hash1(key);
        if(nodes[idx] == nullptr) return -1;
        Node *prev = find(nodes[idx], key);
        if(prev->next == nullptr) return -1;
        return prev->next->val;
    }

    void remove(int key) {
        int idx = hash1(key);
        if(nodes[idx] == nullptr) return;
        Node *prev = find(nodes[idx], key);
        if(prev->next == nullptr) return;
        Node *toDel = prev->next;
        prev->next = prev->next->next;
        delete toDel;
    }
};