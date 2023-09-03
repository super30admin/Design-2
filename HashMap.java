
// Time complexity : put(), get(), remove()--> O(1) for all the operations
  // worst case its O(n)-. where n is number of nodes in linked list --> and n is 100
//for find its  constant time as we are traversing over 100 nodes only 
// sucessfully submitted on leetcode

class MyHashMap {

    int buckets;
    Node[] nodes;
    class Node{
    int key, value;
    Node next;
    Node(int key,int value){
        this.key= key;
        this.value= value;
    }
    }
   public  MyHashMap() {
        this.buckets=10000;
        nodes = new Node[buckets];
    }
    
    public int getBucket(int key){
        return Integer.hashCode(key)% buckets;
    }

    // node here is dummy 
    public Node find(Node node,int key){
        Node prev=node;
        Node curr=prev.next;
        while(curr!=null && curr.key!=key){
            prev= curr;
            curr=curr.next;
        }
        return prev; // it will reach the last node
    }
    public void put(int key, int value) {
        int bucket= getBucket(key);
        //check if in nodes array at that bucket , linked list does not exist   
        if(nodes[bucket]==null){
             // create a dummy node
            nodes[bucket]= new Node(-1,-1);
         //   nodes[bucket]= new Node(key,value);
        }
        else{
            // find the key in linked list 
            Node prev= find(nodes[bucket],key);
            // if key does not exist, then prev.next will be null- last node 
            if(prev.next==null){
                 // create a new node 
                 Node node= new Node(key,value);
                 //attach to prev
                 prev.next= node;
            }
            //keys exists, so update the value
            prev.next.value=value;
        
        }
        
    
    }
    
    public int get(int key) {
        // get index in primary array 
        int bucket= getBucket(key);
        //linked list does not exist
        if(nodes[bucket]==null) {
            return -1;
        }
        
        //linked list exists
      
            // find the key
            Node prev= find(nodes[bucket],key);
            if(prev.next==null){
                return -1;
            }
            return prev.next.value;
           
    }
    
    public void remove(int key) {
        int bucket= getBucket(key);
        if(nodes[bucket]== null) return;
        else{
            Node prev= find(nodes[bucket],key);
            if(prev.next==null) return;
            else{
                prev.next = prev.next.next;
               
            }
        }
    }
}