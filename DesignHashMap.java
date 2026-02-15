// Time Complexity : O(1)
// Space Complexity : O(n) where n is number of key value pairs (O(n+k), but k is 1000 buckets - O(1))
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
/*
maintain an array of linked list.For any inout, get the hash to check if it has previous occurence or not.
If it has, fetch the corresponding previous node to put/remove/access the next node. If not, create a new
node along with creation of dummy node first for easier access.
 */

class MyHashMap {
    Node[] storage;
    int buckets;

    class Node {
        int key;
        int value;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public MyHashMap() {
        this.buckets = 1000;
        this.storage = new Node[buckets];
    }

    private int getHash(int key) {
        return key % buckets;
    }

    private Node getPrev(Node head, int key) {
        Node prev = null;
        Node curr = head;
        while(curr != null && curr.key != key) {
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }

    public void put(int key, int value) {
        int index = getHash(key);
        if(storage[index] == null) {
            storage[index] = new Node(-1, -1);
            storage[index].next = new Node(key, value);
            return;
        }
        Node prev = getPrev(storage[index], key);
        if(prev.next == null)
            prev.next = new Node(key, value);
        else
            prev.next.value = value;
    }

    public int get(int key) {
        int index = getHash(key);
        if(storage[index] == null)
            return -1;
        Node prev = getPrev(storage[index], key);
        if(prev.next == null)
            return -1;
        return prev.next.value;
    }

    public void remove(int key) {
        int index = getHash(key);
        if(storage[index] == null) {
            return;
        }
        Node prev = getPrev(storage[index] , key);
        if(prev.next == null)
            return;
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