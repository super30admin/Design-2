//Time complexity: O(1)
//Space Complexity:O(n)
//Code executed successfully on Leetcode : yes 

class MyHashMap {
    class Node{
        int key;
        int value;
        Node next;
        public Node(int key, int value)
        {
            this.key= key;
            this.value=value;
            this.next=null;
        }
    }

     Node storage [];

    public MyHashMap() {
        this.storage = new Node[10000];   
    }
    private int hash(int key)
    {
        return key%10000;
    }

    private Node find(Node head, int key)
    {
        Node prev = head ;
        Node curr= head.next;
        while(curr!=null && curr.key!=key)
        {
            prev = curr;
            curr= prev.next;
        }
        return prev;
    }
    
    public void put(int key, int value) {
        int idx = hash(key);
        if(storage[idx]==null){
            storage[idx]= new Node(-1,-1);
        }
        Node prev =find(storage[idx],key);
        if(prev.next==null){
            prev.next = new Node(key, value);
        }
        prev.next.value= value;
        
    }
    
    public int get(int key) {
        int idx = hash(key);
        if(storage[idx]==null) return -1;
        Node prev =find(storage[idx],key);
        if(prev.next==null) return -1;
        return prev.next.value;

    }
    
    public void remove(int key) {
        int idx = hash(key);
        if(storage[idx]==null)
        return ;
        Node prev =find(storage[idx],key);
        if(prev.next==null) return;
        prev.next=prev.next.next;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
