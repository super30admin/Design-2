// This code works on a chaining model where each slot in the array of Nodes corresponds to a hashValue and in case of conflicts, it will create a chain of key value pairs to store it. 
class Node {
    int key, val;
    Node next;

    public Node(int key, int val) {
        this.key=key;
        this.val = val;
        this.next = null;
    }
}

class MyHashMap {

    Node[] nodes;

    public MyHashMap() {
        nodes = new Node[1000];
    }
    
    private int getHash(int key) {
        return key%1000;
    }

  // Utility method to get the previous node point to the node with key. Null if there isn't any available
    private Node getPrev(Node node, int key) {
        while(node.next!=null && node.next.key!=key) {
            node=node.next;
        }
        return node;
    }

  // Create a key value pair and update the value if its not available
    public void put(int key, int value) {
        int hashValue = getHash(key);
        Node node = nodes[hashValue];
        if(node == null) {
            Node dummy = new Node(-1, -1);
            dummy.next = new Node(key,value);
            nodes[hashValue] = dummy;
            return;
        }
        Node prevNode = getPrev(node, key);
        if(prevNode.next==null) {
            prevNode.next = new Node(key,value);
            return;
        }
        prevNode.next.val=value;
    }

    public int get(int key) {
        int hashValue = getHash(key);
        Node node = nodes[hashValue];
        if(node == null) {
            return -1;
        }
        Node prevNode = getPrev(node, key);
        if(prevNode.next==null) {
            return -1;
        }
        return prevNode.next.val;
    }
    
    public void remove(int key) {
        int hashValue = getHash(key);
        Node node = nodes[hashValue];
        if(node == null) {
            return;
        }
        Node prevNode = getPrev(node, key);
        if(prevNode.next==null) {
            return;
        }
        if(prevNode.next.next==null) {
            prevNode.next=null;
            return;
        }
        prevNode.next=prevNode.next.next;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
