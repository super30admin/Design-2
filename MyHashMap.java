// Implementing a hashmap using Node class that contains key and value. We are using linear chaining here to avoid collisions. We we are doing is creating a datastructure within a datastructure, i.e. a node array. The primary array will contain 10,000 buckets and each bucket will contain 1000,000/10,000 which is 100 bucket items. We chose to have 100 bucket items so that when we try to search for elements in the linked list, we search a linked list size of just 100 elements. This is important for linear chaining as we want to keep the time complexity lower. The worst case is O(n) time complexity to search an element but is O(1) in the avg case. Space complexity is O(number of elements). We can also implement this using double hashing instead of linear chaining. There we will take number of buckets as 1000 and number of bucket items as 1000 and use two hash functions

class MyHashMap {
    
    class Node {
        int key;
        int val;
        Node next;
        
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    
    Node[] storage;
    
    public MyHashMap() {
        storage = new Node[10000];
    }
    
    private int hash(int key) {
        return key % 10000;
    }
    
    // O(1) Avg case. O(n) worst case
    private Node find(int key, Node start) {
        Node prev = null;
        Node curr = start;
        while (curr != null && curr.key != key) {
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }
    
    // O(1) Avg case. O(n) worst case
    public void put(int key, int value) {
        int hash = hash(key);
        if (storage[hash] == null) {
            storage[hash] = new Node(-1, -1); // We are just storing a dummy node as this will help us while removing the first element. As find function will return prev as null. So while removing when we go prev.next.next, we will get a null pointer exception. So this dummy node is just to help us.
        }
        Node prev = find(key, storage[hash]);
        if (prev.next == null) {
            prev.next = new Node(key, value);
        }
        else {
            prev.next.val = value;
        }
    }
    
    // O(1) Avg case. O(n) worst case
    public int get(int key) {
        int hash = hash(key);
        if (storage[hash] == null) {
            return -1;
        }
        Node prev = find(key, storage[hash]);
        if (prev.next == null) {
            return -1;
        }
        return prev.next.val;
    }
    
    // O(1) Avg case. O(n) worst case
    public void remove(int key) {
        int hash = hash(key);
        if (storage[hash] == null) {
            return;
        }
        Node prev = find(key, storage[hash]);
        if (prev.next == null) {
            return;
        }
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