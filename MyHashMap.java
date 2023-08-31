public class MyHashMap {    
    class Node {
        int key;
        int value;
        Node next;
        
        public Node(int key, int value){
            this.key = key;
            this.value = value;
            this.next = null;
        } 
    }
    
    int buckets;
    Node[] storage;
    public MyHashMap() {
        buckets = 1000;
        storage = new Node[buckets];
    }
    
    // Time complexity O(1)
    // Space complexity O(1)
    public int getBucket(int key) {
        return Integer.hashCode(key) % buckets;   
    }   
    
    public Node find(Node dummy, int key) {
        Node prev = dummy;
        Node curr = dummy.next;
        
        while(curr != null && curr.key != key){
            prev = curr;
            curr = curr.next;
        }
        
        return prev;
    }
    
    public void put(int key, int value) {
        int bucket = getBucket(key);
        if(storage[bucket] == null){
            storage[bucket] = new Node(-1,-1);
        }
        
        Node dummy = storage[bucket];
        
        Node prev = find(dummy, key);
        
        if(prev.next == null){
            prev.next = new Node(key, value);
        }
        
        prev.next.value = value;
    }
    
    public int get(int key) {
        int bucket = getBucket(key);
        if (storage[bucket] == null){
            return -1;
        }
        Node dummy = storage[bucket];
        Node prev = find(dummy,key);
        
        if(prev.next == null){
            return -1;
        }
        
        return prev.next.value;
    }
    
    public void remove(int key) {
        int bucket = getBucket(key);
        if(storage[bucket] == null){
            return;
        }
        Node dummy = storage[bucket];
        Node prev = find(dummy,key);
        if(prev.next == null){
            return;
        }
        Node curr = prev.next;
        prev.next = curr.next;
        curr.next = null;
    }

    
}
