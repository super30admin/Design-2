// This HashMap is implemented using seperate chain mechanism collision handling.
// Each time we input key, vale, a dummy node is created at the index which is the hashvalue of key and the new key,value pair is stored as a chain to the dummy node 
// Time complexity : O(L) where L is length of the chain 
// Space Complexity : Node Array is of size 10000 and each Node will have chains so O(n + l) 

class Node {
    int key;
    int val;
    Node next;
    Node(int key, int val){
        this.key = key;
        this.val = val;
        this.next = null;
    }
}
class MyHashMap {
    int bucket;
    private static final int maxSize = 10000;
    Node[] hashMap;

    int getBucket(int key){
        return key % 10000;
    }

    Node findNode(Node dummy, int key){
        Node curr = dummy;
        if(curr == null){
            return curr;
        }
        while(curr.next!=null && curr.next.key != key){
            curr = curr.next;
        }
        return curr;
    }

    public MyHashMap() {
        hashMap = new Node[maxSize];
    }
    
    public void put(int key, int value) {
        bucket = getBucket(key);
        if(hashMap[bucket] == null){
            hashMap[bucket] = new Node(-1,-1);
            hashMap[bucket].next = new Node(key, value);
        }
        else{
            Node prev = findNode(hashMap[bucket], key);
            if(prev.next == null){
                prev.next = new Node(key, value);
            }
            else {
                prev.next.val = value;
            }
        }

    }
    
    public int get(int key) {
        bucket = getBucket(key);
        if(hashMap[bucket] == null){
            return -1;
        }
        Node prev = findNode(hashMap[bucket], key);
        System.out.println(String.format("%d, %d", prev.key, prev.val));
        if(prev.next == null){
            return -1;
        }
        return prev.next.val;
    }
    
    public void remove(int key) {
        bucket = getBucket(key);
        Node prev = findNode(hashMap[bucket], key);
        if(prev == null){
            return;
        }
        if(prev.next == null){
            return;
        }
        prev.next = prev.next.next;

    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
