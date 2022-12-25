// Approach1
// Time Complexity : put(), get(), remove() run in constant time O(1) worst case O(100)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

// We use chaining approach here. Primary array will use hash function and have length 10000.
// Primary array indices point to secondary linked lists that are initalized only when an we get an element with its hash value as corresponding index. 

class MyHashMap {

    private class Node{
        int key;
        int value;
        Node next;
        Node(int key, int value, Node next){
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    private Node[] hashMap;
    private int primLen;
    
    public MyHashMap() {
        primLen = 10000; //
        hashMap = new Node[primLen];
    }

    private int hash(int key) { //hash fn
        return key%primLen;
    }

    private Node getPrevNode(Node head, int key){ //searches for key in given linkedlist and returns pointer to prev node
        Node cur = head.next; Node prev = head;
        while(cur!=null && cur.key!=key){
            prev = cur;
            cur = cur.next;
        }
        return prev;
    }
    
    public void put(int key, int value) {
        int hashIdx = hash(key);
        if(hashMap[hashIdx]==null) //no linkedlist at that index
        {
            Node dummy = new Node(-1,-1,null); //create dummy node so that getPrevNode function will always return valid value
            hashMap[hashIdx]=dummy; //handles case where we need to remove/update first linked list node
        }
        Node prev = getPrevNode(hashMap[hashIdx], key);
        if(prev.next==null) //key not found case
            prev.next = new Node(key,value,null);
        else
            prev.next.value = value;
    }
    
    public int get(int key) {
        int hashIdx = hash(key);
        if(hashMap[hashIdx]==null)
            return -1;
        Node prev = getPrevNode(hashMap[hashIdx], key);
        if(prev.next==null)
            return -1;
        else
            return prev.next.value;
    }
    
    public void remove(int key) {
         int hashIdx = hash(key);
        if(hashMap[hashIdx]==null)
            return;
        Node prev = getPrevNode(hashMap[hashIdx], key);
        if(prev.next==null)
            return;
        else
            prev.next = prev.next.next;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */