//Time Complexity - O(L) where L is the length of the chain
//Space Complexity - O(n + l) Node Array is of size 10000 and each node will have chain.

// Implemented HashMap using the seperate chain.
// Each time a dummy node is created at index and new key value pairs are stored to the dummy node
public class HashMap {
    class Node {
        int key, value;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    public Node find(Node dummy, int key) {
        Node prev = dummy;
        Node curr = dummy.next;
        while(curr != null && curr.key != key) {
            prev = curr;
            curr = curr.next;
        }
        return prev;

    }


    int buckets;
    Node[] storage;
    public HashMap() {
        this.buckets = 10000;
        this.storage = new Node[this.buckets];


    }

    int getBucket(int key) {
        return key % this.buckets;
    }

    public void put(int key, int value) {
        int bucket = getBucket(key);
        if(storage[bucket] == null) {
            storage[bucket] = new Node(-1, -1);
        }
        Node prev = find(storage[bucket], key);
        if(prev.next == null) {
            prev.next = new Node(key, value);
        } else {
            prev.next.value = value;
        }
    }

    public int get(int key) {
        int bucket = getBucket(key);
        if(storage[bucket] == null) {
            return -1;
        }
        Node prev = find(storage[bucket], key);
        if(prev.next != null) {
            return prev.next.value;
        }
        return -1;
    }

    public void remove(int key) {
        int bucket = getBucket(key);
        if(storage[bucket] == null) {
            return;
        }
        Node prev = find(storage[bucket], key);
        if(prev.next != null) {
            prev.next = prev.next.next;
        }

    }
}
