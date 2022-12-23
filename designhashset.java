class MyHashSet {

    class ListNode{
        int key;
        ListNode next;
        
        ListNode(int key){
            this.key = key;
        }
    }
    
    private ListNode[] nodes;
     /** Initialize your data structure here. */
    public MyHashSet() {
        nodes = new ListNode[769];
    }
    
    public void add(int key) {
        if(contains(key))
            return;
        int hashKey = hashFunction(key);
        if(nodes[hashKey] == null){
            nodes[hashKey] = new ListNode(-1);
        }
        ListNode prev = find(nodes[hashKey], key);
        
        prev.next = new ListNode(key);
        
    }
    
    public void remove(int key) {
        int hashKey = hashFunction(key);
        if(nodes[hashKey] == null)
            return;
        ListNode prev = find(nodes[hashKey], key);
        if(prev.next == null)
            return;
        prev.next = prev.next.next;
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int hashKey = hashFunction(key);
        if(nodes[hashKey] == null){
            nodes[hashKey] = new ListNode(-1);
        }
        ListNode prev = find(nodes[hashKey], key);
        if(prev.next == null)
            return false;
        return prev.next.key == key;
    }
    
    public int hashFunction(int key){
        return key % nodes.length;
    }
    
    public ListNode find(ListNode bucket, int key){
        ListNode head = bucket;
        ListNode prev = null;
        
        while(head!= null && head.key != key){
            prev = head;
            head = head.next;
        }
        return prev;
    }
}

Time complexity : O(1)
Space complexity : O(n)

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */