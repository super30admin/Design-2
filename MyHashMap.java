// Time Complexity : put -> 0(1), get -> 0(1), remove -> 0(1)
// Space Complexity : 0(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Approach : Maintain an array of Nodes. 
//            Hash function returns the array index to store each key. In case of collision, link a new node.
//            Search function searches and returns the node with the key for Get, Remove and Put

// Your code here along with comments explaining your approach
class MyHashMap {

    class Node {
        int key;
        int val;
        Node next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
            this.next = null;
        }
    }

    private int hash(int x) {
        return x % 10000;
    }

    private Node search(Node head, int key) {
        Node prev = null;
        Node cur = head;
        while (cur != null && cur.key != key) {
            prev = cur;
            cur = cur.next;
        }
        return prev;
    }

    Node[] arr;

    public MyHashMap() {
        this.arr = new Node[10000];
    }

    public void put(int key, int value) {
        int index = hash(key);

        if (arr[index] == null) {
            arr[index] = new Node(-1, -1); // dummy
        }

        Node prev = search(arr[index], key);
        if (prev.next == null) {
            prev.next = new Node(key, value); // adding a new node
        } else {
            prev.next.val = value; // updating an existing node
        }

    }

    public int get(int key) {
        int index = hash(key);
        if (arr[index] != null) {
            Node prev = search(arr[index], key);
            if (prev.next != null) {
                return prev.next.val;
            }
        }
        return -1;
    }

    public void remove(int key) {
        int index = hash(key);

        if (arr[index] != null) {
            Node prev = search(arr[index], key);
            if (prev.next != null) {
                Node temp = prev.next; // node to remove
                prev.next = temp.next;
                temp.next = null;
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
