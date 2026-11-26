// Time Complexity: O(1) average case for all operations
// Space Complexity: O(N + K) where N is the new nodes created and K is size of the array: buckets.
// Choosing a SIZE integer as prime to reduce collisions and to address most of the 
// new nodes created in separate buckets as much as possible with load factor of close 
// to 1. 

class MyHashMap {

    private static final int SIZE = 10009;
    private Node[] buckets; 

    private static class Node {
        int key;
        int value;
        Node next;

        Node(int key, int value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public MyHashMap() {
    }

    private int hash(int key) {
        return key % SIZE;
    }

    public void put(int key, int value) {
        if (buckets == null) {
            buckets = new Node[SIZE];
        }

        int index = hash(key);
        Node head = buckets[index];

        if (head == null) {
            buckets[index] = new Node(key, value, null);
            return;
        }

        Node curr = head;
        while (true) {
            if (curr.key == key) {
                curr.value = value;
                return;
            }
            if (curr.next == null) {
                break;
            }
            curr = curr.next;
        }

        curr.next = new Node(key, value, null);
    }

    public int get(int key) {
        if (buckets == null) {
            return -1;
        }

        int index = hash(key);
        Node curr = buckets[index];

        while (curr != null) {
            if (curr.key == key) {
                return curr.value;
            }
            curr = curr.next;
        }

        return -1;
    }

    public void remove(int key) {
        if (buckets == null) {
            return;
        }

        int index = hash(key);
        Node curr = buckets[index];

        if (curr == null) {
            return;
        }

        if (curr.key == key) {
            buckets[index] = curr.next;
            return;
        }

        while (curr.next != null) {
            if (curr.next.key == key) {
                curr.next = curr.next.next;
                return;
            }
            curr = curr.next;
        }
    }
}
