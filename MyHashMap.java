// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class MyHashMap {

    class Node {
        int key;
        int value;

        Node next;
        public Node(int key, int val) {
            this.key = key;
            this.value = val;
        }
    }

    private Node[] storage;
    private int hash;

    public MyHashMap() {
        storage = new Node[10000];
    }

    private int getHash(int key) {
        return key % 10000;
    }

    private Node search(Node head, int key) {
        Node temp = head;
        Node previousNode = null;
        while(temp != null && temp.key != key) {
            previousNode = temp;
            temp = temp.next;
        }
        return previousNode;

    }

    public void put(int key, int value) {
        int index = getHash(key);
        if(storage[index] == null) {
            storage[index] = new Node(-1, -1);
        }

        Node previousNode = search(storage[index], key);
        if(previousNode.next == null) {
            previousNode.next = new Node(key, value);
        } else {
            previousNode.next.value = value;
        }
    }

    public int get(int key) {
        int index = getHash(key);
        if(storage[index] == null) return -1;
        Node previousNode = search(storage[index], key);
        if(previousNode.next == null) return -1;
        return previousNode.next.value;
    }

    public void remove(int key) {
        int index = getHash(key);
        Node previousNode = search(storage[index], key);
        if(previousNode == null) return;
        Node tempNode = previousNode;
        if(tempNode.next != null && tempNode.next.next != null) {
            previousNode.next = tempNode.next.next;
        } else {
            previousNode.next = null;
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