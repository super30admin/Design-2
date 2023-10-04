//Design HashMap
//put: O(1)
//get: O(1)
//remove: O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None
class MyHashMap {

  final ListNode[] nodes = new ListNode[10000];

  public void put(int key, int value) {
    int i = idx(key);
    if (nodes[i] == null) nodes[i] = new ListNode(-1, -1);
    ListNode prev = find(nodes[i], key);
    if (prev.next == null) prev.next =
      new ListNode(key, value); else prev.next.val = value;
  }

  public int get(int key) {
    int i = idx(key);
    if (nodes[i] == null) return -1;
    ListNode node = find(nodes[i], key);
    return node.next == null ? -1 : node.next.val;
  }

  public void remove(int key) {
    int i = idx(key);
    if (nodes[i] != null) {
      ListNode prev = find(nodes[i], key);
      if (prev.next != null) prev.next = prev.next.next;
    }
  }

  int idx(int key) {
    return Integer.hashCode(key) % nodes.length;
  }

  ListNode find(ListNode bucket, int key) {
    ListNode node = bucket, prev = null;
    for (; node != null && node.key != key; node = node.next) prev = node;
    return prev;
  }

  class ListNode {

    int key, val;
    ListNode next;

    ListNode(int key, int val) {
      this.key = key;
      this.val = val;
    }
  }
}

public class Problem2 {

  public static void main(String[] args) {
    MyHashMap obj = new MyHashMap();
    obj.put(1, 3);
    int param_2 = obj.get(1);
    System.out.println(param_2);
    obj.remove(1);
  }
}
