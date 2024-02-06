/* time complexity :
    PUT - O(1)
    GET - O(1)
    REMOVE - O(1)
    space complexity: O(n + m)
    where n is number of buckets(10000) and m is key value pairs

    Did this code successfully run on Leetcode : yes
    Any problem you faced while coding this : No

    Approach: used linear-chaining technique
    when we do the hashfunction to the value then we will dynamically allocate the value to a address and link the node to the hash table

*/
class Node {
public:
    int key, value;
    Node* next;
    Node()
    {
        key = -1;
        value = 0;
        next = NULL;
    }
};
class MyHashMap {
public:
    int hashval = 0;
    Node arr[10000];
    int hash(int key)
    {
        return key%10000;
    }
    void put(int key, int value) {
        if(arr[hash(key)].key == -1)
        {
            arr[hash(key)].key = key;
            arr[hash(key)].value = value;
        }
        else{
            Node* head = new Node();
            Node* newnode = new Node();
            newnode->key = key;
            newnode->value = value;
            head = &arr[hash(key)];
            while(head->next!=NULL){
                if(head->key == key)
                {
                    head->value = value;
                    return;
                }
                head = head->next;
            }
            if(head->key == key)
            {
                head->value = value;
                return;
            }
            head->next = newnode;
        }
    } 

    int get(int key) {
        hashval = hash(key);
        Node* head = new Node();
        head = &arr[hash(key)];
        while(head->next!=NULL)
        {
            if(head->key == key)
            {
                return head->value;
            }
            head = head->next;
        }
        if(head->key == key)
        {
            return head->value;
        }
        return -1;
    }
    
    void remove(int key) {
        hashval = hash(key);
        Node* head = new Node();
        Node* curr = new Node();
        head = &arr[hash(key)];
        if (head->key == key && head->next != NULL)
        {
            head = head->next;
            arr[hash(key)] = *head;
            return;
        }
        else if(head->next != NULL)
            curr = head->next;
        else if(head->key == key)
        {
            head->key = -1;
            head->value = 0;
            return;
        }        
        while(head->next !=NULL && curr->next!=NULL)
        {
            if(curr->key == key)
            {
                head->next = curr->next;
            }
            head = head->next;
            curr = curr->next;
        }
        if(curr->key == key)
        {
            head->next = curr->next;
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