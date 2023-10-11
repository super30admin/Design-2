// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

//Code for Implement Hashmap
//Time complexity -> o(1) for each operation
//Space Complexity -> o(1) for the storage
class MyHashMap {
    class Node{
        int key;
        int value;
        Node next;
        Node(int key,int value){
            this.key = key;
            this.value = value;
        }
    }

    int buckets;
    Node[] storage; //To store the array of linked lists

    public MyHashMap() {

        this.buckets = 1000;
        this.storage = new Node[this.buckets]; //Creating an array of storage of node type with null in each bucket
        
    }

    private int hash(int key){
        return key % this.buckets;
    }

    private Node find(int key,Node head){
        Node prev = null;
        Node curr = head;
        while(curr!=null && curr.key!=key){
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }
    
    public void put(int key, int value) {

        int bucket = hash(key); //calculate hash index of key
        if(storage[bucket] == null){
            storage[bucket] = new Node(-1,-1); //create a dummy node as head at that storage
        }
        Node prev = find(key,storage[bucket]);
        //if the value is not found
        if(prev.next==null){
            prev.next = new Node(key,value);
        }
        //if the value is already there then we can overwrite the value in the existing node
        else{
            prev.next.value = value;
        }
        
    }
    
    public int get(int key) {
        int bucket = hash(key); //calculate hash index of key
        if(storage[bucket]==null) return -1; //that means no value is there in the bucket hence return -1      
        Node prev = find(key,storage[bucket]);
        if(prev.next == null) return -1; //it means we were not able to find the value in the hashmap
        return prev.next.value;
        
    }
    
    public void remove(int key) {

        int bucket = hash(key); //calculate hash index of key
        if(storage[bucket]==null) return ; //that means no value is there in the bucket hence return -1      
        Node prev = find(key,storage[bucket]); //find the value which will be curr and then delink the value from the curr
        if(prev.next == null) return;
        prev.next = prev.next.next;
        
        
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */


//2nd Question
class MyQueue {

    Stack<Integer> in;
    Stack<Integer> out;

    public MyQueue() {
        in = new Stack();
        out = new Stack();
    }
    
    public void push(int x) { //Strictly o(1)

        in.push(x);
        
    }
    
    public int pop() { // Amortized O(1) which means if my out stack is empty we need to perform transfer of data from in to out which will be O(n). thats why Amortized O(1)
        if(out.isEmpty()){
            //I will be shifting my elements from in stack to out stack
            while(!in.isEmpty()){
                out.push(in.pop());
            }
        }

        return out.pop();
        
    }
    
    public int peek() { // Amortized O(1) which means if my out stack is empty we need to perform transfer of data from in to out which will be O(n). thats why Amortized O(1)

        if(out.isEmpty()){
            //I will be shifting my elements from in stack to out stack
            while(!in.isEmpty()){
                out.push(in.pop());
            }
        }

        return out.peek();
        
    }
    
    public boolean empty() { //Strictly O(1)

        return in.isEmpty() && out.isEmpty();
        
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
