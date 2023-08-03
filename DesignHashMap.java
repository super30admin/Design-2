// Time Complexity : put: O(1) amortized; get: O(1); remove: O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : removing head node from the primary array and store the next address we used Dummy Node to store the head address n using prev pointer to do all oprations.


// method 1 : burte force:  two lists; very complex
// method 2 : double hashing; failed due to collision (we have to store key,value pairs)
// method 3 : linear chaining; keep the size of the primary array n linked list in the optimized way possible to search/itearate 
// 300-400 range is smaller generally, problem was with removing inital head node/ first node from primary array.

class DesignHashMap {

    class Node{
        int key;
        int val;
        Node next;
        public Node ( int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    Node[] storage;
    int buckets;

    public DesignHashMap() {
        this.buckets = 10000;
        this.storage = new Node[buckets];
    }

    private int hash (int key){
        return key % buckets;
    }

    private Node find ( Node head, int key) {
        Node prev = null;
        Node curr =  head;
        while ( curr!= null && curr.key!=key ) {
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }
    
    public void put(int key, int value) {
        int bucket =hash(key);
        if(storage[bucket] == null) {
            // head node/ first entery in primary array
            storage[bucket] = new Node(-1,-1);
        }
        Node prev = find(storage[bucket], key);
        //case 1: node does not exist ; last node/tail
        if (prev.next == null){
            prev.next = new Node(key, value);
        }
        else {
            prev.next.val = value;
        }
    }
    
    public int get(int key) {
        int bucket = hash(key);
        if(storage[bucket] == null) return -1;
        Node prev = find( storage[bucket], key);
        if ( prev.next == null ) return -1;
        return prev.next.val;
    }
    
    public void remove(int key) {
        int bucket = hash(key);
        if( storage[bucket] == null) return;
        Node prev = find(storage[bucket],key);
        if(prev.next == null) return;
        prev.next = prev.next.next;
    }
}


