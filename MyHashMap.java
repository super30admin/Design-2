// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

// Using Linear chaining hashing
class MyHashMap {
    class ListNode {
        int key, value;
        ListNode next;

        ListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    int bucketSize = 10000;
    ListNode[] buckets;

    public MyHashMap() {
        buckets = new ListNode[bucketSize];
    }

    private int hashBucket(int key) {
        return key % bucketSize;
    }

    /*
        Using Previous Pointer to put (add or modify value of existing entry)
        Method is used in put, remove and get operations
        Null check for both bucket and container is important handle the relavant scenario's
     */
    private ListNode findPrevious(ListNode head, int key) {
        ListNode curr = head;
        ListNode prev = null;
        while(curr != null && curr.key != key) {
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }

    public void put(int key, int value) {
        int bucketHash = hashBucket(key);
        if(buckets[bucketHash] == null) {
            buckets[bucketHash] = new ListNode(-1, -1);
        }
        ListNode prev = findPrevious(buckets[bucketHash], key);
        if(prev.next == null) {
            prev.next = new ListNode(key, value);
        } else {
            prev.next.value = value;
        }
    }

    public int get(int key) {
        int bucketHash = hashBucket(key);
        if(buckets[bucketHash] == null) {
            return -1;
        }
        ListNode prev = findPrevious(buckets[bucketHash], key);
        if(prev.next == null) {
            return -1;
        } else {
            return prev.next.value;
        }
    }

    public void remove(int key) {
        int bucketHash = hashBucket(key);
        if(buckets[bucketHash] == null) {
            return;
        }
        ListNode prev = findPrevious(buckets[bucketHash], key);
        if(prev.next == null) {
            return;
        }
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