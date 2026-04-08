// Time Complexity : All Functions - put and remove - O(n) where n is the number of elements in the bucket, get - O(n) where n is the number of elements in the bucket
// Space Complexity : O(n) where n is the number of key-value pairs in the hash map
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach : 
// I followed the same approach which I did for hashset
// Used a Linked List to handle the collision and used a prime number as the size of the hash map to reduce the collision.
// Here instead of just key we have key-value pair, so I created a class Entry to store the key-value pair and used the same approach as hashset to handle the collision.
// We will use the hash function to get the bucket index and then we will check if the key already exists in the bucket, if it does then we will update the value, if it does not then we will add a new entry to the bucket. 
// For get and remove we will use the same approach to find the entry in the bucket and return the value or remove the entry from the bucket.


import java.util.*;

class MyHashMap {

    class Entry {
        public int key;
        public int val;

        public Entry(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    LinkedList<Entry>[] map;
    public static int size = 769;

    public MyHashMap() {
        map = new LinkedList[size];
    }

    public void put(int key, int value) {
        int bucket = key % size;

        if (map[bucket] == null) {
            map[bucket] = new LinkedList<>();
        }
        for (Entry e : map[bucket]) {
            if (e.key == key) {
                e.val = value;
                return;
            }
        }
        map[bucket].add(new Entry(key, value));
    }

    public int get(int key) {
        int bucket = key % size;

        if (map[bucket] != null) {
            for (Entry e : map[bucket]) {
                if (e.key == key) {
                    return e.val;
                }
            }
        }

        return -1; 
    }

    public void remove(int key) {
        int bucket = key % size;

        if (map[bucket] != null) {
            Entry toRemove = null;

            for (Entry e : map[bucket]) {
                if (e.key == key) {
                    toRemove = e;
                    break;
                }
            }

            if (toRemove != null) {
                map[bucket].remove(toRemove);
            }
        }
    }
}