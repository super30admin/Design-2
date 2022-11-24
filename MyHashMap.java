// Time Complexity : O(n)
// Space Complexity : O(1)

/* idea is to create a hash table with pointers pointing to linkedlist.
 * each function first gets the hash value and then use the find function
 * to travese through the linked list. 
 */

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
    private int buckets;
    
    public MyHashMap() {
        this.buckets = 10000;
        this.storage = new Node[buckets];
    }
    
    public int hash1(int key){
        return key%buckets;
    }
    
    public Node find(Node head, int key){
        Node curr = head;
        Node prev = null;
        while(curr != null && curr.key != key){
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }
    public void put(int key, int value) {
        int bucket = hash1(key);
        if (storage[bucket] == null){
            storage[bucket] = new Node(-1,-1);
        }
        Node prev = find(storage[bucket], key);
        if (prev.next == null){
            prev.next = new Node(key, value);
        }
        else{
            prev.next.val = value;
        }
    }
    
    public int get(int key) {
        int bucket = hash1(key);
        if(storage[bucket] == null) return -1;
        Node prev = find(storage[bucket], key);
        if(prev.next == null) return -1;
        return prev.next.val;
    }
    
    public void remove(int key) {
        int bucket = hash1(key);
        if(storage[bucket] == null) return;
        Node prev = find(storage[bucket], key);
        if(prev.next == null) return;
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