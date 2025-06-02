// Time Complexity : O(1) for add, O(n) for get and remove
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach
class MyHashMap {
    Node[] storage;
    int Buckets;

    class Node{
        int key;
        int value;
        Node next;

        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    public MyHashMap() {
        this.Buckets = 1001;
        this.storage = new Node[Buckets];
    }
    
    public int getHash(int key) {
        return (2*key)%Buckets;
    }

    public Node getPrev(Node head,int key){
        Node curr = head;
        Node prev = null;
        while(curr != null && curr.key != key){
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }

    public void put(int key, int value) {
        int idx = getHash(key);
        if(storage[idx] == null){
            storage[idx] = new Node(-1, -1);
            storage[idx].next = new Node(key, value);
            return;
        }

        Node prev = getPrev(storage[idx],key);
        if(prev.next == null){ 
            prev.next = new Node(key, value);
        }else{ 
            prev.next.value = value;
        }
    }
    
    public int get(int key) {
        int index = getHash(key);
        if(storage[index] == null) return -1;
        Node prev = getPrev(storage[index], key);
        if(prev.next == null) return -1;
        return prev.next.value;
    }
    
    public void remove(int key) {
        int index = getHash(key);
        if(storage[index] == null) return;
        Node prev = getPrev(storage[index], key);
        if(prev.next == null) return;
        Node curr = prev.next;
        prev.next = curr.next;
        curr.next = null;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
