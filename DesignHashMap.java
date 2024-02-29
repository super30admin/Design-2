

class MyHashMap {

    int size = 10000;
    Node[] buckets; 

//Node storing key and value
    class Node{
        int key;
        int val;
        Node next;

        public Node(int key,int val ){
            this.val = val;
            this.key= key;
        }
    }

//getting the previous node
    public Node getPrevNode(int key, Node bucket){
        Node current = bucket;
        Node prev = null;

        while(current!=null && current.key!=key){
            prev = current;
            current = current.next;
        }

        return prev;
    }

    public MyHashMap() {
        buckets= new Node[10000];
    }

    public int  hash(int key){
        return key%10000;
    }
    
    public void put(int key, int value) {
        int bucket = hash(key);
        if(buckets[bucket]==null){
            buckets[bucket] = new Node(-1,-1);
        }
        Node prev = getPrevNode(key,buckets[bucket]);

        if(prev.next==null){
            //if its the tail node
           prev.next = new Node(key,value);
        }else{
            //existing node
            prev.next.val=value; 
        }
   
    }
    
    public int get(int key) {
        int bucket = hash(key);
        if(buckets[bucket]==null) return -1;
        Node prev = getPrevNode(key,buckets[bucket]);
        if(prev.next==null){
            return -1;
        }
        return prev.next.val;
        
    }
    
    public void remove(int key) {
        int bucket = hash(key);
        if(buckets[bucket]==null) return;
        Node prev = getPrevNode(key,buckets[bucket]);
        if(prev.next!=null){
            prev.next = prev.next.next;
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
