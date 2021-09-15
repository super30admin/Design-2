/*
Runtime: 25 ms, faster than 35.56% of Java online submissions for Design HashSet.
Memory Usage: 53.4 MB, less than 25.66% of Java online submissions for Design HashSet.
*/
class MyHashSet {
    
    class Node {
        int key;
        Node next;
        
        public Node(int key) {
            this.key = key;
        }
    }

    Node[] nodes;
    /** Initialize your data structure here. */
    public MyHashSet() {
        nodes = new Node[10000];
    }
    
    private int getIndex(int key) {
        return key % 10000;
    }
    
    public Node find(Node head, int key) {
        Node prev = head;
        Node curr = head.next;
        while(curr != null && curr.key != key){
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }
    
    public void add(int key) {
        int index = getIndex(key);
        //check if there is linked list
        if(nodes[index] ==  null) {
            nodes[index] = new Node(-1);
        }
        // find key
        Node prev = find(nodes[index], key);
        if(prev.next == null) 
            prev.next = new Node(key);
    }
    
    public void remove(int key) {
        int index = getIndex(key);
        if(nodes[index] == null)
            return;
        Node prev = find(nodes[index], key);
        if(prev.next == null)
            return;
        prev.next = prev.next.next;
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int index = getIndex(key);
        if(nodes[index] == null)
            return false;
        Node prev = find(nodes[index], key);
        if(prev.next == null)
            return false;
        return prev.next.key >= 0;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */