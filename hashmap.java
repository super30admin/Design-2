// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


class MyHashMap {

    ListNode[] nodes = new ListNode[10000];
    public MyHashMap() {
        
    }

    private int getIndex(int key){  
        return Integer.hashCode(key) % nodes.length;
    }

    private ListNode findElement(int index, int key){
        if(nodes[index] == null)
        return nodes[index] = new ListNode(-1, -1);

        ListNode prev = nodes[index];
        while(prev.next != null && prev.next.key != key){
            prev = prev.next;
        }
        return prev;
    }
    
    public void put(int key, int value) {
        int index = getIndex(key);
        ListNode prev = findElement(index, key);
        if (prev.next == null)
            prev.next = new ListNode(key, value);
        else 
            prev.next.val = value;
    }
    
    public int get(int key) {
        int index = getIndex(key);
        ListNode prev = findElement(index, key);
        return prev.next == null ? -1 : prev.next.val;
    }
    
    public void remove(int key) {
        int index = getIndex(key);
        ListNode prev = findElement(index, key);
        if(prev.next != null)
        prev.next = prev.next.next;
    }
    private static class ListNode{
        int key, val;
        ListNode next;
        ListNode(int key, int value){
            this.key=key;
            this.val=value;
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