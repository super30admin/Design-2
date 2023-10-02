// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No
class MyHashMap {
    class Node{
        int key;
        int val;
        Node next;
        public Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }
    private Node[] storage;
    private int hash(int key){
        return key%10000;
    }
    public MyHashMap() {
        storage = new Node[10000];
    }

    private Node search(Node head, int key){
        Node prev = null;
        Node curr = head;
        while(curr!=null && curr.key!=key){
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }

    public void put(int key, int value) {
        int index = hash(key);
        if(storage[index] == null){
            storage[index] = new Node(-1,-1);
        }
        Node prev = search(storage[index], key);
        if(prev.next == null){
            prev.next = new Node(key, value);
        } else {
            prev.next.val = value;
        }
    }

    public int get(int key) {
        int index = hash(key);
        if(storage[index] == null){
            return -1;
        }
        Node prev = search(storage[index], key);
        if(prev.next == null){
            return -1;
        } else {
            return prev.next.val;
        }
    }

    public void remove(int key) {
        int index = hash(key);
        if(storage[index] == null){
            return;
        }
        Node prev = search(storage[index], key);
        if(prev.next == null){
            return;
        } else {
            Node temp = prev.next;
            prev.next = temp.next;
            temp.next = null;
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