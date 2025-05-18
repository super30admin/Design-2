// Time Complexity : O(1) for push, pop and peek
// Space Complexity : O(n) for storing the nodes
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
class MyQueue {
    Stack newest, oldest;

    /** Initialize your data structure here. */
    public MyQueue() {
        newest = new Stack();
        oldest = new Stack();
    }

    public void shiftStack() {
        if (oldest.isEmpty()) {
            while (!newest.isEmpty()) {
                oldest.push(newest.pop());
            }
        }
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        newest.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        shiftStack();
        return oldest.pop();
    }

    /** Get the front element. */
    public int peek() {
        shiftStack();
        return oldest.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return oldest.isEmpty() && newest.isEmpty();
    }
}

// Time Complexity : O(1) for put, get and remove
// Space Complexity : O(n) for storing the nodes
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
class MyHashMap {
    ListNode[] nodes;

    /** Initialize your data structure here. */
    public MyHashMap() {
        nodes = new ListNode[10000];
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int i = idx(key);
        if (nodes[i] == null)
            nodes[i] = new ListNode(-1, -1);

        ListNode prev = nodeExists(nodes[i], key);
        if (prev.next == null)
            prev.next = new ListNode(key, value);
        else
            prev.next.val = value;
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map
     * contains no mapping for the key
     */
    public int get(int key) {
        int i = idx(key);
        if (nodes[i] == null)
            return -1;
        ListNode prev = nodeExists(nodes[i], key);
        if (prev.next == null)
            return -1;
        else
            return prev.next.val;
    }

    /**
     * Removes the mapping of the specified value key if this map contains a mapping
     * for the key
     */
    public void remove(int key) {
        int i = idx(key);

        if (nodes[i] == null)
            return;
        ListNode prev = nodeExists(nodes[i], key);

        if (prev.next == null)
            return;
        else
            prev.next = prev.next.next;
    }

    public ListNode nodeExists(ListNode bucket, int key) {
        ListNode node = bucket, prev = null;
        while (node != null && node.key != key) {
            prev = node;
            node = node.next;
        }
        return prev;
    }

    public int idx(int key) {
        return Integer.hashCode(key) % (nodes.length - 1);
    }
}

class ListNode {
    int key;
    int val;
    ListNode next;

    ListNode(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

public class Sample {
    public static void main(String[] args) {
        // Test MyQueue
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        System.out.println("Peek: " + queue.peek()); // Should print 1
        System.out.println("Pop: " + queue.pop()); // Should print 1
        System.out.println("Empty: " + queue.empty()); // Should print false

        // Test MyHashMap
        MyHashMap map = new MyHashMap();
        map.put(1, 1);
        map.put(2, 2);
        System.out.println("Get key 1: " + map.get(1)); // Should print 1
        System.out.println("Get key 3: " + map.get(3)); // Should print -1
        map.put(2, 1);
        System.out.println("Get key 2: " + map.get(2)); // Should print 1
        map.remove(2);
        System.out.println("Get key 2 after remove: " + map.get(2)); // Should print -1
    }
}