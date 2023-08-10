// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Here, the elements are stored by computing each of it's hash value and the collisions between them are revolved using Chaining. The primary
// array index ranges from 0 - 10000 and the secondary data structure used is the linked list whose address is stored in the primary array. A 
// null node is appended at the beginning of the list to make it easy for head node deletion

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

    Node[] storage;
    int buckets;

    public MyHashMap() {
        this.buckets = 10000;
        this.storage = new Node[buckets];
    }

    private int hash(int key){
        return key%buckets;
    }

    private Node find(Node head, int key){
        Node prev = null;
        Node curr = head;

        while(curr!=null && curr.key!= key){
            prev = curr;
            curr = curr.next;
        }

        return prev;
    }
    
    public void put(int key, int value) {
        int bucket = hash(key);

        if(storage[bucket]==null){
            storage[bucket] = new Node(-1, -1);
        }

        Node prev = find(storage[bucket], key);

        // case 1: the node is not present
        if(prev.next==null){
            prev.next = new Node(key, value);
        } else {
            prev.next.val = value;
        }
    }
    
    public int get(int key) {
        int bucket = hash(key);
        if(storage[bucket]==null) return -1;
        Node prev = find(storage[bucket], key);

        if(prev.next==null) return -1;

        return prev.next.val;
    }
    
    public void remove(int key) {
        int bucket = hash(key);

        if(storage[bucket]==null) return;

        Node prev = find(storage[bucket], key);

        if(prev.next==null) return;

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