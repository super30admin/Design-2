// Time Complexity :O(1);
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

#include <iostream>
#include <vector>

using namespace std;

class MyHashMap {
    struct Node{
       
       
        
        int key;
        int val;
        Node* next;
         Node(int key,int val){
                this->key=key;
                this->val=val;
                this->next = nullptr;
                

            }
    };
    
public:
    vector<Node*> arr;

   
    

    MyHashMap() {
        arr.resize(10000,nullptr);
         
         
        

        
    }

    int hashIndex(int key){
        return key%10000;
    }

    Node* find(Node* head,int key){
        Node* curr = head;
        Node* prev = nullptr;

        while(curr!=nullptr && curr->key!=key){
            prev=curr;
            curr=curr->next;
            
            
        } 
        return prev;




    }

    
    void put(int key, int value) {
        int x = hashIndex(key);
        if(arr[x]==nullptr){
            arr[x]=new Node(-1,-1);
        }
        Node* prev=find(arr[x],key);
        if(prev->next==nullptr){
            prev->next = new Node(key,value);
        }
        else{
            prev->next->val = value;
        }




        

        
    }
    
    int get(int key) {
        int x = hashIndex(key);
        if(arr[x]==nullptr){
            return -1;
        }
        else{
            Node* prev=find(arr[x],key);
            if(prev->next==nullptr){
                return -1;
            }
            else{
                return prev->next->val;
            }

        }
        
    }
    
    void remove(int key) {
        int x = hashIndex(key);
        if(arr[x]==nullptr){
            return;
        }
        else{
            Node* prev = find(arr[x],key);
            if(prev->next==nullptr){
                return;
            }
            else{
                prev->next = prev->next->next;
                
            }
        }






        
    }
};
