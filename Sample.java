// Time Complexity: O(1)
// Space Complexity: O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class MyHashMap {

    //This is class node.
        class Node {
            int key;
            int val;
            Node next;
    
            public Node(int key, int val){
                this.key = key;
                this.val = val;
            }
        }
    
        //This is for the primary array.
        Node[] storage;
    
        private int hash(int key){
            return key%10000;
        }
    
        public MyHashMap() {
            this.storage = new Node[10000];
        }
        
        private Node find(Node node, int key){
            Node previous = null;
            Node current = node;
            while(current != null && current.key != key){
                previous = current;
                current = current.next;
            }
            return previous;
        }
    
        public void put(int key, int value) {
            int hash = hash(key);
            if(storage[hash] == null)
            {
                storage[hash] = new Node(-1, -1);
            }
            Node previous = find(storage[hash], key);
            if(previous.next == null){
                previous.next = new Node(key, value);
            }
            else{
                previous.next.val = value;
            }
        }
        
        public int get(int key) {
            int hash = hash(key);
            if(storage[hash] == null){
                return -1;
            }
            Node previous = find(storage[hash], key);
            if(previous.next == null){
                return -1;
            }
            return previous.next.val;
        }
        
        public void remove(int key) {
            int hash = hash(key);
            if(storage[hash] == null){
                return;
            }
            Node previous = find(storage[hash], key);
            if(previous.next == null){
                return;
            }
            previous.next = previous.next.next;
        }
    }
    
// Time Complexity: O(n)
// Space Complexity: O(2n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes, it was an easy question but I got confused at some point before I understood it.

class MyQueue {
    Stack<Integer> in;
    Stack<Integer> out;
    

    public MyQueue() {
        this.in = new Stack<>();
        this.out = new Stack<>();
    }
    
    public void push(int x) {
        in.push(x);
    }
    
    public int pop() {
        if(out.isEmpty()){
            while(!in.isEmpty()){
                out.push(in.pop());
            }
        }
        return out.pop();
    }
    
    public int peek() {
        if(out.isEmpty()){
            while(!in.isEmpty()){
                out.push(in.pop());
            }
        }
        return out.peek();
    }
    
    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
    }
}

