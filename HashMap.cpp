#include <vector>
using namespace std;

class MyHashMap {
private:
    struct Node {
        int key;
        int value;
        Node* next;
        Node (int k, int val) {
            key = k;
            value = val;
            next = nullptr;
        }
    };

    static const int buckets = 10000;
    vector<Node*> storage;
public:
    MyHashMap() {
        // Initialize a null array 
        storage.resize(buckets);
    }

    Node* getPreviousNode(int key, Node* head) {
        Node* prev = head;
        Node* cur = head ? head->next : nullptr;
        // Search the innerList.
        // If the element is found, return the prevNode
        // Else, we will end up returning the dummy head.
        while (cur != nullptr && cur->key != key) {
            // Update prev and move ahead.
            prev = cur;
            cur = cur->next;
        }

        return prev;
    }

    // HashFunction
    int getBucketIndex(int key) {
        return key % buckets;
    }
    
    void put(int key, int value) {
        // First things first, let us get the bucket
        // we are interested in.
        int idx = getBucketIndex(key);

        // There can be 3 cases
        // 1) Exisiting key, need to update the value.
        // 2) Unique key being added for the first time,
        //    add it to the list.
        // 3) Bucket being used for the first time.

        // Handle case3:
        if (storage[idx] == nullptr) {
            // dummy node.
            storage[idx] = new Node(-1,-1);
            storage[idx]->next = new Node(key,value);
            return;
        }

        Node* prevNode = getPreviousNode(key, storage[idx]);

        // If case 2, then next should be null. Append it to the list
        if (prevNode->next == nullptr) {
            prevNode->next = new Node(key, value);
        } else {
            // Already existing, need to update the value.
            prevNode->next->value = value;
        }

        return;
    }
    
    int get(int key) {
        // First things first, let us get the bucket
        // where the key is.
        int idx = getBucketIndex(key);

        // There can be 3 cases
        // 1) Exisiting key, return the value
        // 2) Key not found, return -1.
        // 3) Bucket not initialized, return -1

        // Handle case3:
        if (storage[idx] == nullptr) {
            return -1;
        }

        Node* prevNode = getPreviousNode(key, storage[idx]);

        // If case 2, then next should be null.
        if (prevNode->next == nullptr) {
            return -1;
        } else {
            // Already existing, need to return the value.
            return prevNode->next->value;
        }
    }
    
    void remove(int key) {
        // First things first, let us get the bucket
        // we want to remove.
        int idx = getBucketIndex(key);

        // There can be 3 cases
        // 1) Exisiting key, need to remove it.
        // 2) Key not found, return.
        // 3) Bucket being used for the first time.

        // Handle case3:
        if (storage[idx] == nullptr) {
            return;
        }

        Node* prevNode = getPreviousNode(key, storage[idx]);

        // If case 2, then next should be null.
        if (prevNode->next == nullptr) {
            return;
        } else {
            // Already existing, remove it by pointing the 
            // prevNode's next pointer to it's next pointer.
            Node* toDelete = prevNode->next;
            prevNode->next = toDelete->next;
            delete toDelete;
        }

        return;
    }
};

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap* obj = new MyHashMap();
 * obj->put(key,value);
 * int param_2 = obj->get(key);
 * obj->remove(key);
 */