//Solved using double hashing and separate chaining
/* using separate chaining used linkedlist
/1.Adding node when needed. Used dummy node as head node.
2. Always checking if node exists */
class MyHashMap {
    class Node{
        int key,value;  //data
        Node next;
        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    int bucket;
    Node[] storage;
    public int getBucket(int key){
        return Integer.hashCode(key)%(this.bucket);
    }
    public Node find(Node dummy, int key){
        Node prev = dummy;
        Node curr = dummy.next;

        while(curr!=null && curr.key!=key){
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }
    public MyHashMap() {
        this.bucket =1000;
        storage = new Node[this.bucket];
    }
    public void put(int key, int value) {
        int bucket = getBucket(key);
        if(storage[bucket]==null){
            storage[bucket] = new Node(-1,-1);
        }
        Node prev = find(storage[bucket],key);
        if(prev.next!=null){
            prev.next.value = value;  //overwrite
        }else{
            prev.next = new Node(key,value); //new insertion
        }
    }
    
    public int get(int key) {
        int bucket = getBucket(key);
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
        int bucket = getBucket(key);
        if(storage[bucket]==null){
            return;
        }
        Node prev = find(storage[bucket], key);
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
/*Done same problem using double hashing
1.Filling array with -1 to avoid default 0 value case*/ 
 class MyHashMap {
    int buckets;
    int bucketSize;
    int[][]storage;
    public MyHashMap() {
        this.buckets=0;
        this.bucketSize=0;
        storage = new int[1000][];
    }
    int getBucket(int key){
        return key%1000;
    }
    int getBucketize(int key){
        return key/1000;
    }
    public void put(int key, int value) {
        buckets= getBucket(key);
        bucketSize = getBucketize(key);
        if(storage[buckets] ==null){
            if(buckets==0){
                storage[buckets] = new int[1001];
            }else{
                storage[buckets] = new int[1000];
            }
            Arrays.fill(storage[buckets],-1);
        }
        storage[buckets][bucketSize] = value;
    }
    
    public int get(int key) {
        buckets= getBucket(key);
        bucketSize = getBucketize(key);
        if(storage[buckets] ==null){
            return -1;
        }
        else{
            if(storage[buckets][bucketSize]==-1){
                return -1;
            }
            return storage[buckets][bucketSize];
        }
    }
    
    public void remove(int key) {
        buckets= getBucket(key);
        bucketSize = getBucketize(key);
        if(storage[buckets]!=null){
            storage[buckets][bucketSize]=-1;
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