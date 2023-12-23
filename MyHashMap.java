class MyHashMap {

    public class Node {
        int key;
        int val;
        Node next; // null

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    Node[] storage;

    public MyHashMap() {
        this.storage = new Node[10000];
    }

    private Node find(Node node, int key) {
        Node prev = null;
        Node curr= node;
        while(curr != null && curr.key !=key) {
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }

    public void put(int key, int value) {
        int index = key%storage.length;
        if(storage[index] == null) {
            storage[index] = new Node(-1,-1);
        }
        Node prev = find(storage[index], key);
        if(prev.next == null) {
            prev.next = new Node(key,value);
        } else {
            prev.next.val = value;
        }
    }

    //there is a mistake in your get function.
    // when your call findNode(key) it will return prev node pointer, you have to check if prev.next is null or not. If null, return -1, if not return prev.next.value.
    // you are returning prev.value.
    public int get(int key) {
        int index = key%storage.length;
        if(storage[index] == null) return -1;
        Node prev = find(storage[index], key);
        if(prev.next == null) return -1;
        else return prev.next.val;
    }

    public void remove(int key) {
        int index = key%storage.length;
        if(storage[index] == null) return;
        Node prev = find(storage[index], key);
        if(prev.next == null) return;
        Node tmp = prev.next;
        prev.next = prev.next.next;
        tmp.next = null;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */