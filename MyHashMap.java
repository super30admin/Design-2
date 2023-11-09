import java.util.Arrays;

// Time Complexity :O(1)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//It utilizes an array of linked lists (buckets) to store key-value pairs,
// employing modular hashing to determine the index for insertion, retrieval, and deletion operations.
public class MyHashMap {
        Node[] storage;
        int buckets;
class Node{
    int key;
    int value;
    Node next;

    public Node(int key, int value){
        this.key = key;
        this.value = value;
    }
}

    public MyHashMap() {
        this.buckets = 10000;
        storage = new Node[buckets];
    }
    private int getHash(int key){
        return key % buckets;
    }

    private Node findPrev(Node head, int key){
        Node prev = null;
        Node curr = head;
        while(curr!=null && curr.key !=key){
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }
    // Prev gives the latest node
    public void put(int key, int value) {
        int hash = getHash(key);
        if(storage[hash] == null){
            storage[hash]= new Node(-1,-1);
            storage[hash].next = new Node(key, value);
        }else{
            Node prev = findPrev(storage[hash],key);
            if(prev.next == null){
                prev.next = new Node(key,value);
            }else{
                prev.next.value = value;
            }
        }
    }

    public int get(int key) {
        int hash = getHash(key);
        if(storage[hash] == null)return -1;
        Node prev = findPrev(storage[hash], key);
        if(prev.next == null) return -1;
        return prev.next.value;

    }

    public void remove(int key) {
        int hash = getHash(key);
        if(storage[hash] == null) return;
        Node prev = findPrev(storage[hash], key);
        if(prev.next == null) return;
        prev.next = prev.next.next;

    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */