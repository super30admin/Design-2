class MyHashMap {
    Node[] storage;
    class Node{
        int key;
        int val;
        Node next;

        public Node(int key,int val){
            this.key = key;
            this.val = val;
        }
    }

    private int hash_func(int key){
        return key%10000;
    }
    // initializing empty hash map of size 10000
    public MyHashMap() {
        this.storage = new Node[10000];
    }
    private Node find(Node node,int key){
        Node prev = null;
        Node curr = node;
        while(curr != null && curr.key!=key){
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }

    public void put(int key, int value) {
        int h1 = hash_func(key);
        if (storage[h1] == null){
            storage[h1] = new Node(-1,-1);
        }
        Node prev = find(storage[h1],key);
        if(prev.next == null){
            prev.next = new Node(key,value); // insert new node at end of linked list
        }
        else{
            prev.next.val = value; // update val
        }
        
    }
    
    public int get(int key) {
        int h1 = hash_func(key);
        if (storage[h1] == null){
            return -1;
        }
        Node prev = find(storage[h1],key);
        if(prev.next == null){return -1;}
        else{return prev.next.val;}
        
    }
    
    public void remove(int key) {
        int h1 = hash_func(key);
        if (storage[h1] == null){return;}
        Node prev = find(storage[h1],key);
        if(prev.next == null){return;}
        prev.next = prev.next.next;
    }

    // public static void main(String[] args){
    //     MyHashMap myHashMap = new MyHashMap();
    //     myHashMap.put(1, 1); // The map is now [[1,1]]
    //     myHashMap.put(2, 2); // The map is now [[1,1], [2,2]]  
    //     myHashMap.get(1);    // return 1, The map is now [[1,1], [2,2]]
        // myHashMap.get(3);    // return -1 (i.e., not found), The map is now [[1,1], [2,2]]
        // myHashMap.put(2, 1); // The map is now [[1,1], [2,1]] (i.e., update the existing value)
        // myHashMap.get(2);    // return 1, The map is now [[1,1], [2,1]]
        // myHashMap.remove(2); // remove the mapping for 2, The map is now [[1,1]]
        // myHashMap.get(2); 
    // }
}

