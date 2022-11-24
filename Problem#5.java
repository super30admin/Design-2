// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : -


// Your code here along with comments explaining your approach

//Hash Map using Linear Chaining

//Initialize Node class
class Node{

    int key;
    int val;
    Node next;

    //Node constructor to initialize key and value
    public Node(int key, int val){
        this.key = key;
        this.val = val;
    }
}

class MyHashMap {

    private Node[] storage; //Primary data structure
    int buckets; //Variable to hold the length of the primary data structure

    public MyHashMap() {
        this.buckets = 10000; 
        this.storage = new Node[this.buckets]; //Initialize 10000 buckets
    }
    
    // Time Complexity : O(n)
    // Space Complexity : O(1)
    private Node find(Node head, int key){
        Node curr = head; //curr will be used to loop through the ll. Start looping from the head
        Node prev = null; //prev will hold the value of the previous node, initially it is null
        while(curr != null && curr.key != key){ //continue interating as long as the end is not reached and the key is not found
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }
    
    private int hashFunc(int key){
        return key % this.buckets; //Hash function to find which bucket they key, value pair should be placed in
    }

    // Time Complexity : O(n)
    // Space Complexity : O(1)
    public void put(int key, int value) {
        int bucket = hashFunc(key); //Find the correct bucket for the input key
        if(storage[bucket] == null){ //If the bucket has not been initialized yet
            storage[bucket] = new Node(-1, -1); //Initialize it with a dummy node(-1, -1) which will be useful when we are asked to pop the first node in the linked it as the find method returns only the prev node
        }
        Node prev = find(storage[bucket], key); //find the prev node after which the key, value pair has to be put in the hashmap
        if(prev.next == null){ //If there is no key in the ll
            prev.next = new Node(key, value); //Create a new node
        } else {
            prev.next.val = value; //Update the existing value if the corresponding key is found
        }
    }
    
    // Time Complexity : O(n)
    // Space Complexity : O(1)
    public int get(int key) {
        int bucket = hashFunc(key); //Find the correct bucket for the input key
        if(storage[bucket] == null){ //If the bucket itself has not been initialized yet
            return -1;
        }
        Node prev = find(storage[bucket], key); //find the prev node before which the key is found
        if(prev.next == null){ //Return if there is no matching key in the ll
            return -1;
        } else {
            return prev.next.val; //Return the corresponding value if key is found
        }
    }
    
    // Time Complexity : O(n)
    // Space Complexity : O(1)
    public void remove(int key) {
        int bucket = hashFunc(key); //Find the correct bucket for the input key
        if(storage[bucket] == null){ //Return if the bucket itself has not been initialized yet
            return;
        }
        Node prev = find(storage[bucket], key);  //find the prev node before which the key is found and has to be removed
        if(prev.next == null){ //Return if there is no matching key in the ll
            return;
        } else { 
            prev.next = prev.next.next; //If key is found, link the prev node to the node after the key node. Key node now becomes an orphan node
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