// Time Complexity : O(1) or takes the max of linked list length (here it is 100)
// Space Complexity : O(n) or ideally the space increases as the number of inputs as we are using a linked list
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach

class MyHashMap {
    int buckets;
    class Node {
        int key, value ;
        Node next;
        //constructor Node
        public Node(int key, int value ){
            this.key =key;
            this.value = value;
        }
    }
    Node[] nodes ;
    //constructor HashMap
    public MyHashMap() {
        buckets=10000;
        nodes = new Node[buckets];
    }
    //Hashing to get Bucket value
    private int getBucket(int key){
        return Integer.hashCode(key)%buckets;
    }
    //method to find previous node to target;
    private Node findNode(Node head, int key){
        Node prev = head;
        Node curr = head.next;
        while(curr!=null && curr.key!=key){
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }

    //
    public void put(int key, int value) {
        int bucket = getBucket(key);
        if(nodes[bucket]==null)
            nodes[bucket]=new Node(-1,-1);
        Node prev = findNode(nodes[bucket], key);
        if(prev.next==null){
            prev.next = new Node(key,value);
            return;
        }
        prev.next.value= value;
        return;
    }

    public int get(int key) {
        int bucket  = getBucket(key);
        if(nodes[bucket]==null)
            return -1;
        Node prev = findNode(nodes[bucket], key);
        if(prev.next == null)
            return -1;
        return prev.next.value;

    }

    public void remove(int key) {
        int bucket = getBucket(key);
        if(nodes[bucket]==null)
            return ;
        Node prev = findNode(nodes[bucket], key);
        if(prev.next==null)
            return ;
        prev.next = prev.next.next;
        return ;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */