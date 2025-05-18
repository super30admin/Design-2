// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
//HASHMAP using Linear Hashing
class MyHashMap {
    class Node {
        int key;
        int value;
        Node next;
        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    private Node [] storage;
    private int buckets;

    public int hash(int key){ return key%buckets;}

    public MyHashMap() {
        this.buckets = 10000;
        this.storage = new Node[buckets];
    }
    private Node helper(Node head, int key) // to give the previous node
    {
        Node prev = head;
        Node curr = head.next;
        while(curr != null && curr.key != key)
        {
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }
    public void put(int key, int value) { // O(1)
        int idx = hash(key);
        if(storage[idx] == null){
            storage[idx] = new Node(-1,-1);
        }
        Node prev = helper(storage[idx],key);
        if(prev.next == null)
        {
            prev.next = new Node(key,value);;
        }
        else{
            prev.next.value = value;
        }

    }

    public int get(int key) { //O(1)
        int idx = hash(key);
        if(storage[idx] == null) return -1;
        Node prev = helper(storage[idx], key);
        if(prev.next == null) return -1;
        return prev.next.value;
    }

    public void remove(int key) { //O(1)
        int idx = hash(key);
        if(storage[idx]==null) return;
        Node prev = helper(storage[idx],key);
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

// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes

// Implement Queue using stacks
class MyQueue {
    private Stack<Integer> in;
    private Stack<Integer> out;

    public MyQueue() {
        this.in = new Stack<>();
        this.out = new Stack<>();
    }

    public void push(int x) { //O(1)
        in.push(x);
    }

    public int pop() { //O(1)
        if(out.isEmpty())
        {
            while(!in.isEmpty())
            {
                out.push(in.pop());
            }
        }
        return out.pop();
    }

    public int peek() { //O(1)
        if(out.isEmpty())
        {
            while(!in.isEmpty())
            {
                out.push(in.pop());
            }
        }
        return out.peek();
    }

    public boolean empty() { // counter O(1)
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