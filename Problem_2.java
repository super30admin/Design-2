// Time Complexity : O(1)
// Space Complexity : depends on the input 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/* We use chaining technique here which uses a combination of bucket array and Linked List. We create a storage array of type Node here of size 10000. 
   Hash function is used to select the bucket and if its null we initialize the head of linked list for that bucket. If its not null we search through the 
   linked list and find the key. Get() function returns the value of that key. Similarly put() and remove() update and delete the key
   respectively.
*/

class MyHashMap {
   Node[] storage;
   int buckets;

   class Node {
       int key;
       int value;
       Node next;
       public Node(int key, int value) {
           this.key = key;
           this.value = value;
       }
   }

   public MyHashMap() {
       buckets = 10000;
       storage = new Node[buckets];
   }

   private int hash(int key) {
       return key % buckets;
   }

   private Node find(Node head, int key) {
       Node curr = head;
       Node prev = null;

       while(curr != null && curr.key != key) {
           prev = curr;
           curr = curr.next;
       }
       return prev;
   }
   
   public void put(int key, int value) {
       int hash = hash(key);
       if(storage[hash] == null) 
           storage[hash] = new Node(-1, -1);
       Node prev = find(storage[hash], key);
       if(prev.next == null)
           prev.next = new Node(key, value);
       else
           prev.next.value = value;
   }
   
   public int get(int key) {
       int hash = hash(key);
       if(storage[hash] == null) 
           return -1;
       Node prev = find(storage[hash], key);
       if(prev.next == null)
           return -1;
       else
           return prev.next.value;
   }
   
   public void remove(int key) {
       int hash = hash(key);
       if(storage[hash] == null) 
           return;
       Node prev = find(storage[hash], key);
       if(prev.next == null)
           return;
       else
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