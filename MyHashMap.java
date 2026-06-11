class MyHashMap {

    private int MAX_SIZE = 1000000;
    private int BUCKET_SIZE = 1000;
    Node[] bucket;

    public MyHashMap() {
        bucket = new Node[BUCKET_SIZE];
    }

    protected int hash(int key) {
        return (key % BUCKET_SIZE);
    }

    protected Pair<Node, Node> getPrevAndCurrNodes(int key) {
        Node head = bucket[hash(key)];
        Node prev = null;
        Node curr = null;
        if (head != null) {
            prev = head;
            curr = head.next;
            while (curr != null && curr.pair.getKey() != key) {
                prev = curr;
                curr = curr.next;
            }
        }
        return new Pair<>(prev, curr);
    }

    public void put(int key, int value) {
        if (bucket[hash(key)] == null) {
            Node head = new Node(-1, -1);
            bucket[hash(key)] = head;
        }
        Pair<Node, Node> nodes = getPrevAndCurrNodes(key);
        Node prev = nodes.getKey();
        Node curr = nodes.getValue();
        if (curr == null) {
            prev.next = new Node(key, value);
        } else {
            curr.pair = new Pair<>(key, value);
        }

    }

    public int get(int key) {
        Pair<Node, Node> nodes = getPrevAndCurrNodes(key);
        Node prev = nodes.getKey();
        Node curr = nodes.getValue();
        if (prev != null && curr != null) {
            return curr.pair.getValue();
        }
        return -1;
    }

    public void remove(int key) {
        Pair<Node, Node> nodes = getPrevAndCurrNodes(key);
        Node prev = nodes.getKey();
        Node curr = nodes.getValue();

        if (prev != null && curr != null) {
            prev.next = curr.next;
            curr.next = null;
        }

    }
}

class Node {
    protected Pair<Integer, Integer> pair;
    protected Node next;

    public Node(int key, int value) {
        this.pair = new Pair<>(key, value);
        this.next = null;
    }

}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */