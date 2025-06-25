//Time Complexity: O(n) as it take max O(n) time to do all the operations which involve traversing the list
//Space Complexity: O(n)

// Successfully submitted in LeetCode

// Take a arrays of nodes, so we are using array and each entry might have a linkedList to store the values and the index of arr acts a key. While inserting we find the hash to get the index(key) then create a newNode traverse the linkedList using the head node present at the value of index, and insert in the end. Same way traverse and check to Contains and to delete a value

class _706_Design_HashMap {

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

  private Node[] map;

  public _706_Design_HashMap() {
    map = new Node[1000];
    for (int i = 0; i < 1000; i++) {
      map[i] = new Node(-1, -1);
    }
  }

  private int hash(int key) {
    return key % 1000;
  }

  public void put(int key, int value) {
    int hash = hash(key);
    Node cur = map[hash];

    while (cur.next != null) {
      if (cur.next.key == key) {
        cur.next.val = value;
        return;
      }
      cur = cur.next;
    }

    cur.next = new Node(key, value);
  }

  public int get(int key) {
    int hash = hash(key);
    Node cur = map[hash].next;

    while (cur != null) {
      if (cur.key == key) return cur.val;
      cur = cur.next;
    }

    return -1;
  }

  public void remove(int key) {
    int hash = hash(key);
    Node cur = map[hash];

    while (cur.next != null) {
      if (cur.next.key == key) {
        cur.next = cur.next.next;
        return;
      }
      cur = cur.next;
    }
  }
}
