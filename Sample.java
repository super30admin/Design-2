// Time Complexity :O(1) on average and O(n/1000) in the worst case per operation (up to 1000 keys per chain), 
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :NO


// Your code here along with comments explaining your approach
// I implemented the hash map using an array of 1000 buckets, where each bucket holds a linked list of nodes (separate chaining) to handle collisions.
// The bucket index is computed as key % 1000, so keys that map to the same index are stored in the same linked list.
// For put, I traverse the bucket's list to update the value if the key exists, otherwise I append a new node; get traverses the list and returns the value or -1; remove unlinks the node, updating the bucket head if the key is the first node.

class MyHashMap {
    class Node{
        int key;
        int value;
        Node next;
        public Node(int key,int value){
            this.key=key;
            this.value=value;
            this.next=null;
        }
    }
    Node[] arr;
    public MyHashMap() {
        this.arr=new Node[1000];
    }
    
    public void put(int key, int value) {
        int hash=key%1000;
        if(arr[hash]==null){
            Node newnode=new Node(key,value);
            arr[hash]=newnode;
        }
        else{
            Node curr=arr[hash];
            if(curr.key==key){
                curr.value=value;
                return ;
            }
            while(curr.next!=null && curr.next.key!=key){
                curr=curr.next;
            }
            if(curr.next!=null){
                curr.next.value=value;
            }
            else{
                Node newnode=new Node(key,value);
                curr.next=newnode;

            }
        }
        
    }
    
    public int get(int key) {
        int hash=key%1000;
        if(arr[hash]==null){
            return -1;
        }
        Node curr=arr[hash];
        while(curr!=null && curr.key!=key){
            curr=curr.next;
        }
        if(curr!=null){
            return curr.value;
        }
        return -1;
    }
    
    public void remove(int key) {
        int hash=key%1000;
        if(arr[hash]==null){
            return ;
        }
        Node curr=arr[hash];
        Node prev=null;
        if(curr.key==key){
            Node temp=curr.next;
            curr.next=null;
            arr[hash]=temp;
            return;
            
        }
        while(curr!=null && curr.key!=key ){
            prev=curr;
            curr=curr.next;

        }
        if(curr==null){
            return ;
        }
        prev.next=curr.next;
        curr.next=null;

    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */




// Time complexity: Push is O(1), pop and peek are amortized O(1) (O(n) in the worst case for a single call during a transfer).
// Space complexity is O(n).
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :NO

// I implemented the queue using two stacks: an in-stack that receives every pushed element, and an out-stack that serves pop and peek.
// When pop or peek is called and the out-stack is empty, I move all elements from the in-stack to the out-stack, which reverses their order so the oldest element ends up on top.
// The out-stack is only refilled when it becomes empty, so each element is moved at most once, and empty() returns true only when both stacks are empty.


class MyQueue {
    Stack<Integer> instack;
    Stack<Integer> outstack;
    public MyQueue() {
        this.instack=new Stack<>();
        this.outstack=new Stack<>();
    }
    
    public void push(int x) {
        instack.push(x);
    }
    
    public int pop() {
        if(instack.isEmpty() && outstack.isEmpty()){
            return -1;
        }
        if(outstack.isEmpty()){
            while(!instack.isEmpty()){
                int val=instack.pop();
                outstack.push(val);
            }
        }
        return outstack.pop();
    }
    
    public int peek() {
        if(instack.isEmpty() && outstack.isEmpty()){
            return -1;
        }
        if(outstack.isEmpty()){
            while(!instack.isEmpty()){
                int val=instack.pop();
                outstack.push(val);
            }
        }
        return outstack.peek();
    }
    
    public boolean empty() {
        return instack.isEmpty() && outstack.isEmpty();
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
