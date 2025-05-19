// Time Complexity : O(1) Amortized
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : Has difficulties with helper function had to
// refere back to the video multiple times

class MyHashMap {
    class Node {
        int key;
        int value;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    int ARRAY_SIZE = 10000;
    Node[] primaryArray;

    public int hash(int key) {
        return key % ARRAY_SIZE;
    }

    public Node helper(Node head, int key) {
        Node prev = head;
        Node current = head.next;

        while (current != null && current.key != key) {
            prev = current;
            current = current.next;
        }

        return prev;
    }

    public MyHashMap() {
        primaryArray = new Node[ARRAY_SIZE];
    }

    public void put(int key, int value) {
        int index = hash(key);

        if (primaryArray[index] == null) {
            primaryArray[index] = new Node(-1, -1);
        }

        Node prev = helper(primaryArray[index], key);

        if (prev.next == null) {
            prev.next = new Node(key, value);
        } else {
            prev.next.value = value;
        }

    }

    public int get(int key) {
        int index = hash(key);

        if (primaryArray[index] == null) {
            return -1;
        }
        Node prev = helper(primaryArray[index], key);
        if (prev.next == null) {
            return -1;
        }
        return prev.next.value;

    }

    public void remove(int key) {
        int index = hash(key);

        if (primaryArray[index] == null) {
            return;
        }
        Node prev = helper(primaryArray[index], key);

        if (prev.next == null) {
            return;
        }
        Node temp = prev.next;
        prev.next = temp.next;

    }
}
/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */