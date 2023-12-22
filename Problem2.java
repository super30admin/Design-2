// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach
class MyHashMap {
    class Node  //using linear chaining (linked list)
    {
        int key;
        int val;
        Node next;
        public Node(int key, int value)
        {
            this.key=key;
            this.val=value;
        }
    }
    Node [] storage;
    public MyHashMap() {
        this.storage = new Node[10000];   //making a array...
    }

    int hash(int key)
    {
        return (key%storage.length);
    }
    private Node find(Node node, int key)
    {
      Node prev = null;
      Node curr = node;
      while(curr != null && curr.key != key)
      {
          prev = curr;
          curr = curr.next; 
      }
      return prev;
    }
    public void put(int key, int value) {
        int index = hash(key);
        if(storage[index] == null)  //if the storage is null 
        {
            storage[index] = new Node(-1,-1);  //create a dummy node
        }
        Node prev = find(storage[index],key);  //find the prev.next
        if(prev.next == null)
        {
            prev.next = new Node(key,value);
        }else 
           prev.next.val = value;
    }
    
    public int get(int key) {
       int index = hash(key);
       if(storage[index] == null) return -1;
        Node prev = find(storage[index],key);
         if(prev.next == null) return -1;
         return prev.next.val;

    }
    
    public void remove(int key) {
        int index = hash(key);
        if(storage[index] == null) return;
        Node prev = find(storage[index],key);
       if(prev.next == null) return;
       Node temp = prev.next;
       prev.next = prev.next.next;   //change the prev next
       temp.next = null;

    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */