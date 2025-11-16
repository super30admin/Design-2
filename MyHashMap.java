/**
* Implement using linear chaining.
* Maximum number of key, value pairs will be 10^6 + 1.
* Primary memory (Array) will have 10000 indices.
* Secondary memory (LinkedList) will have maximum of 100 nodes.
**/
//  Time Complexity : O(1) average / amortized and O(100) in worst case for all operations.
// Because maximum of 100 nodes of a linked list are traversed in worst case.
// Space Complexity : O(N) for the storage array.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

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

class MyHashMap {

    private static final int STORAGE_SIZE = 10000;
    Node[] storage;
    public MyHashMap() {
        storage = new Node[STORAGE_SIZE];
    }
    
    public void put(int key, int value) {
        int index = this.computeHash(key);
        if (storage[index] == null) {
            storage[index] = new Node(-1, -1);
        }
        Node previousNode = getPreviousNode(index, key);
        Node newNode = new Node(key, value);
        Node nextNode = previousNode.next; // Next node will be null if key didn't exist before, else it will either be a node or null.
        previousNode.next = newNode;
        newNode.next = nextNode;
    }
    
    public int get(int key) {
        int index = this.computeHash(key);
        if (storage[index] == null) { // key does not exist in HashMap
            return -1;
        }
        Node previousNode = getPreviousNode(index, key);
        // If previousNode.next is null, key does not exist. Else return the next node's value.
        return previousNode.next != null ? previousNode.next.value : -1;
    }
    
    public void remove(int key) {
        int index = this.computeHash(key);
        if (storage[index] == null) {
            return;
        }
        Node previousNode = getPreviousNode(index, key);
        if (previousNode == null) { // key does not exist in HashMap
            return;
        }
        Node node = previousNode;
        Node next = previousNode.next.next;
        previousNode.next = next;
        node.next = null; // Not always needed. But good to have for the garbage collector to release the memory faster.        
    }

    private int computeHash(int key) {
        return key % STORAGE_SIZE;
    }

    private Node getPreviousNode(int index, int key) {
        Node previousNode = storage[index]; // Initializing previous node to the first node
        while (previousNode.next != null) {
            if (previousNode.next.key == key) { // Node with matching key found
                return previousNode; // return previousNode
            }
            previousNode = previousNode.next; // Move to next node
        }
        return previousNode; // Node with key does not exist. Returns the first node (-1, -1).
    }

    public static void main(String[] args) {
        MyHashMap myHashMap = new MyHashMap();
        System.out.println(myHashMap.get(1)); // return -1 since key is not found
        myHashMap.remove(1); // removes nothing
        myHashMap.put(1, 1); // map = [[1, 1]]
        myHashMap.put(2, 2); // map = [[1, 1], [2, 2]]
        System.out.println(myHashMap.get(1)); // return 1
        myHashMap.put(1, 2); // map = [[1, 2], [2, 2]]. The value of key 1 is updated to 2.
        System.out.println(myHashMap.get(1)); // return 2. Updated value is returned.
        myHashMap.remove(1); // map = [[2, 2]]. key 1 is removed along with its value.
        System.out.println(myHashMap.get(1));   // return -1 since key is not found
        System.out.println(myHashMap.get(2));   // return 2
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */