// Time Complexity : O(1)  (primary array is O(1) and secondary linked list worst case is O(100) )
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes

/*
Primary array is of size 10^4 which makes the linkedlist 100 thus reducing the traversal time 
*/

class MyHashMap {
public:
    
    class Node {
        public:
            int key, value;
            Node* next;
            Node(int key, int value){
                this->key = key;
                this->value = value;
                this->next = NULL;
            }
    };
    
    int primarySize;
    vector<Node*> primaryArray;
    
    MyHashMap() {
        primarySize = 10000;
        primaryArray = vector<Node*>(primarySize);
    }
    
    //returns the bucket in the primaryArray
    int hashingFunc(int key){
        return key%primarySize;
    }
    
    //returns the precious node for every find 
    Node* find(Node* head, int key){
        Node* previous = head;
        Node* current = head->next;
        
        //iterate as long as the current is not null or you haven't found the key
        //if you found the key, return previous 
        while(current != NULL && current->key != key){
            previous = current;
            current = current->next;
        }
        return previous;
    }


    void put(int key, int value) {
        int bucket = hashingFunc(key);

        //if the primary node is null, create a dummy node 
        //why dummy node? -> if this is the head of the LL, we will have to write separate edge case for the first node 
        //adding dummy node will help consider the first node as any normal node 
        if(primaryArray[bucket] == NULL){
            Node* newNode = new Node(-1,-1);
            primaryArray[bucket] = newNode;
            cout<<"The bucket is null";
        }
        
        //now get the previous node
        Node* previous = find(primaryArray[bucket], key);

        //if current is not NULL update that value 
        if(previous->next != NULL){
            previous->next->value = value;
            return;
        }

        //else add the new node
        previous->next = new Node(key,value);
        
    }
    
    int get(int key) {
        int bucket = hashingFunc(key);

        //if the primary array is NULL, that node is not present 
        if(primaryArray[bucket] == NULL)
            return -1;

        Node* previous = find(primaryArray[bucket], key);

        //if it's found, return the value 
        if(previous->next != NULL)
            return previous->next->value;
        //if we hit the end of the linked list, return -1 cause we didn't find the node
        return -1;
    }
    
    void remove(int key) {
        int bucket = hashingFunc(key);
        if(primaryArray[bucket] == NULL)
            return;
        Node* previous = find(primaryArray[bucket], key);

        //if we find the node, assign previous->next as the current->next thus removing any reference to current 
        if(previous->next != NULL)
            previous->next = previous->next->next;
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