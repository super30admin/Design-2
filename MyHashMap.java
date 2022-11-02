import java.util.Objects;

class MyHashMap {

    class Node {
        int key, value;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    int bucketSize;
    Node[] bucket;

    public MyHashMap() {
        this.bucketSize = 1000;
        bucket = new Node[bucketSize];
    }

    private int getBucketIndex(int key) {
        return key % bucketSize;
    }

    private Node findPrev(Node head, int key) {
        Node prev = head;

        while (Objects.nonNull(prev.next)) {
            if (prev.next.key == key) {
                return prev;
            }
            prev = prev.next;
        }

        return prev;
    }

    /**
     * TC: O(n) - n is max number of node in a bucket
     * SC: O(n) - n is total number of elements
     */
    public void put(int key, int value) {
        int bucketIndex = getBucketIndex(key);

        if (Objects.isNull(bucket[bucketIndex])) {
            Node head = new Node(-1,-1);
            bucket[bucketIndex] = head;
        }
        Node prev = findPrev(bucket[bucketIndex], key);

        if (prev.next == null) {
            Node current = new Node(key, value);
            prev.next = current;
        } else {
            prev.next.value = value;
        }
    }

    /**
     * TC: O(n) - n is max number of node in a bucket
     * SC: O(n) - n is total number of elements
     */
    public int get(int key) {
        int bucketIndex = getBucketIndex(key);

        if (Objects.isNull(bucket[bucketIndex])) {
            return -1;
        }

        Node prev = findPrev(bucket[bucketIndex], key);

        return prev.next != null && prev.next.key == key ? prev.next.value : -1;
    }

    /**
     * TC: O(n) - n is max number of node in a bucket
     * SC: O(n) - n is total number of elements
     */
    public void remove(int key) {
        int bucketIndex = getBucketIndex(key);

        if (Objects.isNull(bucket[bucketIndex])) {
            return;
        }

        Node prev = findPrev(bucket[bucketIndex], key);

        if (Objects.isNull(prev.next) ) {
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