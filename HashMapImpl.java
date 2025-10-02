/**
 * 1. Implementing Hashmap using Linear chaining for resolving collisions.
 * 2. We use Linked list for underling data structure.
 * 3. For put/get/remove we will first find previous node.
 * 4. Time Complexity for put/get/remove operations is amortized O(1)
 */
class MyHashMap2 {

    private int bucketSize = 10000;
    private Node[] nodes;

    class Node {
        int val;
        int key;
        Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    public MyHashMap2() {
        this.nodes = new Node[bucketSize];
    }

    private int hash1(int key) {
        return key % bucketSize;
    }

    private Node find(int key, Node head) {
        Node previous = head;
        Node current = head.next;
        while (current != null && current.key != key) {
            previous = current;
            current = current.next;
        }
        return previous;
    }

    //Time Complexity : Amortized O(1)
    public void put(int key, int value) {
        int idx = hash1(key);
        if (nodes[idx] == null) {
            //create a dummy node at the head
            nodes[idx] = new Node(-1, -1);
        }
        Node previous = find(key, nodes[idx]);
        if (previous.next == null) {
            previous.next = new Node(key, value);
        } else {
            previous.next.val = value;
        }

    }

    //Time Complexity : Amortized O(1)
    public int get(int key) {
        int idx = hash1(key);
        if (nodes[idx] == null) return -1;
        Node previous = find(key, nodes[idx]);
        if(previous.next == null) return  -1;

        return previous.next.val;
    }

    //Time Complexity : Amortized O(1)
    public void remove(int key) {
        int idx = hash1(key);
        if (nodes[idx] == null) return;
        Node previous = find(key, nodes[idx]);
        if(previous.next == null) return;

        previous.next = previous.next.next;
    }

}