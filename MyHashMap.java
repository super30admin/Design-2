// Time Complexity :o(n)amortized
// Space Complexity :o(n)
// Did this code successfully run on Leetcode :Yess
// Any problem you faced while coding this :I was having an issue in understanding the find function used here.
class MyHashMap {
    private static class Node {
        int key;
        int value;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    private LinkedList<Node>storage[];
    int capacity;

    public MyHashMap() {
        this.capacity = 1000;
        this.storage = new LinkedList[capacity];
    }

    private int hash(int key) {
        return key % capacity;
    }

    private Node find(LinkedList<Node> list, int key) {
        for (Node node : list) {
            if (node.key == key) {
                return node;
            }
        }
        return null;
    }

    public void put(int key, int value) {
        int bucket = hash(key);

        if (storage[bucket] == null) {
            storage[bucket] = new LinkedList<>();
        }

        Node node = find(storage[bucket], key);
        if (node != null) {
            node.value = value; // Update existing key
        } else {
            storage[bucket].add(new Node(key, value)); 
        }
    }

    public int get(int key) {
        int bucket = hash(key);

        if (storage[bucket] != null) {
            Node node = find(storage[bucket], key);
            if (node != null) {
                return node.value;
            }
        }

        return -1; // Key not found
    }

    public void remove(int key) {
        int bucket = hash(key);
        if (storage[bucket] != null) {
            Node node = find(storage[bucket], key);
            if (node != null) {
                storage[bucket].remove(node); 
            }
        }
    }   
}
