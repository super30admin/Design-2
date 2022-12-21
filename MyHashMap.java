
public class MyHashMap {
    
    private class Node{
        int key, value;
        Node next; // next is the field of Node that is being created
        Node(int key, int value){
            this.key=key;
            this.value=value;
            this.next=null; // anyway by default it is null
        }
    }
    
    private static final int Num_Buckets= 10000;  // final so that value doesnt change. static because we don't want it to be created as an instance variable. We just wanna create it once and be applied to all objects.
    
    private Node[] buckets; // creating an array of class Node with name buckets

    public MyHashMap() {
        buckets= new Node[Num_Buckets];
    }
    
    private int getHash(int key){
        return key%Num_Buckets;
    }
    
    private Node findPrev(int key){  // we r gonna use this method in all others by reusing the code
        int hash= getHash(key);
        if(buckets[hash]==null){ // if the index is not initiated
            return null;
        }
        Node prev= buckets[hash];   // we r pointing our previous pointer to the dummy node
        Node curr= prev.next; // our current pointer to the first actual node
        
        // now locating the node
        while(curr!=null && curr.key!= key){  // iterating from the first node to the one that we r looking for i.e required key and until we r reaching null
            prev=curr;
            curr=curr.next;
        }
        return prev;
    }
    
    public void put(int key, int value) {
        Node prev= findPrev(key);
        
        if(prev==null){
            int hash= getHash(key);
            buckets[hash]= new Node(-1,-1); // creating a dummy node
            prev=buckets[hash];
        }
        
        // check if it exists already
        if(prev.next!=null){
            prev.next.value=value;
        }
        else{ // if not create a new node
            prev.next= new Node(key, value);
        }
        
    }
    
    public int get(int key) {
        Node prev= findPrev(key);
        
        if(prev== null || prev.next== null){ // if the index of array is not inititated or if we have reached the last node and not found the key
            return -1;
        }
        return prev.next.value;
    }
    
    public void remove(int key) {
        Node prev= findPrev(key);
        if(prev==null || prev.next==null){  // if not initiated or have reached the last node
            return;
        }
        prev.next=prev.next.next;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */