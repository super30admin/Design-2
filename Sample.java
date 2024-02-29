// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class MyQueue {
    private Stack<Integer> inStack;
    private Stack<Integer> outStack;

    public MyQueue() {
        this.inStack = new Stack<>();
        this.outStack = new Stack<>();
    }
    
    public void push(int x) {
        inStack.push(x);
    }
    
    public int pop() {
        peek();
        return outStack.pop();
    }
    
    public int peek() {
        if(outStack.isEmpty()) {
            while(!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
        return outStack.peek();
    }
    
    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
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

// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class MyHashMap {

    class Node {
        int key;
        int value;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    Node[] storage;

    public MyHashMap() {
        this.storage = new Node[10000];
    }

    private int hash(int key) {
        return key%10000;
    }

    private Node search(Node head, int key) {
        Node prev = null;
        Node curr = head;

        while (curr!=null && curr.key!=key) {
            prev = curr;
            curr= curr.next;
        }

        return prev;
    }
    
    public void put(int key, int value) {
        int idx = hash(key);

        if(storage[idx] == null) {
            storage[idx] = new Node(-1,-1);
        }

        Node prev = search(storage[idx], key);

        if(prev.next != null) {
            prev.next.value = value;
        } 
        else {
            prev.next = new Node(key, value);
        }
    }
    
    public int get(int key) {
        int idx = hash(key);

        if(storage[idx] == null) {
            return -1;
        }

        Node prev = search(storage[idx], key);

        if(prev.next == null) return -1;
        return prev.next.value;
    }
    
    public void remove(int key) {
        int idx = hash(key);

        if(storage[idx] == null) {
            return;
        }

        Node prev = search(storage[idx], key);
        if(prev.next == null) return;
        Node temp = prev.next;
        prev.next = prev.next.next;
        temp.next = null;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */