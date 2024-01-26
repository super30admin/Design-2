class MyHashMap {
    class Node{
        int key, value;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    private  Node[] storage;
    private int size;
    public MyHashMap() {
        this.size = 10000;
        this.storage = new Node[this.size];
        
    }

    private int hash(int key) {
        return key % 10000;
    }

    private Node search(Node head, int key) {
       Node prev = null;
       Node curr = head;
       while (curr != null && curr.key != key) {
           prev = curr;
           curr = curr.next;
       }

       return prev;
    }
    
    public void put(int key, int value) {
        int idx = hash(key);
        if(storage[idx] == null) {
            storage[idx] = new Node(-1, -1);
        }

        Node prev = search(storage[idx], key);

        if(prev.next == null) {
            prev.next = new Node(key, value);
        }else {
            prev.next.value = value;
        }       
    }
    
    public int get(int key) {
        int idx = hash(key);
        if(storage[idx] == null) {
           return -1;
        }

        Node prev = search(storage[idx], key);

        if(prev.next == null) {
            return -1;
        }else {
            return prev.next.value;
        }       
    }
    
    public void remove(int key) {
        int idx = hash(key);
        if(storage[idx] == null) {
           return;
        }
        Node prev = search(storage[idx], key);

        if (prev.next == null) return;
        Node temp = prev.next;
        prev.next = temp.next;
        temp.next = null;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */