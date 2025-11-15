// ## Problem 2:Design Hashmap (https://leetcode.com/problems/design-hashmap/)

// Time Complexity : Avg ~ O(1) | Worst ~ O(100) since the linear chaining will go at most 100 layers 
// Space Complexity : O(n) ~ Storage array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
 * Initialzed the storage array of ListNode to 10000
 * Used dummy, prev and curr pointer to perform the operations
 * When idx is not used, create dummy node and then check if ListNode of the key already exists. Same for remove.
 */

public class HashMap {

    class ListNode {
        int key;
        int value;
        ListNode next;

        public ListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int fixedSize = 10000;
    ListNode[] storage;

    public HashMap() {
        storage = new ListNode[fixedSize];
    }

    private ListNode getPrevNode(ListNode dummy, int key) {
        ListNode prev = dummy;
        ListNode curr = prev.next;

        while(curr != null && curr.key != key) {
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }

    private int computeHash(int key) {
        return key % fixedSize;
    }

    public void put(int key, int value) {
        int idx = computeHash(key);

        if(storage[idx] == null) {
            ListNode dummy = new ListNode(-1, -1);
            storage[idx] = dummy;
        } 

        ListNode prev = getPrevNode(storage[idx], key);

        if(prev.next == null) {
            ListNode newNode = new ListNode(key, value);
            prev.next = newNode;
        } else {
            prev.next.value = value;
        }
    }
    
    public int get(int key) {
        int idx = computeHash(key);
        if(storage[idx] == null) {
            return -1;
        }

        ListNode curr = storage[idx];
        while(curr!=null) {
            if(curr.key == key) {
                return curr.value;
            } else {
                curr = curr.next;
            }
        }

        return -1;
    }
    
    public void remove(int key) {
        int idx = computeHash(key);
        if(storage[idx] == null) {
            return;
        }

        ListNode prev = getPrevNode(storage[idx], key);
    
        if(prev.next != null) {
            prev.next = prev.next.next;
        }
    }

    public static void main(String[] args) {
        HashMap myHashMap = new HashMap();
        myHashMap.put(1, 1); // The map is now [[1,1]]
        myHashMap.put(2, 2); // The map is now [[1,1], [2,2]]
        System.out.println(myHashMap.get(1));    // return 1, The map is now [[1,1], [2,2]]
        System.out.println(myHashMap.get(3));    // return -1 (i.e., not found), The map is now [[1,1], [2,2]]
        myHashMap.put(2, 1); // The map is now [[1,1], [2,1]] (i.e., update the existing value)
        System.out.println(myHashMap.get(2));   // return 1, The map is now [[1,1], [2,1]]
        myHashMap.remove(2); // remove the mapping for 2, The map is now [[1,1]]
        System.out.println(myHashMap.get(2));   // return -1 (i.e., not found), The map is now [[1,1]]

    }
}
