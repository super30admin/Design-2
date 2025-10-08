// Time Complexity :O(1)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no
class MyHashMap {
    int bucket;
    Node[] storage;

    class Node{
        int key;
        int value;
        Node next;
    
    Node(int key, int value){
        this.key = key;
        this.value = value;
    }}
    public MyHashMap() {
        this.bucket = 1000;
        this.storage = new Node[bucket];
    }
    private int getHash(int key){//find index
        return key%bucket;
    }
    private Node getPrev(Node head, int key){//to get to the previous node of key
        Node previous = null;
        Node current = head;
        while(current!=null && current.key!=key){
            previous = current;
            current = current.next;
        }
        return previous;
    }
    public void put(int key, int value) {
        int index = getHash(key);
        if(storage[index] == null){
            storage[index] = new Node(-1,-1); //dummy node in the beginning
            storage[index].next = new Node(key,value);
            return;
        }
        Node prev = getPrev(storage[index],key);
        if(prev.next == null){
            prev.next = new Node(key,value);//fresh node
        }
        else{
            prev.next.value = value;//existing node
        }
    }
    
    public int get(int key) {
        int index = getHash(key);
        if(storage[index] == null){
            return -1;//not found
        }
        Node prev = getPrev(storage[index],key);
        if(prev.next == null){
            return -1;//not found again
        }
        return prev.next.value;
        
    }
    
    public void remove(int key) {
        int index = getHash(key);
        if(storage[index] == null){
            return;//nothing to remove
        }
        Node prev = getPrev(storage[index],key);
        if(prev.next == null){
            return;//nothing to remove
        }
        Node current = prev.next;
        prev.next = current.next;
        current.next = null;//removing current node
        
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
