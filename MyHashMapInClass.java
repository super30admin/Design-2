public class MyHashMapInClass {
  
  class Node {
    int key, val;
    Node next;
  
    public Node(int key, int val) {
      this.key = key;
      this.val = val;
      this.next = null;
    }
  }

  private Node[] storage;
  private int buckets;

  public MyHashMapInClass() {
    this.buckets = 10000;
    this.storage = new Node[buckets];
  }

  // hash function
  public int hash(int key) {
    return key % buckets;
  }

  private Node helper(Node head, int key) {
    Node prev = head;
    Node curr = head.next;
    // till null or till we find the key
    while (curr != null && curr.key != key) {
      prev = curr;
      curr = curr.next;
    }
    return prev;
  }

public void put(int key, int value) {
    int idx = hash(key);
    if (storage[idx] == null) {
      storage[idx] = new Node(-1, -1);
    }
    Node prev = helper(storage[idx], key);
    if (prev.next == null) {
      prev.next = new Node(key, value);
    } else {
      prev.next.val = value;
    }
  }

  public int get(int key) {
    int idx = hash(key);
    if (storage[idx] == null)
      return -1;
    Node prev = helper(storage[idx], key);
    if (prev.next == null) {
      return -1;
    }
    return prev.next.val;
  }

  public void remove(int key) {
    int idx = hash(key);
    if (storage[idx] == null)
      return;
    Node prev = helper(storage[idx], key);
    if (prev.next == null)
      return;
    Node temp = prev.next;
    prev.next = prev.next.next;
    temp.next = null;
  }

  public static void main(String[] args) {
    MyHashMapInClass map = new MyHashMapInClass();

    // Put some key-value pairs
    map.put(1, 1);
    map.put(2, 2);
    map.put(10001, 30); // to test collision (1 and 10001 hash to same bucket)

    // Get values
    System.out.println("Value for key 1: " + map.get(1)); // 10
    System.out.println("Value for key 2: " + map.get(2)); // 20
    System.out.println("Value for key 10001: " + map.get(10001)); // 30
    System.out.println("Value for key 3: " + map.get(3)); // -1 (not found)

    // Update a value
    map.put(2, 25);
    System.out.println("Updated value for key 2: " + map.get(2)); // 25

    // Remove a key
    map.remove(1);
    System.out.println("Value for key 1 after removal: " + map.get(1)); // -1
  }
}
