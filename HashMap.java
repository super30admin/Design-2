import java.util.List;

// Time Complexity : Put - amortized O(1), Remove - amortized O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class HashMap {
    private final int MAX_SIZE = 10000;
    private final Node[] map = new Node[MAX_SIZE];

    //Put element at the index you got from hash function and handle edge cases
    // If there is collision at the position at new key-value to the position as known as chaining
    public void put(int key, int value) {
        int position = hashFunction(key);
        Node newNode = new Node(key, value);
        // If the key is not present, set the newNode to  key
        // If the first element itself matches the key, update the existing value with new
        if (map[position] == null || map[position].key == key) {
            map[position] = newNode;
            return;
        }

        // check if the rest of the linked list has the key
        Node head = map[position];
        while (head.next != null) {
            // If yes, update the value
            if (head.key == key) {
                head.value = value;
                return;
            }

            head = head.next;
        }
        // If no, append the new node to the end
        head.next = newNode;
    }

    // Check if the key has associated value, if not return -1
    // If yes, check other case
    public int get(int key) {
        int position = hashFunction(key);
        Node head = map[position];
        if (head == null) {
            System.out.println("key is present in the map");
            return -1;
        }

        // If the key is the first in list of nodes
        if (head.key == key) {
            return head.value;
        }

        // Check the rest of the values in the list
        while (head != null) {
            if (head.key == key) {
                return head.value;
            }
            head = head.next;
        }

        // If the key doesnt exist
        return -1;
    }

    // If the key exists, remove the corresponding values at the index calculated by hash function
    public void remove(int key) {
        int position = hashFunction(key);
        Node head = map[position];
        if (head == null) {
            System.out.println("key is present in the map");
            return;
        }
        // If the key is the first value in the list, remove it by setting it null
        if (head.next == null) {
            if (head.key == key) {
                map[position] = null;
            }
            return;
        }

        // Check the rest of the list, if the key exists, remove it by pointing
        while (head.next != null) {
            if(head.next.key == key){
                Node temp = head.next;
                head.next = temp.next;
                temp.next = null;
                return;
            }
            head = head.next;
        }

    }

    private int hashFunction(int key) {
        return key % MAX_SIZE;
    }

    class Node {
        int key;
        int value;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

}
