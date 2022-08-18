/*
* Approach - define an array of size 10000, and create a dummy node if we find any put operations. 
* for every put operation, it will add a node and hence expand the linklist as needed.
*created a method to reach to the node, whenever get, put, remove is invoked. 
*
*Time Complexity - avg case for get, put, remove - O(1) -> becuase we just have 100 nested nodes for every nested LinkedList, so traversing through 100 nodes can be considered as constant. 
*Worst case- O(1) - same because of 100 nodes can be cosidered constant. 

Space complexity - O(10000*100) -- which is again can be considered O(m*n), where m =  array and n for linkedlist
*/

class MyHashMap {

    class Node{
        int key;
        int val;
        Node next; //By default the next will always be intialized to null.
        
        Node(int key, int val)
        {
            this.key = key;
            this.val = val;
        }
    }
    
    Node[] primaryStorage;
    
    public MyHashMap() 
    {
        this.primaryStorage = new Node[10000];     
    }
    
    private int hash1(int key)
    {
        return key % 10000;
    }
    
    private Node findPrev(int key, Node node)
    {
        Node prev = null;
        Node curr = node;
        
            while(curr != null && curr.key != key)
            {
                prev= curr;
                curr = curr.next;
            }
        return prev;
    }
    
    
    public void put(int key, int val)
    {
        int hash = hash1(key);
        
        //index is null check
        if(primaryStorage[hash] == null)
        {
            //add dummy node
             primaryStorage[hash] = new Node(-1, -1);
        }
        
        Node prev = findPrev(key, primaryStorage[hash]);
            
        //if prev is the last node!
            if(prev.next == null)
            {
                //key doesnot exist
                prev.next = new Node(key, val);
            }
            
            else //prev.next is the node with the same key
            {
                prev.next.val = val;    
            }
    }
    
    public int get(int key) {
        int hash = hash1(key);
        
        if(primaryStorage[hash] == null)
            return -1;
        
        Node prev = findPrev(key, primaryStorage[hash]);
        
        if(prev.next == null) return -1;
        
        return prev.next.val;
        
        
    }
    
    public void remove(int key) 
    {
         int hash = hash1(key);
        if(primaryStorage[hash] == null)
            return;
        
        Node prev = findPrev(key, primaryStorage[hash]);
        
        if(prev.next == null)
            return;
        
        prev.next = prev.next.next;
        
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */