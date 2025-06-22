// Time Complexity :O(l), l - length of linked list in each bucket
// Space Complexity :O(n) -  for storing key, val pair
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this :building singly linked list 


// Your code here along with comments explaining your approach
//using an array of linked lists called buckets
//each bucket is with a dummy head node to simplify insert and delete
//each node stores a key value pair and a pointer to the next node 


 #include<iostream>
 #include <vector>
 #include <climits>
 using namespace std;

 class MyHashMap {
    private:
        struct Node{ // creating a Node 
            int key, value; // has key, value
            Node* next; // pointer to next node
            Node(int k, int v){ // making nodenext to nullptr
                key = k;
                value = v;
                next = nullptr;
            }
        };
        vector<Node*> storage; // defining storage(buckets) with entries as list of nodes
        int buckets; // no of buckets 

        int getBucket(int key){ // hashing function, given a key we get to which bucket it will go
            return key % buckets;
        }

        Node* find(Node* head, int key){ // returns the prev node to which the key present 
            //like if key is present at 10 th node it will return 9 th node
            //if key is not present then i twill return last nod efor which last->next will be nullptr

            Node* prev = head;
            Node* curr = head->next;
            while(curr != nullptr && curr->key != key){ 
                //till the last node is reached and till the key is found run the while loop
                prev = curr;
                curr = curr->next;
            }
            return prev; //if key is not found we return last node 
            //if key is found we return its previous node
        }

    public:
        MyHashMap() {
            buckets = 1007; //to reduce falling in same bucket
            storage.resize(buckets, nullptr);
            
        }
        
        void put(int key, int value) {
            int bucket = getBucket(key); //finding to which bucke tit will go
            if(storage[bucket] == nullptr){ //if bucket is nullptr 
                storage[bucket] = new Node(INT_MIN, INT_MIN); //then initialize to a dummy node
            }
            Node* prev = find(storage[bucket], key); // store the prev node to the node in which key is present in prev
            if(prev->next == nullptr){ // if key is not found then prev will bwe the last node 
                prev->next == new Node(key, value);// create a new node and assign it to prev->next              
            }
            else{// if node with key is present then
                prev->next->value = value;// just update the value
            }
            
        }
        
        int get(int key) {
            int bucket = getBucket(key); //checking which bucket to go
            if(storage[bucket] == nullptr){ // if nothing in the bucket then return -1
                return -1;
            }
            Node * prev = find(storage[bucket], key); //getting prev node to which the node in which key is present
            if(prev->next == nullptr){ //if prev node is last 
                return -1;// node with key is not there
            }
            return prev->next->value;   //node with key is there return its value   
        }
        
        void remove(int key) {
            int bucket = getBucket(key);
            if(storage[bucket] == nullptr){
                return; //if nothing is there in bucket then simply return
            }
            Node * prev = find(storage[bucket], key);
            if(prev->next == nullptr){
                return;
            } 
            else{
                Node* toDelete = prev->next;
                prev->next = prev->next->next;
                delete toDelete;
            }
            
        }
    };
    
    
    int main(){
        MyHashMap* obj = new MyHashMap();
     obj->put(10,1001);
     obj->put(20,2001);
     int param_2 = obj->get(10);
     obj->remove(20);
    
    }
     