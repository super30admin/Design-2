// Time Complexity : O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// When using linked lists, instead of going for sqrt of max number rule, lets go with 10^4 as primary array and 10^2 size of secondary array
// The above is because to make the add(), remove() and get() to O(1) as average Time complexity
class MyHashMap {
    class Node {
        int key;
        int val;
        Node next;

        public Node (int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    int buckets;
    Node[] storage;

    public MyHashMap() {
        this.buckets = 10000;
        this.storage = new Node[buckets];
    }
    
    private int hash(int key){
        return key%buckets;
    }

    public Node find(Node head, int key) {
        Node prev = null;
        Node curr = head;
        while(curr != null && curr.key != key) {
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }

    public void put(int key, int value) {
        int bucket = hash(key);
        if(storage[bucket] == null) {
            storage[bucket] = new Node(-1, -1);
        }
        Node prev = find(storage[bucket], key);
        if(prev.next == null) {
            //Case1: If node do not exist
            prev.next = new Node(key, value);
        } else {
            //Case2: If node exists
            prev.next.val = value;
        }
    }
    
    public int get(int key) {
        int bucket = hash(key);
        if(storage[bucket] == null) {
            return -1;
        }
        Node prev = find(storage[bucket], key);
        if(prev.next == null) {
            return -1;
        } else {
            return prev.next.val;
        }
    }
    
    public void remove(int key) {
        int bucket = hash(key);
        if(storage[bucket] == null) return;
        Node prev = find(storage[bucket], key);
        if(prev.next == null) {
            return;
        } else {
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
 int map;
    int keys;
    int[][] storage;

    public MyHashMap() {
        this.map = 1000;
        this.keys = 1000;
        this.storage = new int[map][];
    }
    
    private int hash1(int key){
        return key%1000;
    }

    private int hash2(int key){
        return key/1000;
    }

    public void put(int key, int value) {
        int mapIndex = hash1(key);
        int keyIndex = hash2(key);
        if(storage[mapIndex] == null) {
            if(mapIndex == 0) {
                storage[mapIndex] = new int[keys+1];
            } else {
                storage[mapIndex] = new int[keys];
            }
            Arrays.fill(storage[mapIndex], -1);
        }
        storage[mapIndex][keyIndex] = value; 
    }
    
    public int get(int key) {
        int mapIndex = hash1(key);
        int keyIndex = hash2(key);
        if(storage[mapIndex] == null) {
            return -1;
        } else {
            return storage[mapIndex][keyIndex];
        }
        
    }
    
    public void remove(int key) {
        int mapIndex = hash1(key);
        int keyIndex = hash2(key);
        if(storage[mapIndex] != null) {
            storage[mapIndex][keyIndex] = -1;
        }
        
    }
}
 */