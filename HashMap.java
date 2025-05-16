// Time Complexity :
// put() - O(1), get() - O(1), remove() - O(1) amortized
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// The size of array is taken 10000 since it can be uniformly distributed and max of 100 can be stored at each index
// This MyHashMap implementation uses separate chaining with linked lists to handle hash collisions,
// storing key-value pairs in an array of buckets. Each bucket contains a dummy head node to simplify insertion,
// retrieval, and deletion in constant average time

class MyHashMap {
    class Node {
        int key;
        int value;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node[] storage;
    private int buckets;
    private int hash(int key){
        return key%buckets;
    }

    public MyHashMap() {
        this.buckets = 10000;
        this.storage = new Node[buckets];

    }

    private Node helper(Node head, int key){
        Node prev = head;
        Node curr = head.next;
        while (curr != null && curr.key != key){
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }
    public void put(int key, int value) {
        int idx = hash(key);
        if(storage[idx] == null)
            storage[idx] = new Node(-1, -1);

        Node prev = helper(storage[idx], key);
        if(prev.next == null){
            prev.next = new Node(key, value);
        } else{
            prev.next.value = value;
        }
    }

    public int get(int key) {
        int idx = hash(key);
        if(storage[idx] == null)
            return -1;
        Node prev = helper(storage[idx], key);
        if (prev.next == null){
            return -1;
        }
        return prev.next.value;
    }

    public void remove(int key) {
        int idx = hash(key);
        if(storage[idx] == null)
            return;
        Node prev = helper(storage[idx], key);
        if(prev.next  == null)
            return;
        Node temp = prev.next;
        prev.next = prev.next.next;
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