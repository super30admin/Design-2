class MyHashSet {

    class Node{
        int key;
        Node next;

        public Node(int key) {
            this.key = key;
            this.next = null;

        }
    }

    private int size;
    private Node[] container;

    public MyHashSet() {
        this.size = 1000;
        this.container = new Node[size];
    }

    private int _hash(int key) {
        return key % this.size;
    }

    private Node search(Node head, int key) {
        Node prev = null;
        Node curr = head;

        while(curr != null && curr.key != key) {
            prev = curr;
            curr = curr.next;
        }

        return prev;
    }
    
    public void add(int key) {
        int idx = _hash(key);
        if(this.container[idx] == null) {
            this.container[idx] = new Node(-1);
        }

        Node prev = search(this.container[idx], key);
        if (prev.next != null) return;
        if (prev.next == null) {
            prev.next = new Node(key);
        } 
    }
    
    public void remove(int key) {
        int idx = _hash(key);
        if (container[idx] == null) return;

        Node prev = search(container[idx], key);

        if(prev.next == null) return;
        Node temp = prev.next;
        prev.next = temp.next;
        temp.next = null;
        

    }
    
    public boolean contains(int key) {
        int idx = _hash(key);
        if (container[idx] == null) return false;

        Node prev = search(container[idx], key);

        if (prev.next == null) return false;

        return true;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */