// Time Complexity : For all operations: - O(L) // L - max length of a list of an array index.
// Space Complexity : O(n)
class MyHashMap {
    Node[] arr;
    int bucketSize; 

    static class Node {
        int key;
        int value;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    public MyHashMap() {
        this.bucketSize = 1000;
        arr = new Node[bucketSize];
    }
    
    private int getBucketIndex(int key) {
        return key % bucketSize;
    }

    private Node findPrev(int key) {
        int index = getBucketIndex(key);
        if (arr[index] == null) {
            arr[index] = new Node(-1,-1);
        }
        Node prev = arr[index];
        Node cur = arr[index];
        while (cur != null && cur.key != key) {
            prev = cur;
            cur = cur.next;
        }
        return prev;
    }

    public void put(int key, int value) {
        Node prev = findPrev(key);

        if (prev.next == null) {
            prev.next = new Node(key, value);
        } else {
            prev.next.value = value;
        }
        
    }
    
    public int get(int key) {
        Node prev = findPrev(key);
        if (prev.next == null) {
            return -1;
        } else {
            return prev.next.value;
        }
    }
    
    public void remove(int key) {
        Node prev = findPrev(key);
        if (prev.next != null) {
            prev.next = prev.next.next;
        }
    }
}