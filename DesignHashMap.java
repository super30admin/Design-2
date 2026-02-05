// O(1) time, O(n) space

// Linked List class
class Node {
    int key;
    int value;
    Node next;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }
}

class DesignHashMap {

    int primaryBuckets = 10000;
    Node[] table;

    public DesignHashMap() {
        table = new Node[primaryBuckets];
    }

    private int getHash(int key) {
        return key % primaryBuckets;
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

        if (table[index] == null) {
            table[index] = new Node(-1, -1); // dummy node
            table[index].next = new Node(key, value); // assign dummy.next to incoming node
            return;
        }

        Node prev = getPrev(table[index], key);
        
        if (prev.next == null) {
            prev.next = new Node(key, value);
        }
        else {
            prev.next.value = value; // if key exists, update value
        }

    }
    
    public int get(int key) {
        int index = getHash(key);

        if (table[index] == null) {
            return -1;
        }

        Node prev = getPrev(table[index], key);
        if (prev.next == null) {
            return -1;
        }
        return prev.next.value;
    }
    
    public void remove(int key) {
        int index = getHash(key);

        if (table[index] == null) {
            return;
        }

        Node prev = getPrev(table[index], key);
        if (prev.next == null) {
            return;
        }
        prev.next = prev.next.next; // update pointer
        
    }
}