// Design Hashmap (https://leetcode.com/problems/design-hashmap/)

// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach in three sentences only
class MyHashMap {
    class Node{
        int key;
        int value;
        Node next; 
        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    Node[] storage;
    int buckets;
    

    public MyHashMap() {
        this.storage = new Node[10000];
    }

    public int hashFunction(int key){
        return key%10000;
    }

    private Node search(Node head, int key){
        //gives the prev node to curr key we are searching
        Node prev = head;
        Node curr = head.next;
        while(curr!=null&&curr.key !=key){
            prev = curr;
            curr = curr.next;
        }
        return prev;

    }
    
    public void put(int key, int value) {
        int idx = hashFunction(key);
        if(storage[idx]==null){
            storage[idx] = new Node(-1,-1);
        }
        Node prev = search(storage[idx], key);
        if(prev.next!=null){ //here prev.next is current element address
            prev.next.value = value;
        }
        else{
            prev.next = new Node(key, value);
        }
    }
    
    public int get(int key) {
        int idx = hashFunction(key);
        if(storage[idx]==null)return -1;
        Node prev = search(storage[idx], key);
        if(prev.next==null)return -1;
        else return prev.next.value;
    }
    
    public void remove(int key) {
        int idx = hashFunction(key);
        if(storage[idx]==null){
            return;
        }
        Node prev = search(storage[idx], key);
        if(prev.next==null) return;
        Node temp = prev.next;
        prev.next = temp.next;
        temp.next = null;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */