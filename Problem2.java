// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class MyHashMap{

    class Node{
        int key, value;
        Node next;
        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    int buckets;
    Node[] nodes;

    public MyHashMap(){
        buckets = 10000;
        nodes = new Node[buckets];
    }

    private Node find(Node head, int key){
        Node pre = head;
        Node curr = head.next;
        while(curr != null && curr.key != key){
            pre = curr;
            curr = curr.next;
        }
        return pre;
    }
    
    private int getHash(int key){
        return Integer.hashCode(key) % buckets;
    }

    public void put(int key, int value){
        int index = getHash(key);
        if(nodes[index] == null){
            nodes[index] = new Node(-1, -1);
        }
        Node pre = find(nodes[index], key);
        if(pre.next == null){
            pre.next = new Node(key, value);
        }
        else{
            pre.next.value = value;
        }
    }

    public int get(int key){
        int index = getHash(key);
        if(nodes[index] == null){
            return -1;
        }
        Node pre = find(nodes[index], key);
        if(pre.next == null){
            return -1;
        }
        return pre.next.value;
    }

    public void remove(int key){
        int index = getHash(key);
        if(nodes[index]== null){
            return;
        }
        Node pre = find(nodes[index], key);
        if(pre.next == null){
            return;
        }
        pre.next = pre.next.next;
    }
    
    public static void main(String[] args) {
        MyHashMap myHashMap = new MyHashMap();
        myHashMap.put(1, 1); 
        myHashMap.put(2, 2); 
        myHashMap.get(1);    
        myHashMap.get(3);    
        myHashMap.put(2, 1); 
        myHashMap.get(2);    
        myHashMap.remove(2); 
        myHashMap.get(2);   
    }
}