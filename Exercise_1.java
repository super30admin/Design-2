// Design HashMap
// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : having confusion in space complexity


// Approach
// Will use Linkedlist and linear chaining. Create a hash() & find() to keep track of prev.
// then in all put, find remove we will have 3 conditions. 1)If LL is present no not.
// 2) if prev node found and we are at the last node. 3) if prev node found and next node is also exist.


class MyHashMap {
    class Node {
        int key;
        int val;
        Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    private Node[] storage;
    private int buckets;

    public MyHashMap() {
        this.buckets = 10000;
        this.storage = new Node[this.buckets];
    }

    //my hash function
    private int hash(int key) {
        return key%this.buckets;
    }


    //gives prev node as output
    private Node find(Node head, int key) {
        Node curr = head;
        Node prev = null;
        while(curr != null && curr.key != key) {
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }


    public void put(int key, int value) {
        int bucket = hash(key); //hash function
        if(storage[bucket] == null) {
            storage[bucket] = new Node(-1, -1); //if null, insert a dummy node
        }
        //2 scenarios
        Node prev = find(storage[bucket], key);
        if(prev.next == null) {
            //we are at the end and node is not exist in linkedlist
            prev.next = new Node(key, value); //put a fresh node
        }
        else {
            //if key is already exist, update its respective value
            prev.next.val = value;
        }
    }


    public int get(int key) {
        int bucket = hash(key);
        //no linkedlist node present
        if(storage[bucket] == null) return -1;

        Node prev = find(storage[bucket], key);
        if(prev.next == null) return -1;   //last node

        return prev.next.val;
    }


    public void remove(int key) {
        int bucket = hash(key);
        //no linkedlist node present
        if(storage[bucket] == null) return;

        Node prev = find(storage[bucket], key);
        if(prev.next == null) return;  //last node

        //assign the next to current
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