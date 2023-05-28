// Time Complexity : amortized O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : finding edge cases.


// Your code here along with comments explaining your approach
// Used Linear chaining technique to design the hashMap 

class MyHashMap {
    class Node{
        int key;
        int val;
        Node next;
        
        public Node(int key,int value){
            this.key=key;
            this.val=value;
        }
    }

    private Node[] storage;


    public MyHashMap() {
        this.storage = new Node[10000];
        
    }
    
    public int hash(int key)
    {
        return key%10000;
    }


    private Node find(Node head,int key){
        Node prev= null;
        Node curr = head;
        while(curr!=null && curr.key!=key)
        {
            prev=curr;
            curr = curr.next;
        }
        return prev;
    }

    public void put(int key, int value) {
        int primaryIndex = hash(key);
        if(storage[primaryIndex]==null)
        {
            storage[primaryIndex] = new Node(-1,-1);
        }
        Node  prev= find(storage[primaryIndex],key);
        if(prev.next == null){
            prev.next= new Node(key,value);
        }
        else
        {
            prev.next.val = value;
        }

    }
    
    public int get(int key) {
        int primaryIndex = hash(key);
        if(storage[primaryIndex]==null) return -1;
        else {
            Node prev = find(storage[primaryIndex],key);
            if(prev.next == null) return -1;
                return prev.next.val;
        }
    }
    
    public void remove(int key) {
        int primaryIndex = hash(key);
        if(storage[primaryIndex]==null) return;
        else {
            Node prev = find(storage[primaryIndex],key);
            if(prev.next == null) return;
            else 
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