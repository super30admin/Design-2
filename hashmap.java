// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode: Yes
// Any problem you faced while coding this : None
class MyHashMap {

    Node[] storage;
    int buckets;

    class Node {
        int key;
        int value;
        Node next;

        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    public MyHashMap() {
        this.buckets = 1000;
        this.storage = new Node[this.buckets];
    }

    private int getHash(int key){
        return key % buckets;
    }

    private Node getPrev(Node head, int key){
        Node prev = null;
        Node curr = head;
        while(curr != null && curr.key != key){
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }

    public void put(int key, int value) {
        int index = getHash(key);
        if(storage[index] == null){
            storage[index] = new Node(-1, -1);
            storage[index].next = new Node(key, value);
            return;
        }

        Node prev = getPrev(storage[index], key);
        if(prev.next == null){
            prev.next = new Node(key, value);
        }else{
            prev.next.value = value;
        }
    }

    public int get(int key) {
        int index = getHash(key);
        if(storage[index] == null) return -1;
        Node prev = getPrev(storage[index], key);
        if(prev.next == null) return -1;
        return prev.next.value;
    }

    public void remove(int key) {
        int index = getHash(key);
        if(storage[index] == null) return;
        Node prev = getPrev(storage[index], key);
        if(prev.next == null) return;
        Node curr = prev.next;
        prev.next = curr.next;
        curr.next = null;
    }
}