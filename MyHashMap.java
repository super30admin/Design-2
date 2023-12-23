class MyHashMap {
    class Node {
        int key;
        int val;
        Node next;

        private Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }
    private int buckets;
    private Node [] storage;
    public MyHashMap() {
        this.storage = new Node[10000];
    }
    private int hash(int key){
        return key%10000;
    }

    private Node find(Node node, int key){
        Node currNode = node;
        Node prevNode = null;
        while(currNode != null && currNode.key != key){
            prevNode = currNode;
            currNode = prevNode.next;
        }
        return prevNode;
    }
    public void put(int key, int value) {
        int bucket = hash(key);
        if(storage[bucket] == null){
            storage[bucket] = new Node(-1,-1);
        } 
        Node prev = find(storage[bucket], key);
        if(prev.next == null){
            prev.next = new Node(key, value);
        } else {
            prev.next.val = value;
        }
        
    }
    
    public int get(int key) {
        int bucket = hash(key);
        if(storage[bucket] == null){
            return -1;
        } 
        Node prev = find(storage[bucket], key);
        if(prev.next == null){
            return -1;
        } else {
           return prev.next.val;
        }
    }
    
    public void remove(int key) {
        int bucket = hash(key);
        if(storage[bucket] == null){
            return;
        } 
        Node prev = find(storage[bucket], key);
        if(prev.next == null){
            return;
        } 
        Node temp = prev.next;
        prev.next = prev.next.next;
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
