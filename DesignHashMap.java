// TC - O(1) amortized - the main contributor towards any time complexity is the find method that iterates over each element one by one, O(100) in average case if keys are spread evenly. Also, if each key collides and falls in the same bucket, then worst case TC would be O(n) but the chances of that happening are slightly less here
// SC - O(k+B) where k is num of elements actually added to the hashmap, and B = num of buckets we chose for primary array (10000 in this case)
// Ran on Leetcode - Yes
// Mistake made - still not confident, need to review, especially the find/dummy node logic

class MyHashMap {
    // DS holding the key/value pair 
    class Node{
        int key;
        int val;
        Node next;

        Node(int key, int val){
            this.key = key;
            this.val = val;
            this.next = null;
        }
    }

    Node[] storage; // stores the primary array that gets us to the appropriate bucket after hashing once
    public MyHashMap() {
        this.storage = new Node[10000];
        // Note - in HashSet, we had created primary array of size 1000, but since we are implementing this one with linkedlist for secondary array, finding the next element might take a bit longer since we will have to iterate over each element, so, to reduce the num of hops we make on a linkedlist when finding a key/value pair, we make the primary array hold 10000 buckets and each bucket ideally will hold 100 k/v pairs (assuming keys in range of 0 to 1 million)
    }
    
    // hash function returning the bucket index in primary array
    private int hash(int key){
        return key % 10000;
    }

    // helper function to find the node right before the node with the key, OR the last node if key is not found
    private Node find(Node head, int key){
        Node prev = null;
        Node curr = head;

        while(curr != null && curr.key != key){
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }
    
    public void put(int key, int value) {
        // find index of bucket
        int index = hash(key);
        if(storage[index] == null){
            // Remember this - very very important!!
            // Why create dummy node? because if we want to remove something at start of the list, we need the node prev to it to be able to update next pointers
            // Also we are choosing -1 for dummy because the constraints allow us to do so. If negative keys were also allowed, we would have to choose something else for the dummy node key
            storage[index] = new Node(-1, -1); // create dummy node at start
        }
        Node head = storage[index];
        // find prev node
        Node prev = find(head, key);
        // if key exists, update its value
        if(prev.next != null){ // key exists
            prev.next.val = value;
        }
        // if not, create new node and append at end of list
        else{
            Node node = new Node(key, value);
            prev.next = node;
        }
    }
    
    public int get(int key) {
        // find bucket
        int index = hash(key);
        // if null, return -1
        if(storage[index] == null) return -1;
        // else find the prev node
        Node head = storage[index];
        Node prev = find(head, key);
        // if prev.next != null, return prev.next.val
        if(prev.next != null){
            return prev.next.val;
        }
        // else return -1
        return -1;
    }
    
    public void remove(int key) {
        int index = hash(key);
        if(storage[index] == null) return; // key not found

        Node head = storage[index];
        Node prev = find(head, key);
        // key not found
        if(prev.next == null) {
            return;
        }
        // key found
        else{
            Node curr = prev.next;
            prev.next = curr.next; // update prev.next to point to the current key's next
            curr.next = null; // remove the next ptr of curr to remove from LL
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
