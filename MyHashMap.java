// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach : Using linkedlist. And storing heads of the linked list into array.


class MyHashMap {
    
    class Node{
        int key,value;
        Node next;
        
        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    
    Node buckets[];

    public MyHashMap() {
        buckets = new Node[10000];
    }
    
    private Node findNode(Node head, int key){
        Node prev = head;
        Node curr = head.next;
        
        while(curr!= null && curr.key != key){
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }
    
    private int getHash(int key){
        return Integer.hashCode(key) % 10000;
    }
    
    public void put(int key, int value) {
        int bucket = getHash(key);
        
        if(buckets[bucket] == null){
            buckets[bucket] = new Node(-1,-1); 
        }
        
        Node prev = findNode(buckets[bucket],key);
        
        if(prev.next == null){
            prev.next = new Node(key,value);
        }
        else{
            prev.next.value = value;
        }
        
    }
    
    public int get(int key) {
        
        int bucket = getHash(key);
        
        if(buckets[bucket] == null){
          return -1;
        }
        
        Node prev = findNode(buckets[bucket],key);
        
        if(prev.next == null){
            return -1;
        }
            return prev.next.value;
        
        
    }
    
    public void remove(int key) {
        int bucket = getHash(key);
        
        if(buckets[bucket] == null){
            return;
        }
        
        Node prev = findNode(buckets[bucket],key);
        
        if(prev.next == null){
            return;
        }
        prev.next = prev.next.next;
    }

    public static void main(String args[]){
    MyHashMap obj = new MyHashMap();
    obj.put(1,1000);
    System.out.println(obj.get(1));
    obj.remove(1);
    }
}

