// Time Complexity : find, put, get, remove have O(k) where  is the  size of  the linkedlist
// Space Complexity : 
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
/*
 * We are using a pprimary array of Node of size 10000 so that to resolve collision we can initialize the  linkedlist of 100,
 * that way we reduce the traverse time. As all method finds a node, we define a general method to return the prev node,
 * which is before the node which we are looking for. If prev.next is null that means node is not present. 
 */
public class MyHashMap {
    class Node {
        int key, value;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    int buckets;
    Node[] storage;

    public MyHashMap() {
        this.buckets = 1000;
        this.storage = new Node[buckets];
    }

    private int getBucket(int key) {
        return Integer.hashCode(key) % buckets;
    }
    
    private Node find(Node node, int key) {
        Node prev = node;
        Node curr = node.next;
        while(curr != null && curr.key != key) {
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }

    public void put(int key, int value) {
        int bucket = getBucket(key);
        if(storage[bucket] == null) {
            storage[bucket] = new Node(-1, -1);
        }
        Node prev = find(storage[bucket], key);
        if(prev.next == null) {
            prev.next = new Node(key, value);
        }
        else {
            prev.next.value = value;
        }
    }
    
    public int get(int key) {
        int bucket = getBucket(key);
        if(storage[bucket] == null) {
            return -1;
        } 
        Node prev = find(storage[bucket], key);
        if(prev.next == null) {
            return -1;
        }
        return prev.next.value;
    }
    
    public void remove(int key) {
        int bucket = getBucket(key);
        if(storage[bucket] == null) {
            return;
        }
        Node prev = find(storage[bucket], key);
        if(prev.next == null) {
            return;
        }
        prev.next = prev.next.next;
    }
}
