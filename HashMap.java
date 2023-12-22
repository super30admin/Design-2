// Time Complexity :O(1) Amortized
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
//Approach: Linear Chaining
// primary array size is 10000
//LinkedList max size is 100

public class HashMap {
  int baseNumber = 10000;
  Node[] arr;

  class Node {
    int key = 0;
    int val = 0;
    Node prev = null;
    Node next = null;

    public Node(int k, int value) {
      this.key = k;
      this.val = value;
    }
  }

  public HashMap() {
    arr = new Node[baseNumber];
  }

  public void put(int key, int value) {

    int hash = key % baseNumber;
    //primary array does not have value
    if (arr[hash] == null) {
      arr[hash] = new Node(-1, -1);
      arr[hash].next = new Node(key, value);
    }
    //primary array have value
    else {
      Node last = findLast(arr[hash], key);
      //linked list does not have the key
      if (last.next == null) {
        last.next = new Node(key, value);
      }
      //link list already have the key. so replace
      else {
        last.next.val = value;
      }
    }
  }

  private Node findLast(Node head, int key) {
    Node prev = null;
    Node curr = head;
    //key will not be there so current can go to end == null
    //key will be there. so stop just behind the key.
    while (curr != null && curr.key != key) {
      prev = curr;
      curr = curr.next;
    }
    return prev;
  }

  public int get(int key) {
    int hash = key % baseNumber;
    if (arr[hash] != null) {
      Node last = findLast(arr[hash], key);
      if (last.next == null) return -1;
      else {
        return last.next.val;
      }
    }
    return -1;
  }


  public void remove(int key) {
    int hash = key % baseNumber;
    if (arr[hash] == null) return;
    Node last = findLast(arr[hash], key);
    if (last.next == null) return;
    //removing the next elemt to last.
    last.next = last.next.next;
  }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */