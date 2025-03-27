// Time Complexity : O(1) for all operations.
// Space Complexity : O(n) , where N is the number of keys stored in the map
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
// Linear chaning is used as collision handling technique i.e using linked list
// When inserting an element into the Hash Map, first check if the value at that hash index is null. If yes create a new node and put the address of the node into the primary array.
// If not null, create a new node and check if it is present in the linked list, if not add it in the end. If yes just update its value.
// Get method will return -1 if the value at primary hash index is null as nothing is present.
// Otherwise, get the prev node using get prev and then using that get the current node and return the value
// To remove an element, first check if its primary hash index is null.
// If not null get the prev node using get prev
// then using that check if current node is null, that means there is nothing to remove.
// Else remove the current node and make its next null.
class MyHashMap {

    class Node{
        int key;
        int value;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

    }

    Node [] storage;
    int pSize;

    public MyHashMap() {
        this.pSize = 10000;
        this.storage = new Node[pSize];
    }

    private int getpHashIndex(int key){
        return key % pSize;
    }

    private Node getprev(Node head, int key) {
        Node prev = null;
        while(head != null && head.key != key ){
            prev = head;
            head = head.next;
        }
        return prev;
    }

    public void put(int key, int value) {
        int pIndex = getpHashIndex(key);
        if (storage[pIndex] == null){
            // New dummy node to be added to handle edge case created by the prev pointer.
            storage[pIndex] = new Node(-1, -1);
            storage[pIndex].next =  new Node(key, value);
            return;
        }
        Node prev = getprev(storage[pIndex],key);
        if(prev.next == null){
            prev.next =  new Node(key, value);
        }else{
            prev.next.value = value;
        }

    }

    public int get(int key) {
        int pIndex = getpHashIndex(key);
        if (storage[pIndex] == null) {
            return -1;
        }
        Node prev = getprev(storage[pIndex], key);
        if(prev.next == null){
            return -1;
        }
        return prev.next.value;

    }

    public void remove(int key) {
        int pIndex = getpHashIndex(key);
        if (storage[pIndex] == null){
            return;
        }
        Node prev = getprev(storage[pIndex], key);
        Node curr = prev.next;
        if(curr == null){
            return;
        }
        prev.next = curr.next;
        curr.next = null;

    }

}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */