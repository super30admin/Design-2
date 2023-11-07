class MyHashMap {
    
    class Node
    {
        int key, value;
        Node next;
        public Node(int key, int value)
        {
            this.key = key;
            this.value = value;
        }
    }
    
    Node[] nodes;
    int bucketSize;
    
    public MyHashMap() {
        
        bucketSize = 10000;
        nodes = new Node[bucketSize];
    }
    
    public int getBucket(int key)
    {
        return key % bucketSize;
    }
    
    public Node find(Node n, int key)
    {
            
        Node prev = n;
        Node cur = prev.next;
        
        while(cur != null && cur.key != key)
        {
            prev = cur;
            cur = cur.next;
        }
        return prev;
    }
    
    public void put(int key, int value) {
        
        int hashValue = getBucket(key);
        if(nodes[hashValue] == null)
        {
            nodes[hashValue] = new Node(-1, -1);
        }
        
        Node n = find(nodes[hashValue], key);
        if(n.next == null)
            n.next = new Node(key, value);
        else
            n.next.value = value;
        
    }
    
    public int get(int key) {
        
        int hashValue = getBucket(key);
        
        if(nodes[hashValue] == null) return -1;
        
        Node n = find(nodes[hashValue], key);               
        if(n.next == null) return -1;
        
        return n.next.value;
        
    }
    
    public void remove(int key) {
        
        int hashValue = getBucket(key);
        if(nodes[hashValue] == null) return;
        
        Node n = find(nodes[hashValue], key);
        
        if(n.next == null) return;
        
        n.next = n.next.next;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */