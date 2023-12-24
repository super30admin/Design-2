/*
 * Time Complexity : O(1)
 * Space Complexity : O(n)
 * Did this code successfully run on Leetcode : Yes
 * Any problem you faced while coding this : No


 ? Your code here along with comments explaining your approach
   I've designed a custom hash map that stores key-value pairs
   using an array of linked lists, effectively handling collisions
   through separate chaining. In my design, each key-value pair
   is encapsulated in a `Node`, with each node comprising the
   key, its associated value, and a pointer to the next node in
   the list. My hash map supports three primary operations: `put`,
   which inserts or updates a key-value pair; `get`, which retrieves
   the value for a given key, returning -1 if the key isn't present;
   and `remove`, which deletes a key-value pair if it exists. I've
   crafted the hash function to calculate an array index based on
   the key, and I've chosen the size of the underlying array to
   be a prime number, aiming to distribute keys more evenly across
   the array. I've ensured that each key is unique within the hash
   map and addressed potential collisions by maintaining a linked
   list of nodes at each array index. This method typically allows
   for efficient average-case performance in basic hash map operations.
   However, I'm aware that in the worst-case scenario, the performance
   can degrade to linear time, especially if collisions lead to the
   formation of long linked lists at a single array index.
*/

struct Node {
    public:
        int key, val;
        Node* next;
        Node(int _key, int _val, Node* _next) {
            key = _key;
            val = _val;
            next = _next;
        }
};

class MyHashMap {
    const static int size = 19997;
    const static int mult = 12582917;
    Node* data[size] = {};

public:
    MyHashMap() {

    }

    int hash(int key) {
        return (int)((long)key * mult % size);
    }

    void put(int key, int value) {
        remove(key);
        int h = hash(key);
        Node* node = new Node(key, value, data[h]);
        data[h] = node;
    }

    int get(int key) {
        int h = hash(key);
        Node* node = data[h];
        while(node) {
            if(node->key == key) return node->val;
            node = node->next;
        }
        return -1;
    }

    void remove(int key) {
        int h = hash(key);
        Node* node = data[h];
        if(node == nullptr) return;
        if(node->key == key) {
            data[h] = node->next;
            delete node;
        } else {
            while(node->next) {
                if(node->next->key == key) {
                    Node* temp = node->next;
                    node->next = temp->next;
                    delete temp;
                    return;
                }
                node = node->next;
            }
        }
    }
};

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap* obj = new MyHashMap();
 * obj->put(key,value);
 * int param_2 = obj->get(key);
 * obj->remove(key);
 */

