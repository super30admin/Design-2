// Time Complexity :O(1)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Learnt the hashmap data structure


// Your code here along with comments explaining your approach

class MyHashMap {

    //array of nodes(linkedlist)
    LinkedList<Node>[] bucket;
    public static int size = 1000; //initial size
    public MyHashMap() {
        bucket = new LinkedList[size];
    }


    public void put(int key, int value) {
        int hash = key % size; //hash function
        //if array value is null, create a new linkedlist else find the node and update the value
        if(bucket[hash] == null) {
            bucket[hash] = new LinkedList<Node>();
            bucket[hash].add(new Node(key, value));
        }
        else {
            for(Node node : bucket[hash]){
                if(node.key == key){
                    node.val = value;
                    return;
                }
            }
            bucket[hash].add(new Node(key, value));
        }
    }

    public int get(int key) {
        int hash = key % size;
        LinkedList<Node> nodes = bucket[hash];
        if(nodes == null) return -1;
        //iterate through the nodes to find the right node value using key
        for(Node node : nodes) {
            if(node.key == key) return node.val;
        }
        return -1;
    }

    public void remove(int key) {
        int hash = key % size;
        Node tempNode = null;
        if(bucket[hash] == null) return; //if array value is null, nothing to find
        else {
            //if node key is equal to whatever we are trying to find, put that to a temporary node and then remove the temporary node
            for(Node node : bucket[hash]){
                if(node.key == key) {
                    tempNode = node;
                }
            }
            if(tempNode == null) return;
            bucket[hash].remove(tempNode);
        }
    }
}


//Create LinkedList node class
class Node {
    public int key;
    public int val;

    public Node(int key, int val){
        this.key = key;
        this.val = val;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */