/** Time Complexity: O(1) for put, get, and remove operations
 * Space Complexity: O(n) for storing elements in the hash map
 * Did this code successfully run on Leetcode: Yes
 *  Any problem you faced while coding this: No
 * Approach:
 * We use an array of linked lists to handle collisions in the hash map.
 * Each bucket in the array can store multiple key-value pairs using a linked list.
 * The primary hash key is calculated using the modulo operator.
 * We also maintain a dummy head node for each bucket to simplify the insertion and deletion process. Redundancy is removed by fetching the previous node for all operations.
 */

class MyHashMap {
    int primarybucketsize;
    Node[] storage;

    class Node{
        int key;
        int value;
        Node next;

        public Node(int key, int value){
            this.key=key;
            this.value=value;
            this.next=null;
        }
    }

    public MyHashMap(){
            this.primarybucketsize=1000;
            storage=new Node[primarybucketsize];
        }

    public int getPrimaryHashKey(int key){
        return key % primarybucketsize;  
    }

    public Node getPrevNode(Node head, int key){
        Node prev = null;
        Node curr = head;
        while(curr != null && curr.key != key)
        {
            prev=curr;
            curr=curr.next;
        }
        return prev;
    }
    
    public void put(int key, int value) {
        int index=getPrimaryHashKey(key);
        if(storage[index]==null)
        {
            storage[index]=new Node(-1,-1);
            Node headnode=storage[index];
            headnode.next=new Node(key,value);
            return;
        }
        Node prevnode=getPrevNode(storage[index],key);
        if(prevnode.next == null){ 
           prevnode.next = new Node(key, value);
        }else{ 
            prevnode.next.value = value;
        }
    }
    
    public int get(int key) {
        int index=getPrimaryHashKey(key);
        if(storage[index]==null)
        {
            return -1;
        }
        else
        {
            Node prevnode=getPrevNode(storage[index],key);
            if(prevnode.next==null)
            {
                return -1;
            }
            else
            {
                return prevnode.next.value; 
            }
        }
    }
    
    public void remove(int key) {
        int index=getPrimaryHashKey(key);
        if(storage[index]==null)
        {
            return;
        }
        else
        {
            Node prevnode=getPrevNode(storage[index],key);
            if(prevnode.next==null)
            {
                return;
            }
            else
            {
               Node curr = prevnode.next;
               prevnode.next = curr.next;
               curr.next = null;
            }
        }
    }
        
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */