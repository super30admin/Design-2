/*
I use an array of buckets where each bucket stores a linked list to handle hash collisions using separate chaining.
The key is mapped to a bucket index using a hash function (key % size), and all operations traverse only that bucket.
This gives average O(1) time for add, remove, and contains, with O(n) worst case if many keys collide.
Time Complexity (average):
  add:      O(1)
  remove:   O(1)
  contains: O(1)
Worst case (many collisions in one bucket):
  O(n)

Space Complexity:
  O(n)
  // Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
*/

class MyHashMap {
    private class Node{
        int key;
        int value;
        Node next;
        public Node(int key, int value){
            this.key =key;
            this.value = value;
        }
    }
    private static final int DEFAULT_CAPACITY = 1000;
    private Node [] buckets;

    public MyHashMap() {
        buckets = new Node[DEFAULT_CAPACITY];
    }
    private int hash(int key){
        return key % DEFAULT_CAPACITY;
    }

    public void put(int key, int value) {
        int hash = hash(key);
        Node cur = buckets[hash];
        if(buckets[hash] == null){
            buckets[hash] = new Node(key, value);
            return;
        }
        while(true){
            if(cur.key == key){
                cur.value = value;
                return;
            }
            if(cur.next == null) break;
            cur = cur.next;
        }
        cur.next = new Node(key, value);
    }

    public int get(int key) {
        int hash = hash(key);
        Node cur = buckets[hash];
        if(buckets[hash] == null){
            return -1;
        }
        while(cur != null){
            if(cur.key == key){
                return cur.value;
            }
            cur = cur.next;
        }
        return -1;
    }

    public void remove(int key) {
        int hash = hash(key);
        Node cur = buckets[hash];
        if (cur == null) return;
        // remove head
        if(cur.key == key){
            buckets[hash] = cur.next;
            return;
        }
        while(cur.next != null){
            if(cur.next.key == key){
                cur.next = cur.next.next;
                return;
            }
            cur = cur.next;
        }
    }
}