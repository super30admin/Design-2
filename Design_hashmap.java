// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// Approach : We will have a primary array and of 10000 because we don't have to have large nested arrays of linked lists that increases the time.
//We make a hash function to equally distribute the indexes. Then we create a common find function that traverses through the array of linked list and finds the key.
//In the put function we check if a linked list is there if not we create a dummy node. Then we find the key and add the given node to its next if the current node is not present. If it is we just update the value.
//For get we use the same checks again and return -1 if the element is not present or there is no LL. if is there we just return its value.
//for remove if the element is not present or there is no LL we just return otherwise we make the next of the prev element to point to the next of its next.
class MyHashMap {

    private Node[] storage;
    private int bucket;
    
    class Node{

        int key; int val;
        Node next;

        private Node(int key, int val){
            this.key= key;
            this.val =val;
        }
    }

    public MyHashMap() {
        this.bucket = 10000;
        this.storage = new Node[bucket];
    }

    private int hashIdx(int key){
        return key%bucket;
    }
    
    private Node find(int key, Node head){
        Node curr = head;
        Node prev = null;
        while (curr!= null && curr.key != key) {
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }

    public void put(int key, int value) {
        int buckets = hashIdx(key);
        if(storage[buckets] == null){
            storage[buckets] = new Node(-1)(-1);
         }
        Node prev = find(key, storage[buckets]);
        if(prev.next == null){
            prev.next = new Node(key, value);
        }
        else{
            prev.next.val = value;
        }
    }
    public int get(int key) {
        int buckets = hashIdx(key);
        if(storage[buckets] == null)return -1;
        Node prev = find(key, storage[buckets]);
        if(prev.next == null){
            return -1;
        }
        else{
            return prev.next.val;
        }
    }
    
    public void remove(int key) {
        int buckets = hashIdx(key);
        if(storage[buckets] == null)return ;
        Node prev = find(key, storage[buckets]);
        if(prev.next == null)return;
        prev.next = prev.next.next;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */public class Design_hashmap {
    
 }
 