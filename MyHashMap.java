class MyHashMap {
    class Node {
        int key;
        int value;
        Node next;

        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    int buckets;
    Node[] storage;

    public MyHashMap() {
        this.buckets = 10000;
        storage = new Node[this.buckets];
    }
    
    public void put(int key, int value) {
        int bucket = this.hashIndex(key);
        if(storage[bucket] == null) {
            storage[bucket] = new Node(-1, -1);
            storage[bucket].next = new Node(key, value);
        } else{
            //check if key exists
            Node prevNode = find(storage[bucket], key);
            if(prevNode.next == null){
                prevNode.next = new Node(key, value);
            }else {
                prevNode.next.value = value;
            }
        }
    }
    
    public int get(int key) {
          int bucket =  this.hashIndex(key);
          if(storage[bucket] != null){
             Node prevNode = find(storage[bucket], key);
             if(prevNode.next != null){
                return prevNode.next.value; 
             }
          }
          return -1;
    }
    
    public void remove(int key) {
        int bucket =  this.hashIndex(key);
        if(storage[bucket] != null){
            Node prevNode = find(storage[bucket], key);
            if(prevNode.next != null){
                prevNode.next = prevNode.next.next;
            }
        }
    }

    private int hashIndex(int key){
        return key%this.buckets;
    }

    private Node find(Node head, int key){
        Node prev = null;
        Node curr = head;
        while(curr != null && curr.key != key){
           prev = curr;
           curr = curr.next; 
        }

        return prev;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */