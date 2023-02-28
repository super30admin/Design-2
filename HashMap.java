// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
 * An array of linkedlists is used to store key, value pairs. 
 * Hash of the index pointing to the linkedlist is computed and the key, value pair is inserted in that position. 
 * The hash is computed and the node is removed when we click on remove method. 
 */
import java.util.*;

class MyHashMap {
    private static final int SIZE = 10000;
    private LinkedList<Node>[] map;

    public MyHashMap() {
        map = new LinkedList[SIZE];
        for (int i = 0; i < SIZE; i++)
            map[i] = new LinkedList<>();
    }

    public void put(int key, int value) {
        int index = hash(key);
        LinkedList<Node> list = map[index];
        ListIterator<Node> iter = list.listIterator();
        while (iter.hasNext()) {
            Node node = iter.next();
            if (node.key == key) {
                node.key = key;
                node.value = value;
                return;
            }
        }
        list.addLast(new Node(key, value));
    }

    public int get(int key) {
        int index = hash(key);
        LinkedList<Node> list = map[index];
        ListIterator<Node> iter = list.listIterator();
        while (iter.hasNext()) {
            Node node = iter.next();
            if (node.key == key)
                return node.value;
        }
        return -1;
    }

    public void remove(int key) {
        int index = hash(key);
        LinkedList<Node> list = map[index];
        ListIterator<Node> iter = list.listIterator();
        while (iter.hasNext()) {
            Node node = iter.next();
            if (node.key == key) {
                iter.remove();
                return;
            }
        }
    }

    private int hash(int key) {
        return key % SIZE;
    }

    private class Node {
        private int key;
        private int value;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public int getValue() {
            return value;
        }
    }
}
