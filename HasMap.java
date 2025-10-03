class MyHashMap {
    // Entry class to store key-value pairs
    private static class Entry {
        int key;
        int value;
        Entry next;

        Entry(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private static final int SIZE = 1000;  // Number of buckets
    private Entry[] buckets;

    public MyHashMap() {
        buckets = new Entry[SIZE];
    }

    private int hash(int key) {
        return key % SIZE;
    }

    public void put(int key, int value) {
        int index = hash(key);
        Entry head = buckets[index];

        if (head == null) {
            buckets[index] = new Entry(key, value);
            return;
        }

        Entry curr = head;
        while (curr != null) {
            if (curr.key == key) {
                curr.value = value; // Update value if key exists
                return;
            }
            if (curr.next == null) break;
            curr = curr.next;
        }

        // Append new entry at the end of the chain
        curr.next = new Entry(key, value);
    }

    public int get(int key) {
        int index = hash(key);
        Entry curr = buckets[index];

        while (curr != null) {
            if (curr.key == key) {
                return curr.value;
            }
            curr = curr.next;
        }

        return -1; // Key not found
    }

    public void remove(int key) {
        int index = hash(key);
        Entry curr = buckets[index];
        Entry prev = null;

        while (curr != null) {
            if (curr.key == key) {
                if (prev == null) {
                    // Remove head of list
                    buckets[index] = curr.next;
                } else {
                    prev.next = curr.next;
                }
                return;
            }
            prev = curr;
            curr = curr.next;
        }
    }
}

//Time Complexity : O(1)
//Space Complexity : O(n)