class MyHashMap {

    class Node{
        int key,value;
        Node next;
        public Node(int key, int value){
            this.key=key;
            this.value=value;
        }
    }

    Node[] storage;
    int buckets;

    private int getBucket(int key){
        //return Integer.hashCode(key) % buckets;
        // hashcode is inbuilt java method, it gives hash associated with a particular key
        //  hash of the correspinding parameter that we pass
        return key % buckets; 
    }

    private Node find(Node node, int key){
        Node prev=node;
        Node curr=node.next;
        while(curr!=null && curr.key!=key){
            prev=curr;
            curr=curr.next;
        }
        return prev;
    }

    public MyHashMap() {
        buckets=1000;
        storage= new Node[buckets];
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

    public static void main(String[] args) {
       MyHashMap hashmap = new MyHashMap();
        hashmap.put(1, 1); // [[1,1]]
        hashmap.put(2, 2); // [[1,1], [2,2]]
        System.out.println(hashmap.get(1));    // ans = 1
        System.out.println(hashmap.get(3));    // ans = -1 (not found)
        hashmap.put(2, 1); //  [[1,1], [2,1]] 
        System.out.println(hashmap.get(2));    // ans =  1
        hashmap.remove(2); 
        System.out.println(hashmap.get(2));    // ans =  -1 (not found)
    }
}
