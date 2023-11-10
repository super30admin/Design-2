class MyHashMap {
//linear chaining

    int buckets;

    Node[] storage;
    class Node{
        int key;
        int value;
        Node next;

        public Node(int key, int value){
            this.key=key;
            this.value=value;
        }
    }

    private int hash(int key){
        return key%buckets;
    }
    public MyHashMap() {
        this.buckets=10000;
        storage = new Node[buckets];
    }
    private Node findprev(Node head, int key){
        Node prev = null;
        Node curr = head;
        while(curr != null && curr.key != key){
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }
    public void put(int key, int value) {
        int hash = hash(key);
        if(storage[hash] == null){
            storage[hash] = new Node(-1,-1);
            storage[hash].next = new Node(key, value);
        }else{
            Node prev = findprev(storage[hash], key);
            if(prev.next == null){
                prev.next = new Node(key, value);
            }else{
                prev.next.value=value;
            }
        }
    }

    public int get(int key) {
        int hash = hash(key);
        if(storage[hash] == null){
            return -1;
        }
        Node prev = findprev(storage[hash], key);
        if(prev.next == null) return -1;
        return prev.next.value;
    }

    public void remove(int key) {
        int hash = hash(key);
        if(storage[hash] == null) return;
        Node prev = findprev(storage[hash], key);
        if(prev.next == null) return;
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