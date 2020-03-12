/*
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * Did this code run successfully on leetcode: Yes
 * Any problem faced while coding this: No
 * */

class Node {

    int value;
    Node next;

    Node(int value){
        this.value = value;
        this.next = null;
    }
}

class MyHashSet {

    Node[] set;

    /** Initialize your data structure here. */
    public MyHashSet() {
        set = new Node[10000];
    }

    public int getIndexKey(int key) {
        return key % set.length;
    }

    public Node findElement(int index, int key) {
        if(set[index] == null) {
            set[index]  = new Node(-1);
            return set[index];
        } else {
            Node cur = set[index];
            while(cur.next != null && cur.next.value != key){
                cur = cur.next;
            }
            return cur;
        }
    }

    public void add(int key) {
        int index = getIndexKey(key);
        Node prev = findElement(index, key);
        if(prev.next == null){
            Node cur = new Node(key);
            prev.next = cur;
        }
    }

    public void remove(int key) {
        int index = getIndexKey(key);
        Node prev = findElement(index, key);
        if(prev.next != null){
            prev.next = prev.next.next;
        }
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int index = getIndexKey(key);
        Node prev = findElement(index, key);
        if(prev.next != null){
            return true;
        }
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */