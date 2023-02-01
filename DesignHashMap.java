// TC: O(1)
// SC: O(n)
class MyHashMap {

    class Node {
        int key, val;
        Node next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    Node[] nodes;

    public MyHashMap() {
        this.nodes = new Node[10000];
    }

    private int getIndex(int key) {
        return key % 10000;
    }

    public void put(int key, int val) {
        int i = getIndex(key);
        Node prev = getElement(i, key);
        if(prev.next == null) {
            prev.next = new Node(key, val);
        } else {
            prev.next.val = val;
        }

    }

    public int get(int key) {
        int i = getIndex(key);
        Node prev = getElement(i, key);
        if(prev.next == null) {
            return -1;
        }
        return prev.next.val;
    }

    public void remove(int key) {
        int i = getIndex(key);
        Node prev = getElement(i, key);
        if(prev.next != null) {
            prev.next = prev.next.next;
        }
    }

    private Node getElement(int i, int key) {
        if(nodes[i] == null) {
            return nodes[i] = new Node(-1, -1);
        }
        Node prev = nodes[i];
        while(prev.next != null && prev.next.key != key) {
            prev = prev.next;
        }
        return prev;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */