/*
// Time Complexity : 
On average its O(1) for get, put and remove
// Space Complexity :
O(1) since no additional memory is created equivalent to data for computation 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
OOPs concept of C++ using vectors

Expalnation:

Creating a primary array of node pointers of capacity of a factor 100:1 to secondary array
and then storing the values by finding a key using hash functoin
in a linear chained linked list. Created an empty node for each linked list so that head pointer remains consistent 
while removing any node.

// Your code here along with comments explaining your approach
*/



#include<iostream>
#include<vector>

using namespace std;


class Node{
    
public:

    int key;
    int value;
    Node* next;

    Node(int key,int value)
    {
        this->key = key;
        this->value = value;
        this->next = NULL;
    }
};

class MyHashMap{

    const int prim_arr_size{10000};
    vector<Node*>  prim_arr;
    int prim_arr_id(int key){
        return key%prim_arr_size;
    }
    public:
        MyHashMap(){
            this->prim_arr.resize(prim_arr_size,NULL);
        }
        Node* search(Node* curr,int key){
            
            Node* prev = NULL;
            while(curr!=NULL && curr->key!=key ){
                prev = curr;
                curr = curr->next;
            }
            return prev;
            
        }
        void put(int key, int value) {
            int hash_id = prim_arr_id(key);
            if(prim_arr.at(hash_id)==NULL){
                Node* dummy = new Node(-1,1);
                prim_arr.at(hash_id) = dummy;
            }
            
            Node* curr = prim_arr.at(hash_id);
            Node* prev = search(curr,key);
            if(prev->next == NULL){
                Node* node = new Node(key,value);
                prev->next = node;
            }
            else{
                prev->next->value = value;
            }
        }
        
        int get(int key) {
            Node* curr = prim_arr.at(prim_arr_id(key));
            if(curr == NULL)
                return -1;
            Node* prev = search(curr,key);
            if(prev->next == NULL){
                return -1;
            }
            return prev->next->value;

        }
        
        void remove(int key) {
            Node *curr = prim_arr.at(prim_arr_id(key));
            if(curr == NULL)
                return;
            Node *prev = search(curr,key);
            if(prev->next == NULL)
                return;
            Node* temp = prev->next;
            prev->next = temp->next;
            delete(temp);
        }
};

int main(int argc, char const *argv[])
{
    MyHashMap* hashMap = new MyHashMap();



    hashMap->put(1, 2);          



    hashMap->put(2, 3);         



    cout<<hashMap->get(1)<<endl;            // returns 2



    cout<<hashMap->get(3)<<endl;            // returns -1 (not found)



    hashMap->put(2, 4);          // update the existing value



    cout<<hashMap->get(2)<<endl;            // returns 4 



    hashMap->remove(2);          // remove the mapping for 2



    cout<<hashMap->get(2)<<endl;            // returns -1 (not found)


    return 0;
}
