class MyHashMap {
    class Node{
        int key;
        int value;
        Node next;
        public Node(int key,int value){
            this.key = key;
            this.value = value;
        }
    }
    private Node []storage;

    public MyHashMap() {
        this.storage = new Node[10000];
    }

    private int hashfunction(int key){
        return key%10000;
    }

    private Node search(Node head, int value){
       Node prev = null;
       Node curr = head;
       while(curr != null && curr.key != value){
           prev = curr;
           curr = curr.next;
       }
       return prev;
    }
    
    public void put(int key, int value) {
        int index = hashfunction(key);
        if(storage[index] == null){
            storage[index] = new Node(-1,-1);
        } 
        Node prev = search(storage[index],key);
        if(prev.next == null){
            prev.next = new Node(key,value);
        }else{
            prev.next.value = value;
        }
    }
    
    public int get(int key) {
        int index = hashfunction(key);
        if(storage[index] == null) return -1;
        Node prev = search(storage[index],key);
        if(prev.next == null) return -1;
        return prev.next.value;
    }
    
    public void remove(int key) {
        int index = hashfunction(key);
        if(storage[index] == null) return;;
           Node prev = search(storage[index],key);
           if(prev.next == null) return;
           Node temp = prev.next;
           prev.next = prev.next.next;
           temp.next=null;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */