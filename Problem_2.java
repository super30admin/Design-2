// Time Complexity : o(1) as each linked list ina bucket will be 100 length,
// which is a small constant, so time complexity is also constant.
// Space Complexity : O(1) , constant number of buckets created, should know the data size from interviewer
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : for logistics of initializing new Node,
// Had to lookup video lecture little bit


class MyHashMap {

    class Node {
        int key;
        int value;
        Node next;
        
        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    Node[] storage;
    int buckets;

    public MyHashMap() {
        this.buckets = 10000;
        this.storage = new Node[buckets];
    }

    private int hash(int key) {
        return key%buckets;
    }
    
    private Node helper(Node head, int key) {
        Node prev = null;
        Node curr = head;
        while(curr!=null && curr.key!= key) {
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }

    public void put(int key, int value) {
        int bucket = hash(key);
        if(storage[bucket] == null) {
            storage[bucket] = new Node(-1, -1);
        }
        Node prev = helper(storage[bucket], key);

        if(prev.next == null) {
            prev.next = new Node(key, value);
        }
        else {
            prev.next.value = value;
        }
    }
    
    public int get(int key) {
        int bucket = hash(key);
        if(storage[bucket] == null) return -1;

        Node prev = helper(storage[bucket], key);
        if(prev.next == null) return -1;

        return prev.next.value;   
    }
    
    public void remove(int key) {
        int bucket = hash(key);
        if(storage[bucket] == null) return;

        Node prev = helper(storage[bucket], key);
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
