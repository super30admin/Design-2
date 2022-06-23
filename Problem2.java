// Time Complexity :O(1)
// Space Complexity :
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class MyHashMap {
    
    class Node{
        int key, value;
        Node next;
        public Node(int key, int value){
            this.key=key;
            this.value=value;
        }
    }
    
    Node[] nodes;
    int buckets;

    //get bucket index
    private int getBucket(int key){
        return key % buckets;
    }
    
    private Node find(Node head, int key){
        Node prev=head;
        Node curr=head.next;
        //if current is not null and current key is not equal to passed key then add the element
        while(curr!=null && curr.key!=key){
            prev=curr;
            curr=curr.next;
        }
        //and return prev
        return prev;
    }

    public MyHashMap() {
        buckets=10000;
        nodes=new Node[buckets];
    }
    
    public void put(int key, int value) {
        int index=getBucket(key);
        if(nodes[index]==null){
            //dummy node
            nodes[index] = new Node(-1,-1);
        }
        Node prev=find(nodes[index],key);
        if(prev.next==null){
            prev.next=new Node(key,value);
        }
        else{
            prev.next.value=value;
        }
        
    }
    
    public int get(int key) {
        int index=getBucket(key);
        if(nodes[index]==null){
            return -1;
        }
        Node prev=find(nodes[index],key);
        if(prev.next==null){
            return -1;
        }
        return prev.next.value;
        
    }
    
    public void remove(int key) {
        int index=getBucket(key);
        if(nodes[index]==null){
            return;
        }
        Node prev=find(nodes[index],key);
        if(prev.next==null){
            return;
        }
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