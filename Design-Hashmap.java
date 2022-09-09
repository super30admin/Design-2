class MyHashMap {

    class Node{
        int key,value;
        Node next;
        public Node(int key, int value)
        {
            this.key = key;
            this.value = value;
        }
    }
    Node[] nodes;
    private int buckets;
    private int getBuckets(int key)
    {
        return Integer.hashCode(key) % buckets;
        //can use key % buckets too
    }
    
    public MyHashMap() {
        buckets = 10000;
        nodes = new Node[buckets];
    }
    private Node find(Node node, int key)
    {
        Node prev = node;
        Node curr = node.next;
        while(curr!=null && curr.key != key)
        {
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }
    
    public void put(int key, int value) {
        int bucket = getBuckets(key);
        //Linked list doesnot exist
        if(nodes[bucket] == null)
        {
            //create dummy node
            nodes[bucket] = new Node(-1,-1);
        }
        //FInd the node
        Node prev = find(nodes[bucket],key);
        //key not exist
        if(prev.next == null)
        {
            prev.next = new Node(key, value);
        }//key exist
        else
        {
            prev.next.value = value;
        }
    }
    
    public int get(int key) {
        int bucket = getBuckets(key);
        if(nodes[bucket] == null)
            return -1;
        Node prev = find(nodes[bucket], key);
        if(prev.next == null)
            return -1;
        return prev.next.value;
    }
    
    public void remove(int key) {
        int bucket = getBuckets(key);
        //node doesnot  exist
        if(nodes[bucket]==null)
            return;
        //node may or maynot exist
        Node prev = find(nodes[bucket], key);
        if(prev.next == null)
        {
            return;
        }
        //Node exists
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
