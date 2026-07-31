//Approach
//TC: O(1)
//SC: O(n)


class MyHashMap {
    Node[] storage;
    int buckets;

    class Node {
        int key;
        int value;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public MyHashMap() {
        this.buckets = 1000;
        this.storage = new Node[buckets];
    }

    public int getHash(int key) {
        return key % buckets;
    }

    public Node getPrev(Node head, int key) {
        Node prev = null;
        Node curr = head;
        while (curr != null && curr.key != key) {
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }

    public void put(int key, int value) {
        int primary = getHash(key);
        if (storage[primary] == null) {
            storage[primary] = new Node(-1, -1);
            storage[primary].next = new Node(key, value);
            return;
        }
        Node prev = getPrev(storage[primary], key);
        if (prev.next == null) {
            prev.next = new Node(key, value);
        } else {
            prev.next.value = value;
        }
    }

    public int get(int key) {
        int hash = getHash(key);
        if (storage[hash] == null)
            return -1;
        Node prev = getPrev(storage[hash], key);
        if (prev.next == null) {
            return -1;
        }
        return prev.next.value;
    }

    public void remove(int key) {
        int hash = getHash(key);
        if (storage[hash] == null) {
            return;
        }
        Node prev = getPrev(storage[hash], key);
        if (prev.next == null) {
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