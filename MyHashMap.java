// TC - O(1)
// SC - O(n)
class MyHashMap {

    class Node {
        int key;
        int val;
        Node next;
        Node(int key, int val) {
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

    public int hashIdx(int key) {
        return key%buckets;
    }

    public Node find(Node head, int key) {
        Node prev = null;
        Node curr = head;
        while(curr != null && curr.key != key) {
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }
    
    public void put(int key, int value) {
        int bucket = hashIdx(key);
        if(storage[bucket] == null) {
            storage[bucket] = new Node(-1, -1);
        }
        Node prev = find(storage[bucket], key);
        if(prev.next == null) {
            prev.next = new Node(key, value);
        } else {
            prev.next.val = value;
        }
    }
    
    public int get(int key) {
        int bucket = hashIdx(key);
        if(storage[bucket] == null) {
            return -1;
        }
        Node prev = find(storage[bucket], key);
        if(prev.next == null) return -1;
        return prev.next.val;
    }
    
    public void remove(int key) {
        int bucket = hashIdx(key);
        if(storage[bucket] == null) {
            return;
        }
        Node prev = find(storage[bucket], key);
        if(prev.next == null) return;
        prev.next = prev.next.next;
    }
}