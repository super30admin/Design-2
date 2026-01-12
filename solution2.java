// Time Complexity :
// put(key, value)    -> Average: O(1), Worst: O(n) (if many keys fall in same bucket)
// get(key)           -> Average: O(1), Worst: O(n)
// remove(key)        -> Average: O(1), Worst: O(n)
// (n = number of nodes in that bucket)
//
// Space Complexity :
// O(N + B) where N = total pairs stored, B = number of buckets
//
// Did this code successfully run on Leetcode :
// Yes
//
// Any problem you faced while coding this :
// No major issues. Just need to handle collisions using a LinkedList,
// and update value if key already exists.


// Your code here along with comments explaining your approach

import java.util.LinkedList;

class MyHashMap {

    // total buckets size
    int parentbuckets;

    // each index has a linkedlist of nodes (to handle collisions)
    LinkedList<Node>[] storage;

    // simple node class to store key-value
    static class Node {
        int key;
        int value;
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public MyHashMap() {
        this.parentbuckets = 1000;
        storage = new LinkedList[parentbuckets];
    }

    // hash function to find bucket index
    private int getPrimaryHash(int key) {
        return Math.floorMod(key, parentbuckets);
    }

    public void put(int key, int value) {
        int index = getPrimaryHash(key);

        // if bucket not created, create it
        if (storage[index] == null) {
            storage[index] = new LinkedList<>();
        }

        // check if key already exists -> update
        for (Node n : storage[index]) {
            if (n.key == key) {
                n.value = value;
                return;
            }
        }

        // if key not found, add new node
        storage[index].add(new Node(key, value));
    }

    public int get(int key) {
        int index = getPrimaryHash(key);

        // if bucket empty, key not present
        if (storage[index] == null) return -1;

        // search in that bucket
        for (Node n : storage[index]) {
            if (n.key == key) return n.value;
        }

        return -1;
    }

    public void remove(int key) {
        int index = getPrimaryHash(key);

        // if bucket doesn't exist, nothing to remove
        if (storage[index] == null) return;

        // find and remove the node
        for (Node n : storage[index]) {
            if (n.key == key) {
                storage[index].remove(n);
                break;
            }
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
