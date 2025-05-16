// Did this code successfully run on Leetcode : Yes
// Approach : Used Array with LinkedList

// Create node class to represent key-value pairs 
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

public class MyHashMap {

  private Node[] map;

  // Initialize array to store nodes with a length of 1000
  public MyHashMap() {
    map = new Node[1000];

    for (int i = 0; i < 1000; i++) {
      map[i] = new Node(-1, -1);
    }
  }

  // TC: O(1) amortized
  // SC: O(n+m) where n is number of buckets in hashmap in this case 1000 ,
  // m is number of unique keys inserted into the hashmap
  // Approach: Calculate hash using hash method.
  // Access node at the calculated hash index
  // Traverse through linkedlist staring from this node
  // If key is found, update its value and return
  // else add a new node with given key and value
  public void put(int key, int value) {
    int hash = hash(key);
    Node curr = map[hash];

    while (curr.next != null) {
      if (curr.next.key == key) {
        curr.next.val = value;
        return;
      }
      curr = curr.next;
    }
    curr.next = new Node(key, value);
  }

  // TC: O(1) amortized
  // SC: O(n+m)
  // Approach: if node with given key is found return its value
  // else if end of the linkedlist is reached return -1
  public int get(int key) {
    int hash = hash(key);
    Node curr = map[hash];

    while (curr.next != null) {
      if (curr.next.key == key) {
        return curr.next.val;
      }
      curr = curr.next;
    }
    return -1;
  }

  // TC: O(1) amortized
  // SC: O(n+m)
  // Approach: if node with given key is found remove it by adjusting next
  // reference
  // else if end of the list is reached , do nothing
  public void remove(int key) {
    int hash = hash(key);
    Node curr = map[hash];

    while (curr.next != null) {
      if (curr.next.key == key) {
        curr.next = curr.next.next;
        return;
      }
      curr = curr.next;
    }
  }

  // hash function
  public int hash(int key) {
    return key % 1000;
  }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */