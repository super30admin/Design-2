class MyHashSet {
    
    ListNode[] hashset = new ListNode[100000];

    private class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
        }
    }
    /** Initialize your data structure here. */
    public MyHashSet() {
        
    }
    
    private int hashFunction(int val){
        return Integer.hashCode(val) % hashset.length;
    }
    
    private ListNode findElement(int index, int val){
        if(hashset[index] == null){
            hashset[index] = new ListNode(-1);
            return hashset[index];
        } else {
            ListNode curr = hashset[index];
            while(curr.next != null && curr.next.val!= val){
                curr= curr.next;
            }
            
            return curr;
        }
        
    }
    public void add(int key) {
        int index = hashFunction(key);
        ListNode prev = findElement(index, key);
        
        if(prev.next == null){
            prev.next = new ListNode(key);
        }
    }
    
    public void remove(int key) {
        int index = hashFunction(key);
        ListNode prev = findElement(index, key);
        
        if(prev.next == null){
            return;
        } else {
            prev.next = prev.next.next;
        }
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int index = hashFunction(key);
        ListNode prev = findElement(index, key);
        
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