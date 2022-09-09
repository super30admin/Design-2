// Time complexity : O(1) for all the operations

//for find its  constant time as we are traversing over 100 nodes 

class MyHashMap {

    class Node{
        int key,value;
        Node next;
        public Node(int key, int value){
            this.key = key;
            this.value= value;
        }
    }
    Node[] nodes;
    private int buckets;
    
    private int getBucket(int key){
        // automatically computes hashcode for key 
        
        return Integer.hashCode(key) % buckets;
    }
    public MyHashMap() {
        buckets = 10000;
        nodes = new Node[buckets];
    }
    
    private Node find(Node node, int key){
        Node prev = node;
        Node curr= node.next;
        while(curr!=null && curr.key !=key){
            prev= curr;
            curr= curr.next;
        }
        return prev;
    }
    
    public void put(int key, int value) {
        int bucket = getBucket(key);
        // linked list does not exist
        if(nodes[bucket]== null){
            // create a dummy node 
            nodes[bucket]= new Node(-1,-1);
            
        }
        //find node
        Node prev = find(nodes[bucket],key);
        //the key does not exist
        if(prev.next == null){
            prev.next = new Node(key,value);
        }// key exists
        else{
            prev.next.value = value;
        }
    }
    
    public int get(int key) {
        
        int bucket = getBucket(key);
        if(nodes[bucket]== null){
            return -1;
        }
          //find node
        Node prev = find(nodes[bucket],key);
           if(prev.next == null){
                return -1;
        }// key exists
        return prev.next.value;
    }
    
    public void remove(int key) {
        int bucket = getBucket(key);
        //key does not exist
         if(nodes[bucket]== null){
            return;
        }
        //key might exist
        Node prev = find(nodes[bucket],key);
        // node does not exist
        if(prev.next==null){
            return ;
        }
        //node exists
        prev.next= prev.next.next;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */