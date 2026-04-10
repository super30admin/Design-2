// Time Complexity : Time complexity is O(1) on average and O(n) in worst case
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// This custom HashMap uses an array of 1000 buckets where each bucket is a linked list to store key-value pairs, and it uses a simple hash function (key % 1000) to decide which bucket to put data in. When you add, get, or remove items, it finds the right bucket and then searches through the linked list to handle the operations.
class MyHashMap {

    static class Node {
         private int key;
         private int value;
         private Node next;

         Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    private static final int SIZE = 1000;
    private Node[] buckets;

    public MyHashMap() {
        buckets = new Node[SIZE];    
    }
    
    private int getHash(int key) {
        return key % SIZE;
    }

    public void put(int key, int value) {
        int index = getHash(key);
        if (buckets[index] == null) {
            buckets[index] = new Node(-1, -1);
        }

        Node previousNode = buckets[index];
        Node currentNode = previousNode.next;

        while (currentNode != null) {
            if (currentNode.key == key) {
                currentNode.value = value;
                return;
            }
            previousNode = currentNode;
            currentNode = currentNode.next;
        }

        previousNode.next = new Node(key, value);
    }
    
    public int get(int key) {
        int index = getHash(key);

        if (buckets[index] == null) {
            return -1;
        }

        Node currentNode = buckets[index].next;
        while (currentNode != null ){
            if (currentNode.key == key) {
               return currentNode.value;
            }
            currentNode = currentNode.next;
        }
        return -1;
    }
    
    public void remove(int key) {
       int index = getHash(key);

        if (buckets[index] == null) {
            return;
        }

        Node previousNode = buckets[index];
        Node currentNode = previousNode.next;

        while (currentNode != null) {
            if (currentNode.key == key) {
                previousNode.next = currentNode.next;
                return;
            }
            previousNode = currentNode;
            currentNode = currentNode.next;
        }
    }
}