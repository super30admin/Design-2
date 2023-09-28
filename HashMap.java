// Time Complexity :
// * The maximum time may be required is the traversal of the linked list in the array, which may be 'O(100)' in this search functions case, which is eventually O(1)
// * All the other functions not using don't have any traversal and thus have O(1) time complexity

// Space Complexity :
// * It is O(n) which is for creating the inital Node  array, all other functions have O(!) space complexity

// Did this code successfully run on Leetcode : Ran succesfully on Leetcode
// Any problem you faced while coding this : 


// Your code here along with comments explaining your approach

// We maintain an initial array of type Node
// We then link each index of the array to a linked list which stores the key value pairs of all the keys that have that index's value on hashing
// For searching we maintain two pointers

class MyHashMap {

    private int mainArrSize;
    private Node[] storageArr;

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
        this.mainArrSize = 1000;
        this.storageArr = new Node[mainArrSize];
    }

    public void put(int key, int value) {
        int hashVal = hash(key);
        if(storageArr[hashVal] == null){
            storageArr[hashVal] = new Node(-1,-1);
        }

        Node prev = search(storageArr[hashVal],key);
        if(prev.next == null){
            prev.next = new Node(key,value);
        }else{
            prev.next.value = value;
        }
    }

    public int get(int key) {
        int hashVal = hash(key);
        if(storageArr[hashVal] == null) return -1;

        Node prev = search(storageArr[hashVal],key);
        if(prev.next == null){
            return -1;
        }else{
            return prev.next.value;
        }
    }

    public void remove(int key) {
        int hashVal = hash(key);
        if(storageArr[hashVal] == null) return;

        Node prev = search(storageArr[hashVal],key);
        if(prev.next == null) return;
        Node temp = prev.next;
        prev.next = temp.next;
        temp.next = null;

    }

    public Node search(Node head, int key){
        Node prev = null;
        Node curr = head;

        while(curr!=null && curr.key!=key){
            prev = curr;
            curr = curr.next;
        }

        return prev;
    }

    public int hash(int val){
        return val%1000;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */