// Time Complexity : O(1)
// Space Complexity :
// Did this code successfully run on Leetcode : Yes
/* Any problem you faced while coding this : this solution won't give you the Exact functionality of the HashMap and This implementation doesn't handle collisions.
If two different keys hash to the same index in the map array, one will overwrite the other.*/


// Your code here along with comments explaining your approach

class MyHashMap {
    class Node{
        int key; int val;
        Node next;
      public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}    
    public Node[] storage;

    private int hash(int key) {
        return key % 10000;
    }

    public MyHashMap() {
        this.storage = new Node[10000];
    }
    public Node search(Node node, int key) {
        Node prev = null;
        Node curr = head;

        while(curr != null && curr.key != key) {
            prev = curr;
            curr = curr.next;
        }
        return prev;

    }
    
    public void put(int key, int value) {
        int idx = hash(key);
        if(storage[idx] == null) {
            storage[idx] = new Node(-1,-1);
        }
        Node prev = search(storage[idx],key);
        if(prev.next == null){
            prev.next = new Node(key, value);
        } else {
            prev.next.val = value;
        }
    }
    
    public int get(int key) {
        int idx = hash(key);
        if(storage[idx]== null) return -1;
        Node prev = search(storage[idx],key);
        if(prev.next == null) {
            return -1;
        }
        return prev.next.val;
    }
    
    public void remove(int key) {
        int idx = hash(key);
        if(storage[idx]== null) return;
        Node prev = search(storage[idx],key);
        if(prev.next == null) {
            return;
        }
        Node temp = prev.next;
        prev.next = prev.next.next;
        temp.next = null;
        return;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
