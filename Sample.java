// Your code here along with comments explaining your approach

//Design a hashset using DoubleHashing
//Time complexity:o(1);
//space complexity:o(1);
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : NO

class MyHashMap {
    class Node{
        int key;
        int val;
        Node next;
        
        public Node(int key, int val)
        {
            this.key=key;
            this.val=val;
        }
    }
    Node [] nodes;

    public MyHashMap() {
        nodes=new Node[10000];
        
    }
    
    public int idx(int key)
    {
        return key%10000;
    }
    
    private Node find(Node head, int key)
    {
        Node prev=null;
        Node curr=head;
        
        while(curr!=null && curr.key!=key)
        {
            prev=curr;
            curr=curr.next;
        }
        return prev;
    }
    
    public void put(int key, int value) {
        int idx=idx(key);
        if(nodes[idx]==null)
        {
            nodes[idx]= new Node(-1,-1);
        }
        //If already exists in out list;
        Node prev=find(nodes[idx], key);
        if(prev.next==null)
        {
            prev.next = new Node(key, value);
        }
        else
        {
            prev.next.val=value;
        }
        
    }
    
    public int get(int key) {
        
        int idx=idx(key);
        if(nodes[idx]==null) return -1;
        
        Node prev= find(nodes[idx], key);
        if(prev.next==null)
        {
            return -1;
        }
            return prev.next.val;
        
        
        
    }
    
    public void remove(int key) {
         int idx=idx(key);
        if(nodes[idx]==null) return;
         Node prev= find(nodes[idx], key);
        if(prev.next==null) return;
        prev.next=prev.next.next;
        
    }
        
        
    }

