// Time Complexity : O(1) for all operations
// Space Complexity : O(N) for storing the elements
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
    * Double hashing would work which we used in hashset approach but this will consume lot of space,
    * so opted for separate chaining approch
    * Create an Node array of size 10000 and the corresponding LL will be of size 100
    * For put operation, first we compute the index using hash function and get prev node for that key.
    * If key is present, update the value or create the new node
    * For get operation, compute the index, get prev node for that key, if the key is present, return the value or null.
    * For remove operation, compute the index, get prev node for that key, if the key is present, just delink the connection
*/
 public class HashMap {

    class Node {
        int key;
        int value;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node[] storage;

    public HashMap() {
        storage = new Node[10000];
    }

    public Node getPrevNode(Node head, int key) {
        Node prev = null;
        Node cur = head;
        while (cur != null && cur.key != key) {
            prev = cur;
            cur = cur.next;
        }
        return prev;
    }

    private int hash1(int key) {
        return key % 10000;
    }

    public void put(int key, int val) {
        int index = hash1(key);
        if (storage[index] == null) {
            storage[index] = new Node(-1, -1);
        }
        Node prev = getPrevNode(storage[index], key);
        if (prev.next == null) {
            prev.next = new Node(key, val);
        } else {
            prev.next.value = val;
        }
    }

    public int get(int key) {
        int index = hash1(key);
        if (storage[index] == null) return  -1;
        Node prev = getPrevNode(storage[index], key);
        if (prev.next == null) {
            return -1;
        } else {
            return prev.next.value;
        }
    }

    public void remove(int key) {
        int index = hash1(key);
        if (storage[index] == null) return;
        Node prev = getPrevNode(storage[index], key);
        if (prev.next == null) return;
        Node temp = prev.next;
        prev.next = prev.next.next;
        temp.next =  null;
    }

    public static void main(String[] args) {
        HashMap hashMap = new HashMap();
        hashMap.put(5, 50);
        hashMap.put(6, 60);
        hashMap.put(5, 1000);
        System.out.println(hashMap.get(5));
        System.out.println(hashMap.get(90));
        hashMap.remove(5);
        System.out.println(hashMap.get(5));
    }
}
