class MyHashMap {
    //Time complexity :- O(n)
    //Space Complexity :- O(n)
    class Node{
        int key;
        int value;
        Node next;
        public Node(int key,int value){
            this.key=key;
            this.value=value;
        }
    }
    private Node[] storage;
    public MyHashMap() {
        this.storage= new Node[10000];
    }
    private int hashinx(int key){
        return key % 10000;
    }
    //for all the operation there is only one find function
    private Node find(Node head,int key){
        Node prev=null;
        Node curn=head;
        //finding the key will end @ 2 situation 1.is at when you not find the key and end in the last index of the linkedlist where it will come out of the loop without finding anything 2. is at the situation where you find the key
        while(curn!=null && curn.key==key){
            prev=curn;
            curn=curn.next;
        }
        return prev;
    }
    
    public void put(int key, int value) {
        int hash = hashinx(key);
        //what if the given index is consisting of null pointer
        if(storage[hash]==null)
        {
            storage[hash] = new Node(-1,-1);
        }
        Node node = find(storage[hash],key);
        //2.you need to create the new one if the given key is not there 
        if(node.next == null){
            node.next = new Node(key,value);
        }
        //1.you need to put the given value to the excisting key for that you need to find the key first
        else{
            node.next.value = value;
        }
        
    }
    
    public int get(int key) {
        int hash = hashinx(key);
        if(storage[hash]==null) return -1;
        Node node = find(storage[hash],key);
        //2.you need to create the new one if the given key is not there 
        if(node.next==null) return -1;
        //1.you need to put the given value to the excisting key for that you need to find the key first
        else{
            return node.next.value;
        }
    }
    
    public void remove(int key) {
        int hash = hashinx(key);
        if(storage[hash]==null) return;
        Node node = find(storage[hash],key);
        //2.you need to create the new one if the given key is not there 
        if(node.next==null) return;
        //1.you need to put the given value to the excisting key for that you need to find the key first
        else{
            node.next=node.next.next;
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