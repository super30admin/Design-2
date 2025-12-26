//Here we are using linear chaining to implement hashmap
//we are initiating a linked list to an array to performput,get and remove functions
//we have created a find function to traverse through linked list and using that function in put, get and remove

class MyHashMap {
    class Node{
        int key;
        int value;
        Node next;

        public Node(int key,int value){
            this.key=key;
            this.value=value;
        }
    }
    private Node []storage;
    private int buckets;
   
    private int hash(int key){
        return key%buckets;
    }

    public MyHashMap() {
        this.buckets=1000;
        this.storage=new Node[buckets];
    }

    private Node find(Node head,int key){
        Node prev=head;//we have a dummy node
        Node curr=head.next;
        while(curr!=null && curr.key!=key){
            prev=curr;
            curr=curr.next;
        }
        return prev;
    }
    
    public void put(int key, int value) {
        int idx= hash(key);
        if(storage[idx]==null){
            storage[idx]= new Node(-1,-1);
        }
            Node prev= find(storage[idx],key);
            //if current key is not there in list
            if(prev.next==null){
                Node new_node= new Node(key,value);
                prev.next=new_node;
            }
            else{
                //if current key is not there in list
                prev.next.value=value;
            }
        
    }
    
    public int get(int key) {
        int idx= hash(key);
        if(storage[idx]==null){
            return -1;
        }
        Node prev= find(storage[idx],key);
        if(prev.next==null) return -1;
        return prev.next.value;
        
    }
    
    public void remove(int key) {
         int idx= hash(key);
        if(storage[idx]==null){
            return ;
        }
        Node prev= find(storage[idx],key);
        if(prev.next==null) return;
        Node temp= prev.next;
        prev.next=prev.next.next;
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