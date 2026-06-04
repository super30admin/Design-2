// Time Complexity :  O(1) average
// Space Complexity :O(n + 10000)
// Did this code successfully run on Leetcode : yes 
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class MyHashMap {

    class Node{
        int key, val;
        Node next;

        public Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }

    private Node[] storage;

    public MyHashMap() {
        this.storage = new Node[10000];
    }

    public int hash(int key){
        return key%10000;
    }

    public Node find(Node head, int key){
        Node prev = null;
        Node curr = head;
        while(curr != null && curr.key != key){
            prev = curr;
            curr = curr.next;
        }

        return prev;
    }
    
    public void put(int key, int value) {
        int idx = hash(key);
        if(storage [idx] == null){
            storage[idx] = new Node(-1,-1);
        }

        Node prev = find(storage[idx], key);
        if(prev.next !=null){
            prev.next.val = value;
        }else{
            prev.next = new Node(key,value);
        }
    }
    
    public int get(int key) {
        int idx = hash(key);
        if(storage[idx] == null) return -1;
        Node prev = find(storage[idx], key);
        
        if(prev.next !=null){
           return  prev.next.val;
        }

        return -1;
    }
    
    public void remove(int key) {
        int idx = hash(key);
        if(storage[idx] == null){
            return;
        }
        Node prev = find(storage[idx], key);
        if(prev.next == null){
            return;
        }
        prev.next = prev.next.next;
    }
}

