class MyHashMap {
    private Node[] storage;
    class Node{
        int key;
        int val;
        Node next;
        public Node(int key, int value){
            this.key=key;
            this.val=value;
        }
    }
    
    public MyHashMap() {
        this.storage = new Node[10000];     
    }
       public void put(int key, int value){
        int idx = hashKey(key);
        if(storage[idx]==null){
           storage[idx] = new Node(-1,-1);
        }
        Node prev = find(storage[idx],key);
        if(prev.next ==null){
            prev.next = new Node(key,value);
        }
        prev.next.val = value;
    }
    private int hashKey(int key){
        return key%10000;
    }

    private Node find(Node head, int key){
        Node prev = head;
        Node curr = head.next;
        while(curr!=null && curr.key!=key){
            prev = curr;
            curr = curr.next;
        }
        return prev;

    }

 
    
    public int get(int key) {
        int idx = hashKey(key);
        if(storage[idx]==null){
            return -1;
        }
        Node prev = find(storage[idx],key);
        if(prev.next == null) return -1;
        return prev.next.val;
    }
    
    public void remove(int key) {
         int idx = hashKey(key);
        if(storage[idx]==null){
            return;
        }
        Node prev = find(storage[idx],key);
         if(prev.next == null) return;
         Node tem = prev.next;
         prev.next = prev.next.next;
         tem.next = null;
        
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */