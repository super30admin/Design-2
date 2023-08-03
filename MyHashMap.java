// Time Complexity : O(1) amortized
// Space Complexity : O(1) amortized
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class MyHashMap {
    class Node{
        int key;
        int value;
        Node next;
    
      Node(int key, int value)
      {
          this.key = key;
          this.value = value;
          
      }
    }
    Node storage[];
    int buckets;
    int items;
   
    public MyHashMap() {
        buckets=10000;
        storage = new Node[buckets];
        

    }
    private int hashMethod(int key)
    {
        return key % buckets;
    }
    private Node find(Node storage,int key){
        Node prev= null, curr = storage;
        while(curr!=null && curr.key !=key)
        {
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }
    public void put(int key, int value) {
        int bucket= hashMethod(key);
         if(storage[bucket]== null)
        {
            storage[bucket] = new Node(-1,-1);
         }
        Node prev = find(storage[bucket],key);
        if(prev.next==null)
        {
            prev.next= new Node(key,value);
        }
        else{
            prev.next.value=value;
        }
    }
    
    public int get(int key) {
        int bucket= hashMethod(key);
         if(storage[bucket]==null) return -1;
         Node newNode = find(storage[bucket],key);
         if (newNode.next==null) return -1;
         return newNode.next.value;


    }
    
    public void remove(int key) {
        int bucket= hashMethod(key);
         if(storage[bucket]==null) return;
         Node newNode = find(storage[bucket],key);
         if (newNode.next == null) return;
        newNode.next=newNode.next.next;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */