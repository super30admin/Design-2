/* Time Complexity for all operations: O(1)
Space Complexity: O(1)*/

/* Approach: Using Linear chaining. Primarily we took and array. 
For every cell in array according to the requirement we created a linkedList.

Size of array: 10000
Size of Linkedlist: (10^6)/10000 = 100

In array for 1st cell that is 0th index we took linkedList of size (100+1) */


class MyHashMap {

    class Node{
        int key;
        int val;
        Node next;
        public Node(int key, int value){
            this.key=key;
            this.val=value;
        }
    }

    private Node[] storage;

    public MyHashMap() {
       this.storage=new Node[10000] ;
    }

    // Linear chaining we are doing. Hence one hash function
    private int hashIdx(int key)
    {
        return key%10000;
    }

    private Node find(Node head, int key)
    {
        Node prev = null;
        Node curr = head;
        // I will traverse through LL either till I reach end of LL or till I find that particular key
        while(curr!= null && curr.key!=key){
            prev=curr;
            curr=curr.next;
        }
        return prev;
    }
    
    public void put(int key, int value) {
       int hash=hashIdx(key);
       // Checking if at particular array index ,any linkedlist is there or not.
       // If not, then create a dummy node 
       if(storage[hash]==null)
            storage[hash]=new Node(-1,-1);
      
      //If existing, then add a new fresh node to the existing LL
      Node prev=find(storage[hash],key);

    // When we didnot find key or we reached the tail of LL
      if(prev.next == null)
            prev.next=new Node(key, value);
      else
            //key is already there
            prev.next.val=value;
    }
    
    public int get(int key) {
        int hash=hashIdx(key);
        if(storage[hash]==null)
            return -1;

        Node prev=find(storage[hash],key);
        if(prev.next==null)
            return -1;
        else
            return prev.next.val;
    }
    
    public void remove(int key) {
        int hash=hashIdx(key);
        if(storage[hash]==null)
            return ;
        Node prev=find(storage[hash],key);
        if(prev.next == null)
            return;
        prev.next=prev.next.next;

    }
}