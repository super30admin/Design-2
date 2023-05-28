// Time Complexity : O(1) average, O(n) worst case
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class MyHashMap {
    class Node {
        int key;
        int val;
        Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private Node[] map;

    private int hasher(int key) {
        return key % map.length;
    }

    public MyHashMap() {
        this.map = new Node[10000];
    }

    private Node find(Node bucket, int key) {
        Node node = bucket, prev = null;
        while (node != null && node.key != key) {
            prev = node;
            node = node.next;
        }
        return prev;
    }

    public void put(int key, int value) {
        int hash = this.hasher(key);
        if (map[hash] == null) {
            map[hash] = new Node(-1, -1);
        }
        Node prev = this.find(map[hash], key);
        if (prev.next != null) {
            prev.next.val = value;
            return;
        }
        prev.next = new Node(key, value);
    }

    public int get(int key) {
        int hash = this.hasher(key);
        if (map[hash] == null) {
            return -1;
        }
        Node node = this.find(map[hash], key);
        if (node.next != null) {
            return node.next.val;
        }
        return -1;
    }

    public void remove(int key) {
        int hash = this.hasher(key);
        if (map[hash] == null) {
            return;
        }
        Node prev = this.find(map[hash], key);
        if (prev.next != null) {
            prev.next = prev.next.next;
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