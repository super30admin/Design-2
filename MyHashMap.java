/*
Time Complexity
put() O(1)
get() O(1)
remove() O(1)
find()/search()  will have average of O(1) and in worst case it will be O(100);

Space Complexity
Space O(1)
*/

//Implementing a hashmap with linear chaining, taking the array length zero to 1 million.
//depending on load factor, will take primary refernce array of size 10,000 so the search will have less number of nodes to find keys will be maximum of 100 and best possible scenario would be 1;


class MyHashMap {

    class Node{
      int key;
      int val;
      Node next;

      public Node(int key, int val){
        this.key = key;
        this.val = val;
      }
    }

    private Node[] storage;

    public MyHashMap() {

        this.storage = new Node[10000]; // reference array size
        
    }

    private int hash(int key){
       return key % 10000;
    }

    private Node find(Node head, int key){
      Node prev = null;
      Node curr = head;

      while(curr != null && curr.key != key){
        prev = curr;
        curr = curr.next;
      }

      return prev;
    }
    
    public void put(int key, int value) {
      int index = hash(key);
      if(storage[index] == null){
        storage[index] = new Node(-1, -1);
      }

      Node prev = find(storage[index], key);

      if(prev.next != null){
        prev.next.val = value;

      }else{
        prev.next = new Node(key, value);
      }
        
        
    }
    
    public int get(int key) {
      int index = hash(key);
      if(storage[index] == null) return -1;
      Node prev = find(storage[index], key);
      if(prev.next != null){
        return prev.next.val;
      }
       return -1; 
    }
    
    public void remove(int key) {
      int index = hash(key);
      if(storage[index] == null) return;
      Node prev = find(storage[index], key);
      if(prev.next == null){
        return;
      }
      Node curr = prev.next;
      prev.next = prev.next.next;
      curr.next = null;
        
    }
};

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap* obj = new MyHashMap();
 * obj->put(key,value);
 * int param_2 = obj->get(key);
 * obj->remove(key);
 */