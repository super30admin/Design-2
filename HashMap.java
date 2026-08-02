class MyHashMap {

    Node[] storage;
    int buckets;

    class Node{
        int key;
        int value;
        Node next;

        public Node(int key , int value){
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    public MyHashMap() {

    this.buckets = 1000;
    storage = new Node[1000];
        
        
    }
    public int getHash(int key){
        return key % buckets;

    }

    public Node getPrev(Node head, int key) {
        Node prev = null;
        Node curr = head;
        while(curr != null && curr.key != key ){
            prev = curr;
            curr = curr.next;
        }
        return prev;

    }


    
    
    public void put(int key, int value) {
        int index = getHash(key);
        if(storage[index] == null){
            Node firstNode = new Node(-1,-1);
            storage[index] = firstNode;
            storage[index].next = new Node(key,value);
            return;
        }
           Node prev = getPrev(storage[index], key);
        if(prev.next == null){ 
            prev.next = new Node(key, value);
        }else{ 
            prev.next.value = value;
        }

        
    }

    public int get(int key) {
        int index = getHash(key);
        if(storage[index] == null) return -1;
        Node prev = getPrev(storage[index], key);
        if(prev.next == null) return -1;
        return prev.next.value;
        
    }
    
    public void remove(int key) {
         int index = getHash(key);
        if(storage[index] == null ){
        return;
        }
        if( getPrev(storage[index], key).next == null ){
            return ;
        } else {
        getPrev(storage[index], key).next = getPrev(storage[index], key).next.next;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */