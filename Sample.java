// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach


// Implementing Queue using two stacks 

// create two stack one for reversing the order of elements when pushing and another for popping elements 
class MyQueue {

   private Stack<Integer> in;
   private Stack<Integer> out;

    public MyQueue() {
        this.in = new Stack<>();
        this.out = new Stack<>();
    }
    
    public void push(int x) {
        
        in.push(x);  //O(1)
    }
    
    public int pop() {
        if(out.isEmpty()){
            while(!in.isEmpty()){
                out.push(in.pop());
            }
        }

        return out.pop();  //O(1) amortized
    }
    
    public int peek() {
        
        if(out.isEmpty()){
            while(!in.isEmpty()){
                out.push(in.pop());
            }
        }

        return out.peek(); //O(1) amortized
    }
    
    public boolean empty() {
        
        return in.isEmpty() && out.isEmpty();  //O(1)
    }
}

//Implement HashMap using Linear Probing/Chaining

class MyHashMap {

    class Node{
       
       int key; int val;
       Node next;

       public Node(int key, int val){
             this.key = key;
             this.val = val;
       }
    }

    private int buckets;
    private Node [] storage; 

    private int hash(int key){
        return key%buckets;
    }

    public MyHashMap() {
        this.buckets = 10000;
        this.storage = new Node[buckets];
    }

    private Node helper(Node head, int key){
        Node prev = head;
        Node curr = prev.next;

        while(curr != null && curr.key != key){
            prev = curr;
            curr = curr.next;
        }

        return prev;
    }
    
    public void put(int key, int value) {
        
        int bucket = hash(key);
        if(storage[bucket] == null){
            storage[bucket] = new Node(-1, -1);
        }

        Node prev = helper(storage[bucket], key);

        if(prev.next  == null){
            prev.next = new Node(key, value);
        }
        else{
            prev.next.val =  value;
        }
    }
    
    public int get(int key) {
        int bucket = hash(key);
        if(storage[bucket] == null){
            return -1;
        }

        Node prev = helper(storage[bucket], key);

        if(prev.next  == null){
            return -1;
        }
        else{
           return  prev.next.val;
        }
    }
    
    public void remove(int key) {
         int bucket = hash(key);
        if(storage[bucket] == null) return;

        Node prev = helper(storage[bucket], key);

        if(prev.next  == null){
            return;
        }
        else{
           Node curr = prev.next;
           prev.next = curr.next;
           curr.next = null;
        }

    }
}