/*
TC- O(1) for all operation
SC- The space complexity for the entire MyHashMap is O(n) n is the number of key-value pairs in the hash map,
    because we store each key-value pair in a linked list. The array storage holds the buckets (each of which is a linked list),
    and each linked list node takes up O(1) space. Therefore, the total space complexity is proportional to the number of elements in the hash map.
Did this code successfully run on Leetcode :  Yes
Any problem you faced while coding this :  No
*/
class MyHashMap {
    class Node{
        int key, val;
        Node next;
        public Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }
    Node [] storage;
    int buckets;

    private int hash(int key){
        return key%buckets;
    }

    public MyHashMap() {
        this.buckets = 1000;
        this.storage = new Node[buckets];
    }

    //Helper to traverse the linked list, given key
    private Node helper(Node head, int key) {
        Node prev = head;
        Node current = head.next;
        //Either we reach to end or we find key
        while(current != null && current.key != key){
            prev = current;
            current = current.next;
        }
        return prev;

    }


    public void put(int key, int value) {
        int idx = hash(key);
        if(storage[idx]==null){ //if at the gien key no linked list found, create one and put key value in it
            storage[idx] = new Node(-1,-1);
        }
        Node prev = helper(storage[idx], key);
        if(prev.next == null) { // we are at tail
            //fresh node
            prev.next = new Node(key,value);
        } else {
            //non fresh mail
            prev.next.val = value;
        }

    }

    public int get(int key) {
        int idx = hash(key);
        if(storage[idx]==null){
            return -1;
        }
        Node prev = helper(storage[idx], key);
        if(prev.next == null) { // no element found
            return -1;
        }
        return prev.next.val;
    }


    public void remove(int key) {
        int idx = hash(key);
        if(storage[idx]==null) return;
        Node prev = helper(storage[idx], key);
        if(prev.next == null) return;
        Node tmp = prev.next;
        prev.next = prev.next.next;
        tmp.next = null;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */