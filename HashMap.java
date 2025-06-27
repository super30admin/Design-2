class MyHashMap {
    private class Node {
        int key, value;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int SIZE = 10000;
    private Node[] buckets;

    public MyHashMap() {
        buckets = new Node[SIZE];
    }

    private int getBucketIndex(int key) {
        return key % SIZE;
    }

    private Node findPrev(Node head, int key) {
        Node prev = head;
        Node curr = head.next;
        while (curr != null && curr.key != key) {
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }

    public void put(int key, int value) {
        int index = getBucketIndex(key);
        if (buckets[index] == null) {
            // Dummy node to simplify insertion/removal
            buckets[index] = new Node(-1, -1);
        }
        Node prev = findPrev(buckets[index], key);
        if (prev.next == null) {
            prev.next = new Node(key, value); // Insert new node
        } else {
            prev.next.value = value; // Update existing value
        }
    }

    public int get(int key) {
        int index = getBucketIndex(key);
        if (buckets[index] == null) return -1;
        Node prev = findPrev(buckets[index], key);
        if (prev.next == null) return -1;
        return prev.next.value;
    }

    public void remove(int key) {
        int index = getBucketIndex(key);
        if (buckets[index] == null) return;
        Node prev = findPrev(buckets[index], key);
        if (prev.next != null) {
            prev.next = prev.next.next;
        }
    }
}
