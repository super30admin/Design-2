//Time complexity - put O(L), get O(L), remove O(L)
//Space complexity - O(n)

// Use seperate chaining to use linked list on each array node to handle collision.
class MyHashMap {

    class Node{
        int key, value;
        Node next;
        public Node(int key, int value){
            this.key = key;
            this.value = value;

        }
    }

    int buckets;
    Node[] storage;
    
    // get the bucket in array
    int getBucket(int key){
        return Integer.hashCode(key)%this.buckets;
    }

    public MyHashMap() {
        this.buckets = 1000;
        this.storage = new Node[this.buckets];
    }

    // creating a reusable method to navigate through linked list to find node
    Node find(Node dummy, int key){
        Node prev = dummy;
        Node curr = dummy.next;
        while(curr!=null && curr.key!=key){
            prev = curr;
            curr = curr.next;
        }

        return prev;
    }

    // inserting new node after finding bucket and reusing find method to locate element
    public void put(int key, int value) {
        int bucket = getBucket(key);
        if(storage[bucket]==null){
            storage[bucket] = new Node(-1,-1);
        }

        Node prev = find(storage[bucket], key);
        if(prev.next==null){
            prev.next = new Node(key,value);
        }

        prev.next.value = value;

    }
    
    // to get node reuse the find method and return node otherwise return -1
    public int get(int key) {
        int bucket = getBucket(key);
        if(storage[bucket]==null){
            return -1;
        }
        Node prev =  find(storage[bucket], key);

        if(prev.next!=null){
            return prev.next.value;
        }
        return -1;
    }
    
    // to delete node point to previous node to next of next node.
    public void remove(int key) {
        int bucket = getBucket(key);
        if(storage[bucket]==null){
            return;
        }
        Node prev =  find(storage[bucket], key);

        if(prev.next!=null){
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