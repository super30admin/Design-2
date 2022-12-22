// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class MyHashMap {
    class Node{
        int key; int val;
        Node next;
        private Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }
    private Node[] storage;
    private int Primary;
    public MyHashMap() {
        this.Primary = 10000;
        this.storage = new Node[this.Primary];
    }
    private int hash1(int key){
        return key%10000;
    }

    private Node find(Node head, int key){
        Node curr = head;
        Node prev = null;
        //traverse the list until we reach end i.e. current is null or till we match the key
        while(curr != null && curr.key != key){
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }

    public void put(int key, int value) {
        int bucketNo = hash1(key);
        //check if the bucket is present else create dummy node at the start
        if(storage[bucketNo] == null){
            storage[bucketNo] = new Node(-1,-1);
        }
        Node prev = find(storage[bucketNo], key);
        //if we reach at the end, create new node or else update the existing value of the already prsent node
        if(prev.next == null){
            prev.next = new Node(key, value);
        }else{
            prev.next.val = value;
        }
    }
    
    public int get(int key) {
        int bucketNo = hash1(key);
        if(storage[bucketNo] == null) return -1;
        Node prev = find(storage[bucketNo], key);
        if(prev.next == null) return -1;
        return prev.next.val;
        }
    
    public void remove(int key) {
        int bucketNo = hash1(key);
        if(storage[bucketNo] == null) return;
        Node prev = find(storage[bucketNo], key);
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

 // Time Complexity : amortized O(1) for pop and O(1) for push
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class MyQueue {
    Stack <Integer> in;
    Stack <Integer> out;
    public MyQueue() {
        this.in = new Stack<>();
        this.out = new Stack<>();
    }
    
    public void push(int x) {
        //o(1)
        in.push(x);
    }
    
    public int pop() {
        //maintaining modularity by calling peek function logic
        peek();
        //O(n) for first element in queue and O(1) for rest of the elements
        return out.pop();
    }
    
    public int peek() {
        //push all the elements from in stack to out if out is empty
        //return top of the out stack
        if(out.isEmpty()){
            while(!in.isEmpty()){
                out.push(in.pop());
            }
        } return out.peek();
    }
    
    public boolean empty() {
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