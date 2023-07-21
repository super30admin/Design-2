//Problem 1: Queue using Stack
// Time Complexity : O(n)
// Space Complexity : 2*O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no
class MyQueue {
    Stack<Integer> in; //stack for pushing nums
    Stack<Integer> out; // stack for pop operations
    public MyQueue() {
        in = new Stack<>();
        out= new Stack<>();
    }
    
    public void push(int x) {
        in.push(x);
    }
    
    public int pop() {
        peek(); // perform all operations of peek and then pop from out stack
        return out.pop();
    }
    
    public int peek() { 
        if(out.isEmpty()) //if out is empty -> empty in stack into out stack
            while(!in.isEmpty())
                out.push(in.pop());
        return out.peek(); //if not empty, just show peek
    }
    
    public boolean empty() { // only when both stacks are empty, our queue is empty
        return in.isEmpty() && out.isEmpty();
    }
}

// Your code here along with comments explaining your approach

//Problem 2: Design HashMap
// Time Complexity : for search->O(1) for put->O(n) in worst case
// Space Complexity : O(n) for storing key value pairs
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
class MyHashMap {
    class Node{
        int value;
        int key;
        Node next;
       public Node(int key, int val){
           this.value=val;
           this.key=key;
       }
    }
    Node[] storage; //used to store all nodes ->kind of hashmap
    int len;
    public MyHashMap() {
        this.len=10000;
        this.storage=new Node[len];
    }

    private int hashIdx(int key){
        return key%len; // custom hashFunction.
    }
    //find is designed in a way to give previous node of the node we are trying to find.
    public Node find(Node head, int key){
        Node prev=null;
        Node curr=head;
        while(curr !=null && curr.key!=key){ // move untill we find key
            prev=curr;
            curr=curr.next;
        }
        return prev; //return element just behind 
    }
    
    public void put(int key, int value) {
        int idx= hashIdx(key);
        if(storage[idx]==null) //if null, put a new node with key value pairs
            storage[idx]= new Node(-1,-1);
        Node prev= find(storage[idx],key); //find function that finds the node and returns
        if(prev.next==null)
            prev.next=new Node(key,value); //if no node, then put a new node.
        else
            prev.next.value=value; // if node already exists, then overwrite value.
    }
    
    public int get(int key) {
        int idx=hashIdx(key);
        if(storage[idx]==null) return -1;
        Node prev= find(storage[idx],key); //first find.
        if(prev.next==null) return -1; //if not found -> return -1
        return prev.next.value; //else return next value
    }
    
    public void remove(int key) {
        int idx=hashIdx(key);
        if(storage[idx]==null) return;
        Node prev= find(storage[idx],key);
        if(prev.next==null) return;
        prev.next=prev.next.next; //if u get the node, remove that node link. 
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */