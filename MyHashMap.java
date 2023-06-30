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
    int buckets;

    public MyHashMap() {
        this.buckets = 10000;
        this.storage = new Node[buckets];
    }

    private int hasidx(int key) {
        return key % buckets;
    }

    private Node find(Node head, int value) {
        Node prev = null;
        Node curr = head;
        while (curr != null && curr.key != value) {
            prev = curr;
            curr = curr.next;
        }

        return prev;

    }

    public void put(int key, int value) {
        int bucket = hasidx(key);
        if (storage[bucket] == null) {
            storage[bucket] = new Node(-1, -1);
        }
        Node prev = find(storage[bucket], key);
        if (prev.next == null) {
            prev.next = new Node(key, value);
        } else {
            prev.next.val = value;
        }

    }

    public int get(int key) {
        int bucket = hasidx(key);
        if (storage[bucket] == null) {
            return -1;
        }
        Node prev = find(storage[bucket], key);
        if (prev.next == null) {
            return -1;
        }
        return prev.next.val;

    }

    public void remove(int key) {
        int bucket = hasidx(key);
        if (storage[bucket] == null)
            return;
        Node prev = find(storage[bucket], key);
        if (prev.next == null)
            return;
        prev.next = prev.next.next;

    }
}
