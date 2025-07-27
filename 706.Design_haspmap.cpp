class MyHashMap {

        struct Node{
            int key,value;
             Node* next;
             Node(int key,int value)
             {
                this->key =key ;
                this->value =value;
                next = nullptr; 
             }
        };    

    vector<Node*>storage;
    int buckets;
    int gethash(int key) //linear chaining 
    {
        return key%buckets;
    }
     Node* getprev(Node*head,int key) //helper to get prev node inorder to perform operation in O(1)
     {
        Node* prev =nullptr;
        Node* curr= head;
        while(curr && curr->key!=key)
        {
            prev = curr;
            curr = curr->next;
        }
        return prev;
     }
        
    public:
            MyHashMap() 
            {
              buckets = 1000;
              storage = vector<Node*>(buckets, nullptr);
    }  
    
    void put(int key, int value) {
        int index = gethash(key);
        if(!storage[index])
        {
            storage[index] = new Node(-1,-1);//if it is 1st Node create dummy node
            storage[index]->next =new Node(key,value);
        }
        Node * prev = getprev(storage[index],key);
        if(!prev->next)
        {
           prev->next =new Node(key,value);//check if the key is present if not create node and append 
        }
        else
           prev->next->value = value; // if it is present update the value
    }
    
    int get(int key) {
        int index = gethash(key);
        if(!storage[index]) return -1; // if node is not set then return -1
        Node* prev = getprev(storage[index],key);
        if(!prev->next) return -1; // if prev->next is null then not present ;
        return prev->next->value;
    }
    
    void remove(int key) {
        int index = gethash(key);
        if (!storage[index]) return; //if null then nothing to remove
        Node* prev = getprev(storage[index], key);
        if (!prev->next) return; //if null then nothing to remove
        Node* temp = prev->next; // detele and connect next node to prev node 
        prev->next = temp->next;
        delete temp; 
    }
};

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap* obj = new MyHashMap();
 * obj->put(key,value);
 * int param_2 = obj->get(key);
 * obj->remove(key);
 */