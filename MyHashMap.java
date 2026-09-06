// Time Complexity : Amortized time complexity for operations - put, get, remove is O(1).
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class MyHashMap {
    class Node{
        int key;
        int value;
        Node next;
        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    private Node [] storage;
    private int hash(int key){
        return key % 10000;
    }

    public MyHashMap() {
        this.storage = new Node[10000];
    }

    private Node find(Node head, int key){
        Node previous = head;
        Node current = head.next;
        while(current!=null && current.key != key){
            previous = current;
            current = current.next;
        }
        return previous;
    }

    public void put(int key, int value) {
        int itemIndex = hash(key);
        if(storage[itemIndex] == null){
            storage[itemIndex] = new Node(-1,-1);
        }
        Node previous = find(storage[itemIndex], key);
        if(previous.next == null){
            previous.next = new Node(key, value);
        } else{
            previous.next.value = value;
        }
    }

    public int get(int key) {
        int itemIndex = hash(key);
        if(storage[itemIndex] == null){
            return -1;
        }
        Node previous = find(storage[itemIndex], key);
        if(previous.next == null){
            return -1;
        }
        return previous.next.value;
    }

    public void remove(int key) {
        int itemIndex = hash(key);
        if(storage[itemIndex] == null){
            return;
        }
        Node previous = find(storage[itemIndex], key);
        if(previous.next == null){
            return;
        }
        Node temp = previous.next;
        previous.next = temp.next;
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