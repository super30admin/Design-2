// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : No


//Question: https://leetcode.com/problems/design-hashmap/description/
//Design a HashMap without using any built-in hash table libraries.

// Your code here along with comments explaining your approach
// HashMap is a key value pair DS, we will implement this using LinkedList


class MyHashMap {


    class Node{
        int key, value;
        Node nextNode;
        public Node(int k, int v){
            this.key = k;
            this.value = v;
        }
    }
    //Consider 10 to the power 4 buckets and each bucket will have a Node(LinkedList) storage that will be referenced with the key and will contain value
    int buckets; 
    Node[] storage;
    public MyHashMap() {
        buckets = 10000; 
        storage = new Node[buckets];
    }

/*
 * Find method is used to find the node with a specific key, Define a pointer to previous node and current to next of previous
 * eg: at bucket 2 we have 3 node prev ->[2,1], current->[1002,4], [2002,6] 
 */
    public Node find(Node dummy, int key){
        Node prev = dummy;
        Node current = dummy.nextNode;

        while(current != null && current.key != key){
            prev = current;
            current = current.nextNode;
        }
      return prev;
    }

/*
 * getBucket is a function to generate the hashed value of each key - Integer.hashCode is inbuilt method we can also do key%buckets
 */
    public int getBucket(int key) {
        return Integer.hashCode(key) % buckets;
    }
    

/*
 * put method is to add new node to the storage, First gettheBucket hashed index then 
 * check if there is any node present at that hashedIndex if not then create a dummy node with [-1,-1]
 * Once it's created find the node with same value, if not present add new node with key and value
 * if key s present then update the value
 */
    public void put(int key, int value) {
        int bucket = getBucket(key);
        if(storage[bucket] == null){
            storage[bucket] = new Node(-1,-1);
        }
        Node prev = find(storage[bucket], key);
        if(prev.nextNode == null){
            prev.nextNode = new Node(key, value);
        }else{
            prev.nextNode.value = value;
        }

    }
    
/*
 * get method is to get the value of given key
 * get the hashedindex or bucket no key node found then return -1
 * find the node with the key if no prev.nextNode found is null return -1
 * else node found return the value
 */
    public int get(int key) {
        int bucket = getBucket(key);
        if(storage[bucket] == null){
            return -1;
        }
        Node prev = find(storage[bucket], key);
        if(prev.nextNode == null){
            return -1;
        }
        return prev.nextNode.value;
    }
    
/*
 * remove the node, find the hashIndex, if no index found then return
 * else find the node with key, if prev.next is null then return
 * else node found update the pointers
 */
    public void remove(int key) {
        int bucket = getBucket(key);
        if(storage[bucket] == null){
            return;
        }
        Node prev = find(storage[bucket], key);
        if(prev.nextNode == null){
            return;
        }
        prev.nextNode = prev.nextNode.nextNode;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */