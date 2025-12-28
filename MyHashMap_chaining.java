// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// I am using the chaining approach to implement the hashmap. The basic idea is to use an array of linked lists to store key-value pairs.
// The hash function is used to determine the index in the array where the key-value pair should be stored.
// When a collision occurs, the key-value pair is added to the linked list at that index.
// The search operation involves traversing the linked list at the index to find the key-value pair.
// The put operation involves adding a new key-value pair to the linked list at the index, or updating the value if the key already exists.
// The get operation involves searching the linked list at the index for the key and returning the corresponding value.
// The remove operation involves searching the linked list at the index for the key and removing the key-value pair if found.

class MyHashMap {
    private class Node{
        int key, value;
        Node next;
        Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    private Node [] storage;
    private int buckets;
    public MyHashMap() {
        this.buckets = 10000;
        this.storage =  new Node[buckets];
    }

    // Time Complexity : O(1)
    // Space Complexity : O(1)
    private int myHashFunction (int key){
        return key % buckets;
    }

    // Time Complexity : amortized O(1)
    // Space Complexity : O(1)
    private Node search(Node head , int key){

        Node previousNode = head;
        Node currentNode = previousNode.next;

        while(currentNode != null && currentNode.key != key){
            previousNode = currentNode;
            currentNode = currentNode.next;
        }
        return previousNode;

    }

    // Time Complexity : amortized O(1)
    // Space Complexity : O(1)

    public void put(int key, int value) {
        int index = myHashFunction(key);
        if(storage[index] == null){
            storage[index] = new Node(-1,-1);
        }
        Node prev = search(storage[index], key);
        if(prev.next == null){
            prev.next = new Node(key, value);
        }else{
            prev.next.value = value;
        }
    }

    // Time Complexity : amortized O(1)
    // Space Complexity : O(1)

    public int get(int key) {
        int index = myHashFunction(key);
        if(storage[index] == null) return -1;

        Node prev = search(storage[index], key);

        if(prev.next == null || prev.next.key != key) return -1;
        return prev.next.value;

    }

    // Time Complexity : amortized O(1)
    // Space Complexity : O(1)

    public void remove(int key) {
        int index = myHashFunction(key);
        if(storage[index] == null) return;
        Node prev = search(storage[index], key);
        if(prev.next == null) return;
        prev.next = prev.next.next;

    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */