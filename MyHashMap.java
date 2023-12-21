/*
* Approach:
*  1. In linear chaining, primary array holds the address of linkedlist heads
        with size- 10000, so that chain length will 100
* 
*  2. Our hashfunction is division(/) to avoid more collisions. 
        Once hashIndex is found, we check the head is NULL or not.
* 
*  3. If head is NULL, insert dummy node to follow consistent check using findNode()
*
*  4. findNode() -> returns the prev node pointer when key is found or not found.
        dependent functions will check if prev node next pointer is NULL or not.
        
            if NULL, prev node is last node.
            else, prev node is not last infact key is found.
* 
* 
* Did this code successfully run on Leetcode : YES
* 
* Any problem you faced while coding this : NO
* 
* Time Complexity: 
    findNode, put, remove, get -> O(100) == O(1)
        as the max length of linked list is 100. 

    why not 1000? 
        This is also considered as constant,
            but 100 length is considered more feasible.
        
        If primary array size of 10000 is not viable,
            then we should adjust the primary array = 1000 and chain = 1000

* 
* Space Complexity: O(N)
    we should store all the values into hashmap.
* 
*/

// implementing linear chaining by assuming double hashing scenario is not possible.

class MyHashMap {
    class Node {
        int key;
        int value;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    };

    private Node[] arrNodes;

    private int primaryArraySize;

    public MyHashMap() {
        // can be updated to decrease the chain traversal complexity
        primaryArraySize = 10000;
        arrNodes = new Node[primaryArraySize];
    }

    private int hashFunction(int key) {
        return key / primaryArraySize;
    }

    private Node findNode(Node head, int key) {
        Node curr=head, prev = null;

        while(curr != null && curr.key != key) {
            prev = curr;
            curr = curr.next;
        }

        return prev;
    }

    public void put(int key, int value) {
        int hashIndex = hashFunction(key);

        if(arrNodes[hashIndex] == null)
            arrNodes[hashIndex] = new Node(-1, -1);

        Node prev = findNode(arrNodes[hashIndex], key);

        if(prev.next == null) {
            prev.next = new Node(key, value);
        } else {
            prev.next.value = value;
        }
    }

    public int get(int key) {
        int hashIndex = hashFunction(key);

        if(arrNodes[hashIndex] == null)
            return -1;

        Node prev = findNode(arrNodes[hashIndex], key);

        if(prev.next == null) {
            return -1;
        } else {
            return prev.next.value;
        }
    }

    public void remove(int key) {
        int hashIndex = hashFunction(key);

        if(arrNodes[hashIndex] == null)
            return;

        Node prev = findNode(arrNodes[hashIndex], key);

        if(prev.next != null) {
            Node removedNode = prev.next;
            prev.next = removedNode.next;
            removedNode.next = null;
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