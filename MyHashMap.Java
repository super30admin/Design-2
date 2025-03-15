class MyHashMap {

    Node[] storage;
    int bucket;

    class Node{
        int key;
        int value;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public MyHashMap() {
        this.bucket = 10000;
        this.storage = new Node[bucket];
    }

    private int getHash(int key) {
        return key % bucket;
    }

    private Node getPrev(Node head, int key) {
        Node prev = null;
        Node curr = head;
        while (curr != null && curr.key != key) {
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }

    public void put(int key, int value) {
        int index = getHash(key);
        if (storage[index] == null) {
            storage[index] = new Node(-1, -1);
            storage[index].next = new Node(key, value);
            return;
        }

        Node prev = getPrev(storage[index], key);
        if (prev.next == null) { // new Node
            prev.next = new Node(key, value);
        } else { // existing node
            prev.next.value = value;
        }
    }

    public int get(int key) {
        int index = getHash(key);
        if (storage[index] == null) return -1;
        Node prev = getPrev(storage[index], key);
        if (prev.next == null) return -1;
        return prev.next.value;
    }

    public void remove(int key) {
        int index = getHash(key);
        if (storage[index] == null) return;
        Node prev = getPrev(storage[index], key);
        if (prev.next == null) return;
        prev.next = prev.next.next;
    }

    // Driver code to test MyHashMap
    public static void main(String[] args) {
        MyHashMap obj = new MyHashMap();
        obj.put(1, 1);       // Adds (1, 1) to the map
        obj.put(2, 2);       // Adds (2, 2) to the map
        System.out.println(obj.get(1)); // Returns 1
        System.out.println(obj.get(2)); // Returns 2
        System.out.println(obj.get(3)); // Returns -1 (not found)
        
        obj.put(2, 1);       // Updates (2, 2) to (2, 1)
        System.out.println(obj.get(2)); // Returns 1
        
        obj.remove(2);       // Removes (2, 1) from the map
        System.out.println(obj.get(2)); // Returns -1 (not found)
    }
}
