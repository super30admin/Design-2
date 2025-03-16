// Time Complexity : O(1)   -> amortized complexity for all operations
// Space Complexity : O(n) -> store buckets
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no problems faced
// Approach - Node class is created to store each key value pair in linkedlist format. Basically linear chaining is used with Node[] as primary bucket storage and each bucket having a linkedlist. Hash is ger=nerated with % function. getPrev helper function is created to get prev node in linkedlist for all put, get, remove operations.

public class MyHashMap {

    //linear chaining -> array main, for each primaryIndex create linkedLists
    Node[] storage;
    int buckets;

    private class Node {
        int key;
        int value;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    public MyHashMap() {
        this.buckets = 10000;
        this.storage = new Node[this.buckets];
    }

    private int getPrimaryHashKey(int key) {
        return key % this.buckets;
    }

    private Node getPrev(Node head, int key) {
        Node prev = null;
        Node curr = head;   //iterators
        while(curr != null && curr.key != key) {
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }

    public void put(int key, int value) {
        int primaryIndex = getPrimaryHashKey(key);
        if(this.storage[primaryIndex] == null) {
            //create dummy node first
            this.storage[primaryIndex] = new Node(-1, -1);
            this.storage[primaryIndex].next = new Node(key, value);
        }
        Node prev = getPrev(this.storage[primaryIndex], key);
        if(prev.next == null) { //key is not present
            prev.next = new Node(key, value);
        } else {    //key is present then update the value
            prev.next.value = value;
        }
    }

    public int get(int key) {
        int primaryIndex = getPrimaryHashKey(key);
        if(this.storage[primaryIndex] == null) {    //bucket empty
            return -1;
        }
        Node prev = getPrev(this.storage[primaryIndex], key);
        if(prev.next == null) { //end of list ie key not found
            return -1;
        } else {
            return prev.next.value;
        }
    }

    public void remove(int key) {
        int primaryIndex = getPrimaryHashKey(key);
        if(this.storage[primaryIndex] == null) {    //bucket empty
            return;
        }
        Node prev = getPrev(this.storage[primaryIndex], key);
        if(prev.next == null) { //key not found return
            return;
        }
        prev.next = prev.next.next;
    }

    public static void main(String[] args) {
        MyHashMap myHashMap = new MyHashMap();

        myHashMap.put(1, 10);
        myHashMap.put(2, 20);
        myHashMap.put(2, 25);

        System.out.println("Get key 1: " + myHashMap.get(1));
        System.out.println("Get key 2: " + myHashMap.get(2));
        System.out.println("Get key 3: " + myHashMap.get(3));

        myHashMap.remove(2);
        System.out.println("After removing key 2, get key 2: " + myHashMap.get(2));
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */