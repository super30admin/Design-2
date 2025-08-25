

// Here we are using an array where each index stores a reference to a linked list.  
// A hash function is used to determine the index in the array.  
// If no linked list is found at that index, a dummy node (-1, -1) is created.  
// Subsequent key-value pairs are stored as new nodes in the linked list.  
// For each key, only one node exists in the list (no duplicates).  
// This way, collisions are handled using separate chaining with linked lists.
class MyHashMap {
    int bucket;
    Node[] storage;

    class Node{
        int key;
        int value;
        Node next;

        public Node(int key, int value)
        {
            this.key= key;
            this.value= value;
        }
    }

    public MyHashMap() {
        this.bucket= 10000;
        this.storage= new Node[bucket];
        
    }

    public int hash1(int key){
        return key%bucket;
    }

    public Node helper(Node head, int key){
        Node prev= null;
        Node curr= head;
        while(curr!=null && curr.key!= key){
            prev=curr;
            curr=curr.next;
        }
        return prev;
    }
    
    public void put(int key, int value) {
        int primaryIndex= hash1(key);
        if(storage[primaryIndex]== null){
            storage[primaryIndex]= new Node(-1,-1);
            storage[primaryIndex].next= new Node(key,value);

        }

        Node prev= helper(storage[primaryIndex],key);
        if(prev.next== null){
            prev.next= new Node(key,value);
        }
        else
        {
            prev.next.value=value;
        }
        
    }
    
    public int get(int key) {
        int index= hash1(key);
        if(storage[index]==null){
            return -1;
        }
        Node prev= helper(storage[index],key);
        if(prev.next==null){
            return -1;
        }
        else{
            return prev.next.value;
        }
        
        
    }
    
    public void remove(int key) {
        int index= hash1(key);
        if(storage[index]== null){
            return;
        }
        Node prev= helper(storage[index], key);
        if(prev.next==null){
            return;
        }
        else
        {
            Node curr= prev.next;
            curr.next= null;
            prev.next.next= prev.next;
        }

        
        
    }
}