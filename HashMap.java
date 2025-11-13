// Time Complexity : O(1) for all operations
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// 1: An array of Nodes is set up to hold the input
// 2: We use linear chaining in this example to avoid collision
// 3: We store reference to the second last element in the iteration to be able to add and remove links efficiently

class MyHashMap {

    class Node{
        int key;
        int val;
        Node next;

        public Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }
    private Node[] storage;
    int size = 10000;
    private int hash(int key){
        return key % size;
    }
    public MyHashMap() {
        this.storage = new Node[size];
    }

    private Node find(Node head, int key){
        Node prev = null;
        Node curr = head;
        while(curr != null && curr.key != key){
            prev = curr;
            curr = curr.next;
        };
        return prev;
    }

    public void put(int key, int value) {
        int index = hash(key);
        if(storage[index] == null){
            storage[index] = new Node(-1, -1);
        }
        Node prevEle = find(storage[index], key);
        if(prevEle.next == null){
            prevEle.next = new Node(key, value);
        }
        else{
            prevEle.next.val = value;
        }
    }

    public int get(int key) {
        int index = hash(key);
        if(storage[index] == null){
            return -1;
        }
        Node prevEle = find(storage[index], key);
        if(prevEle.next == null) return -1;
        else return prevEle.next.val;
    }

    public void remove(int key) {
        int index = hash(key);
        if(storage[index] == null) return;
        Node prevEle = find(storage[index], key);
        if(prevEle.next == null) return;
        else {
            prevEle.next = prevEle.next.next;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */