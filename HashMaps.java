class MyHashMap {    
    class Node {
        int key, value;
        Node nextNode;

        public Node (int key, int value) {
            this.key = key;
            this.value = value;
        }   
    }

    Node[] storage;
    int buckets;

    public MyHashMap() {
        buckets = 10000;
        storage = new Node[buckets];
    }
       
    public void put(int key, int value) {
        int hashKey = getHashKey(key);
        if (storage[hashKey] == null) {
            storage[hashKey] = new Node(-1, -1);
        }
        Node prev = findNode(storage[hashKey], key);
        if (prev.nextNode == null) {
            Node newNode = new Node(key, value);
            prev.nextNode = newNode;
    
        }
        else {
            prev.nextNode.value = value;
        }    
    }
    
    public int get(int key) {
        int hashKey = getHashKey(key);
        if (storage[hashKey] == null) {
            return -1;
        }
        Node prev = findNode(storage[hashKey], key);
        if (prev.nextNode == null) {
            return -1;
        }
        return prev.nextNode.value;
    }
    
    public void remove(int key) {
        int hashKey = getHashKey(key);
        if (storage[hashKey] == null) {
            return;
        }
        Node prev = findNode(storage[hashKey], key);
        if (prev.nextNode == null) {
            return;
        }
        prev.nextNode = prev.nextNode.nextNode;
    }


    public int getHashKey(int key) {
        return key % buckets;
    }

    public Node findNode(Node node , int key) {
        Node prev = node;
        Node current = node.nextNode;
        while (current != null && current.key != key) {
            prev = current;
            current = prev.nextNode;
        }
        return prev;
    }
}