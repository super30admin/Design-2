/* Given
1. Do not use built-in hash table libraries
2. Functions to implement insert/put, retrieve/get and delete/remove
*/

// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class MyHashMap {
    class Node{
        int key;
        int value;
        Node next;
        public Node(int key,int value){
            this.key = key;
            this.value = value;
        }
    }
    //this is the primary array
    private Node[] storage;

    public MyHashMap() {
          this.storage = new Node[10000];
    }

    //hash function
    private int hash(int key){
        return key% 10000;
    }
    /* For put
    Step1: calculate hash function and find hash(key)
    Step2: Locate the hash(key) index in the array and checked the value
           if the value is null --> create a new node and connect the node to hash(key) index
           if the value is not null --> search if a node for that key exists
             if the node exists --> update the value for that node
             if it does not exist --> create a new node, connect it to existing node => existing node. next = new node
             new node.next = null;
     */
    public void put(int key, int value) {
       int index = hash(key);
       if (storage[index] == null){
           storage[index] = new Node(-1,-1); //this is the dummy node to get out LL started, so not to lose the connection between array and LL
        }
        Node prev = searchPrevNode(storage[index], key);
        if(prev.next == null)
        prev.next = new Node(key,value); //fresh node   
        else
        prev.next.value = value;//existing node
    
    }
    
    /** For get
      Step 1: Calculate hash function and find the hash(key)
      Step 2: Find array index using the hash(key)
              if the array at that index is null return -1
              if the array at that index is not null, search the node with that key
               if that key is present --> return value
               if that key is not present --> return -1
      */
    public int get(int key) {
        int index = hash(key);
        if(storage[index] == null) return -1;
        Node prev = searchPrevNode(storage[index], key);
        if(prev.next == null) return -1;
        return prev.next.value;
    }

      /** For remove
      Step 1: Calculate hash function and find the hash(key)
      Step 2: Find array index using the hash(key)
              if the array at that index is null return;
              if the array at that index is not null, search the node with that key
               if that key is present --> delete the node, point prev node to new node or point array to next node
               if that key is not present --> return
      */  
    public void remove(int key) {
        int index = hash(key);
        if(storage[index] == null) return;
        Node prev = searchPrevNode(storage[index], key);
        if(prev.next == null) return;
        Node temp = prev.next;
        prev.next = prev.next.next;
        temp.next = null;
    }


/** searchPrevNode(key) function
Since we're searching in all 3 (put,get,remove) to make the code modular, 
we write out a separate search function if you've to search for any key, 
it will give me one node previous to the current node and then say if you want
to remove the node, it can be done easily by doing prev.next.next
store the current node in a temp node and then doing it temp.node = null,
 If the node we're looking for is not present in the list, we will end up that the tail node
 so if prev node = tail then that key is not present in the list */

    private Node searchPrevNode(Node head, int key){
        Node prev = null;
        Node current = head;
        while(current != null && current.key != key){
            prev = current;
            current = current.next;
        }
        return prev;
    }

    public static void main(String[] args){
         MyHashMap obj = new MyHashMap();
         int key = 103;
         int value = 20005;
        obj.put(key,value);
        int param_2 = obj.get(key);
        obj.remove(key);
    }
}



/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */