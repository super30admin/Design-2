class MyHashMap {

public:
int buckets;

class Node
{
    int key;
    int value;
    Node *next;
   
    Node(int key, int value)
{
    this->key = key;
    this->value = value;
}
};



    MyHashMap() {
        this->buckets =10000;
         Node data[buckets];
    }
    
    void put(int key) 
    {
        int outerHash = GetOuterHash(key);
        if(data[outerHash] != NULL)
        {
           Node *dummy = NULL;
           dummy->value = -1;
           dummy->next = new Node;
        }
       else
       {
           Node *prev = findPrev(data[outerHash], key);
           prev->next = new Node;
       }
        
    }
    
    int get(int key) {
         int outerHash = GetOuterHash(key);
        if(data[outerHash] == NULL)
        {
        return -1;
        }
       else
       {
           Node *prev = findPrev(data[outerHash], key);
           if(prev->next == NULL)
           {
               return -1;
           } 
           else
           {
               return prev->next->value;
           }
       }
    }
    
    void remove(int key) {
        
    }
    private:

    int GetOuterHash(int key)
    {
        return (key%buckets);
    }

    Node findPrev(Node * head, int key)
    {
        Node *prev = NULL;   
        Node *curr = NULL;    
        prev->next = head;
        while(curr != NULL && curr->value != key)
        {
            prev = curr;
            curr = curr->next;
        }
        return prev;
    }
};

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap* obj = new MyHashMap();
 * obj->put(key,value);
 * int param_2 = obj->get(key);
 * obj->remove(key);
 */