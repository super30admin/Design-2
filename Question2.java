// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class MyHashMap {
    ListNode[] nodes = new ListNode[10000];
    public MyHashMap() {

    }
    
    public void put(int key, int value) {
        int index = indexFunc(key);
        ListNode prev = elementFunc(index, key);
        if (prev.next == null)
        {
            prev.next = new ListNode(key, value);
        }
        else
        {
            prev.next.val = value;
        } 
    }
    
    public int get(int key) {
        int index = indexFunc(key);
        ListNode prev = elementFunc(index, key);
        if(prev.next == null)
        {
            return -1;
        }
        else
        {
            return prev.next.val;
        }
    }
    
    public void remove(int key) {
        int index = indexFunc(key);
        ListNode prev = elementFunc(index, key);
        if(prev.next != null)
        {
            prev.next = prev.next.next;
        }
    }

    private int indexFunc(int key)
    {  
        int temp = Integer.hashCode(key) % nodes.length;
        return temp;
    }

 private ListNode elementFunc(int index, int key){
    if(nodes[index] == null)
   {
       return nodes[index] = new ListNode(-1, -1);
   }

   ListNode prev = nodes[index];
    while(prev.next != null && prev.next.key != key)
    {
        prev = prev.next;
    }
    return prev;
}

 private static class ListNode
{
    ListNode next;
    int key, val;
    ListNode(int key, int val)
    {
        this.key = key;
        this.val = val;
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