
class MyHashMap {

    class Node{
            int key, value;
            Node next;

            public Node(int key, int value)
            {
                this.key = key;
                this.value = value;
            }
        }
        Node[] storage;
    public MyHashMap() {
        storage = new Node[10000];
        
    }

    private int hash(int key)
    {
        return key%storage.length;
    }

    TC = O(1)
    SC = O(1)
    private Node find(Node node, int key)
    {
        Node prev = null, curr = node;
        while(curr!= null &&  curr.key != key)
        {
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }
    
    TC = O(1)
    SC = O(1)
    public void put(int key, int value) {
        int bucket = hash(key);
        if(storage[bucket] == null)
        {
            storage[bucket ] = new Node(-1,-1);
        }
        Node prev = find(storage[bucket], key);
        if(prev.next != null)
        {
            prev.next.value = value;
        }
        else
        {
            prev.next = new Node(key, value);

        }
        
    }
    
    TC = O(1)
    SC = O(1)
    public int get(int key) {
        int bucket = hash(key);
        if(storage[bucket] == null) return -1;
        Node prev = find(storage[bucket], key);
        if(prev.next == null) return -1;
        return prev.next.value;
    }
    
    TC = O(1)
    SC = O(1)
    public void remove(int key) {
        int bucket = hash(key);
        if(storage[bucket] == null) return;
        Node prev = find(storage[bucket], key);
        if(prev.next == null) return;
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