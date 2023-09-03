class MyHashMap {
    class Node{
      int key;
      int value;
      Node next;
      public Node(int key, int value){
          this.key = key;
          this.value= value;
      }
    }
    Node[] storage;
    int buckets;

    public MyHashMap() {
        buckets = 10000;
        storage = new Node[buckets];
    }

    public int getbucket(int key){
        int bucket= key%buckets;
        return bucket;
    }
    
    Node find(Node dummy, int key){
        Node prev= dummy;
        Node curr= prev.next;
        while(curr!=null && curr.key !=key){
            prev=curr;
            curr=curr.next;
        }
        return prev;
    }
    public void put(int key, int value) {
        int bucket = getbucket(key);
        if(storage[bucket]==null){
            storage[bucket]= new Node(-1,-1);
        }
        Node prev = find(storage[bucket], key);
        if(prev.next==null){
            prev.next=new Node(key,value);
        }
        else{
            prev.next.value=value;
        }
    }
    
    public int get(int key) {
        int bucket = getbucket(key);
        if(storage[bucket]==null){
            return -1;
        }
        Node prev = find(storage[bucket], key);
        if(prev.next==null){
            return -1;
        }
        return prev.next.value;
        
    }
    
    public void remove(int key) {
        int bucket = getbucket(key);
        if(storage[bucket]==null){
            return;
        }
        Node prev = find(storage[bucket], key);
        if(prev.next==null){
            return;
        }
        else
        prev.next=prev.next.next;
    }
}
