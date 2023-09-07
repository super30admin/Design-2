/* Time Complexity: O(n)
   Space Complexity: O(1)
   */
class MyHashMap {
    class Node{
        int key, value;
        Node next;
        public Node(int key, int value){
            this.key=key;
            this.value=value;
        }
    }
    
    Node find(Node dummy, int key){
        Node prev=dummy;
        Node curr=dummy.next;
        while(curr!=null && curr.key!=key){
            prev=curr;
            curr=curr.next;
        }
        return prev;
    }
    int buckets;
    Node[] storage;

    int getBucket(int key){
        return key % buckets;
    }

    public MyHashMap() {
        buckets=1000;
        storage=new Node[buckets];
    }
    
    public void put(int key, int value) {
        int bucket=getBucket(key);
        if(storage[bucket]==null){
            storage[bucket]=new Node(-1,-1);
        }
        Node prev=find(storage[bucket],key); 
        if(prev.next==null){
            prev.next=new Node(key,value);
        }        
        else{
            prev.next.value=value;
        }
    }
    
    public int get(int key) {
        int bucket=getBucket(key);
        if(storage[bucket]==null){
            return -1;
        }
        Node prev=find(storage[bucket],key);
         if(prev.next==null){
             return -1;
         }
         return prev.next.value;
    }
    
    public void remove(int key) {
        int bucket=getBucket(key);
        if(storage[bucket]==null){
            return;
        }
        Node prev=find(storage[bucket],key);
        if(prev.next==null){
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
