class MyHashMap {

    class Node {
        int key;
        int val;
        Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
            this.next = null;
        }
    }

    private Node[] storage;

    public MyHashMap() {
        this.storage = new Node[10000];
    }

    private Node find(Node head, int key) {
        Node prev = null;
        Node curr = head;
        while (curr != null && curr.key != key) {
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }

    private int hashIndex(int key) {
        return key % 10000;
    }

    public void put(int key, int value) {
        int index = hashIndex(key);
        if (storage[index] == null) {
            storage[index] = new Node(-1, -1);
        }
        Node prev = find(storage[index], key);
        if (prev.next == null) {
            prev.next = new Node(key, value);
        } else {
            prev.next.val = value;
        }
    }

    public int get(int key) {
        int index = hashIndex(key);
        if (storage[index] == null) {
            return -1;
        }
        Node prev = find(storage[index], key);
        if (prev.next == null) {
            return -1;
        } else {
            return prev.next.val;
        }
    }

    public void remove(int key) {
        int index = hashIndex(key);
        if (storage[index] == null) {
            return;
        }
        Node prev = find(storage[index], key);
        if (prev.next == null) {
            return;
        } else {
            prev.next = prev.next.next;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */