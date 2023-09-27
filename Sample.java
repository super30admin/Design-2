// Time Complexity :O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : faced few null pointer excpetion. 
// First tried using list of arrays without collison handling. Later used List of nodes which can keep nodes. 
// If nodes having same hash- it will link new node to the existing node.

// Your code here along with comments explaining your approach

class Node {
    int key, value;
    Node next;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }
}

class MyHashMap {
    int size = 1000;
    Node[] nodeList;

    public MyHashMap() {

        if (nodeList == null) {
            this.nodeList = new Node[size];
        }
    }

    public int hash(int key) {
        return key % size;
    }

public void put(int key, int value) {  
    int index = hash(key);  
    Node newNode = new Node(key, value);  
    Node current = nodeList[index];  
      
    if (current == null) {  
        nodeList[index] = newNode;  
        return;  
    }  
      
    if (current.key == key) {  
        current.value = value;  
        return;  
    }  
      
    while (current.next != null) {  
        if (current.next.key == key) {  
            current.next.value = value;  
            return;  
        }  
        current = current.next;  
    }  
      
    current.next = newNode;  
}  

    

    public int get(int key) {
        int index = hash(key);
         Node current = nodeList[index];
         while(current != null){
                if (current.key == key) {
                return current.value ;
                }
            current = current.next;
         }
        return -1;
    }

    public void remove(int key) {
        int index = hash(key);
        Node current = nodeList[index];
        Node previous = null;
        while(current != null){
            if(current.key == key){
            if (previous == null){
                nodeList[index] = current.next;
            } else{
                previous.next = current.next;
            }
            return;
        }
        previous = current;
        current = current.next;
    }
    }
}
