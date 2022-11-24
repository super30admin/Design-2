// Time Complexity : O(1)
// Space Complexity : O(10000)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : the find function's tecnique was confusing at first. I needed to understand
//how to use the prev pointer


// Your code here along with comments explaining your approach
class MyHashMap {
    // We would use the linear chaining to resolve collisions
    // We will have a primary array, which would point to ll 
    // we we get a collision , we would add the colliding element to the ll

    // we need to choose an optimal bucket size,  since we will be using ll, the time to search element can be O(N)
    // the way to kind of optimiza (but not completely solve it , as its impossible), we can choose teh size of the bucket large
    // previosly we took sqrt of the limit , but we can do better , maybe choose sqrt * 10 , can give us a large bucket , we have to be carefull, to not choose too large


    // Important: we need to find the element before performing any operation. Its one of the core principles
    
    int bucketsize; 
    Node[] bucket;
// The constructor would only runs once , so we can ignore the time complexity 
    public MyHashMap() {
        bucketsize = 10000; // sqrt(1mil) * 10 // 1 mil is the limit
        bucket = new Node[bucketsize];

        // intializing with dummy value , its part of the find technique
        for(int index=0;index<bucketsize;index++){
            bucket[index] = new Node(-1,-1); 
        }
    }
    
    public void put(int key, int value) {
        Node prev = find(key);
        /*
    if prev.next == null, key not found ( null check)
    if prev.next.key == key, this means new value should be added at prev.next i.e at prev.next.val
        */
        if( prev.next == null){ // key not present and prev is pointing to the last element, so add the value after this
            prev.next = new Node(key,value);
        }else if(prev.next.key == key){ // key present at the next , so update its value
            prev.next.val = value;
        }
    }
    
    public int get(int key) {

        Node prev = find(key);
        if( prev.next == null){ // key not present and prev is pointing to the last element, so add the value after this
            return -1;
        }
         // key present at the next , so return its value its value
           return  prev.next.val;
    }
    
    public void remove(int key) {
        
        Node prev = find(key);
        if(prev.next == null){
            return;// key  not found
        }
        // removing the node
        prev.next = prev.next.next;
    }
    
    //  Node to store the elements
    class Node{
        int val;
        int key;
        Node next;
        public Node(int k ,int value){
            key = k;
            val = value;
            next =null;
        }
    }

    // need to find the element in the current array

    /* @param : int key 
    return value : prev pointer
    if prev.next == null, key not found ( null check)
    if prev.next.key == key, this means new value should be added at prev.next i.e at prev.next.val
    */
    private Node find(int key){     // important technique : current prev

        Node current = bucket[hash(key)];
        Node prev = null; 
        while(current!=null && current.key!=key){
            prev = current;
            current = current.next;
        }
        
        return prev;
    }

    private int hash(int key){
        return key % bucketsize;
    }


}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
