// Time Complexity :O(1)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//I used Link Chaining to complete this problem. I created the Node class that includes
// What will be stored in each node. Each array index will have a ref pointer to 
// a linked list of max 101 node. The first one is a dummy node in case the first
//node needs to be removed.s

class MyHashMap {
    class Node{
        int key;
        int val;
        Node next;
        public Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }
    Node[] store;
    int spots;

    public MyHashMap() {
        this.spots = 10000;
        this.store = new Node[spots];
    }

    private int hash(int key){ //O(1)
        return key % spots;
    }
    
    private Node find(Node head, int key){//O(1)
        Node curr = head;
        Node prev = null;
        while(curr != null && curr.key != key){
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }

    public void put(int key, int value) {//O(1)
        int bucket = hash(key);
        if(store[bucket] == null){
            store[bucket] = new Node(-1,-1);
        }
        Node prev = find(store[bucket], key);
        if(prev.next == null){
            prev.next = new Node(key, value);
        }else{
            prev.next.val = value;
        }
    }
    
    public int get(int key) {//O(1)
        int bucket = hash(key);
        if(store[bucket] == null) return -1;
        Node prev = find(store[bucket], key);
        if(prev.next == null) return -1;
        else{
            return prev.next.val;
        }


    }
    
    public void remove(int key) {//O(1)
        int bucket = hash(key);
        if(store[bucket] == null) return;
        Node prev = find(store[bucket], key);
        if(prev.next == null) return;
        else{
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