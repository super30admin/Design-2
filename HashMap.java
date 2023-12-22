class HashMap {
    Node[] storage;
    int buckets;
    public MyHashMap() {
        this.buckets = 10000;
        storage = new Node[buckets];
    }

    private int getBucketHash(int k) {
        return k % buckets;
    }

    private Node getPrevNode(Node node, int key) {
        Node prev = null;
        Node curr = node;
        while (curr != null && curr.key != key) {
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }

    public void put(int key, int value) {
        int hash = getBucketHash(key);
        if (storage[hash] == null) {
            storage[hash] = new Node(-1, -1);
        }
        Node prev = getPrevNode(storage[hash], key);
        if (prev.next == null) {
            prev.next = new Node(key, value);
        } else {
            prev.next.value = value;
        }
    }

    public int get(int key) {
        int hash = getBucketHash(key);
        if (storage[hash] == null) {
            return -1;
        }
        Node prev = getPrevNode(storage[hash], key);
        if (prev.next == null) {
            return -1;
        } else {
            return prev.next.value;
        }
    }

    public void remove(int key) {
        int hash = getBucketHash(key);
        if (storage[hash] == null) {
            return;
        }
        Node prev = getPrevNode(storage[hash], key);
        if (prev.next == null) {
            return;
        } else {
            prev.next = prev.next.next;
        }
    }
}

class Node {
    int key;
    int value;
    Node next;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

/**
 * Your HashMap object will be instantiated and called as such:
 * HashMap obj = new HashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */