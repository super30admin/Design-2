// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Didn't use pointer to pointer for array and go error.  


// Your code here along with comments explaining your approach:
// 1. Create class hashmap to store key-value pairs. 
// 2. Hash function : (key%1000) .
// 3. Performed linear chaining to avoid collision on keys.

class MyHashMap {
public:
    class Node{
        public:
        int kk;
        int data;
        Node* next;
        Node(int key,int value){
            this->kk=key;
            this->data=value;
            this->next=NULL;
        }
    };
    int size;
    Node** arr;
    MyHashMap() {
        this->size = 1000;
        arr=new Node*[size];
        for (int i = 0; i < size; i++) {
            arr[i] = NULL;
        }
    }
    
    void put(int key, int value) {
        Node* t=new Node(key,value);
        if(arr[key%size]==NULL){
            arr[key%size]=t;
            //cout<<"11";
        }
        else{
            Node* temp=arr[key%size];
            while(temp != NULL){
                if((temp->kk)==key){
                    (temp->data)=value;return;
                }
                if(temp->next == NULL) break;
                temp=temp->next;
            }
            
            temp->next=t;
        }
    }
    
    int get(int key) {
        if(arr[key%size]==NULL){
            return -1;
        }
        else{
            Node* temp=arr[key%size];
            while(temp != NULL){
                if((temp->kk)==key){
                    return (temp->data);
                }
                temp=temp->next;
            }
            return -1;
        }
    }
    
    void remove(int key) {
        if(arr[key%size]==NULL){
            return;
        }
        else{
            Node* temp=arr[key%size];
            if((temp->kk) == key){
                arr[key%size] = temp->next;return;
            }
            Node* prev=NULL;
            while(temp != NULL){
                if((temp->kk)==key){
                    (prev->next)=(temp->next);
                    return;
                }
                prev=temp;
                temp=temp->next;
            }
            return;
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