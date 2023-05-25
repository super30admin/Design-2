// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Nope. 

class MyHashMap {
private: 
    struct Node {
        int key; 
        int val; 
        Node* next; 
        Node(int i_key, int i_val) {
            key = i_key;
            val = i_val;
            next = nullptr; 
        }  
    };
    vector<Node*> buffer; 
    int hashFunction(int key) {
        return key % 10000;
    }      
public:
    MyHashMap() {
        buffer.resize(10000, nullptr);     
    }

    Node* find(Node* node, int key) { // Max size of the nested linked list will be 100 => This does not change with input value so we can take this time complexity as O(1).  
        Node* prev = nullptr; 
        Node* current = node; 
        while(current != nullptr && current->key != key) {
            prev = current; 
            current = current->next; 
        }
        return prev;     
    }
    
    void put(int key, int value) {
        int hashedKey = hashFunction(key);
        if(buffer[hashedKey] == nullptr) {
            //Instantiate an empty head
            buffer[hashedKey] = new Node(-1,-1);
        }
        Node* node = find(buffer[hashedKey], key);
        if(node->next == nullptr) {
            node->next = new Node(key, value);
        } else {
            node->next->val = value; 
        }  
    }
    
    int get(int key) {
        int hashedKey = hashFunction(key);
        if(buffer[hashedKey] == nullptr) return -1; 
        Node* node = find(buffer[hashedKey], key);
        if(node->next == nullptr) return -1; 
        return node->next->val;
    }
    
    void remove(int key) {
        int hashedKey = hashFunction(key);
        if(buffer[hashedKey] == nullptr) return; 
        Node* node = find(buffer[hashedKey], key);
        if(node->next == nullptr) return; 
        node->next = node->next->next; 
    }
};

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap* obj = new MyHashMap();
 * obj->put(key,value);
 * int param_2 = obj->get(key);
 * obj->remove(key);
 */