// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes Original code at the bottom.
// Your code here along with comments explaining your approach
class MyHashMap {
    // Define Node class
    class Node{
        int key;
        int value;
        Node next;
        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    // Define bucket array
    Node arr[];

    public MyHashMap() {
        //Intialize the bucket array
        arr = new Node[10000];
    }
    // Hash function
    public int hash(int key){
        return key%10000;
    }
    
    public void put(int key, int value) {
        int idx = hash(key);
        // If linkedList does not exist create it
        if(arr[idx]==null){
            arr[idx] = new Node(-1,-1);
        }
        Node prev = arr[idx];
        Node curr = prev.next;
        //Iterate through the list
        while(curr != null){
            // If key already existed, then replace its value
            if(curr.key == key){
                curr.value = value;
                return;
            }
            prev = curr;
            curr = curr.next;
        }
        // Insert a new node with key
        prev.next = new Node(key,value);
    }
    
    public int get(int key) {
        int idx = hash(key);
        //If linkedList does not exist return -1;
        if(arr[idx]==null){
            return -1;
        }
        Node prev = arr[idx];
        Node curr = prev.next;
        while(curr != null){
            if(curr.key == key){
                return curr.value;
            }
            prev = curr;
            curr = curr.next;
        }
        // If key did not exist return -1
        return -1;
    }
    
    public void remove(int key) {
        int idx = hash(key);
        //If linkedList does not exist do nothing;
        if(arr[idx]==null){
            return;
        }
        Node prev = arr[idx];
        Node curr = prev.next;
        while(curr != null){
            // If key exists, remove the reference to it.
            if(curr.key == key){
                prev.next = prev.next.next;
            }
            prev = curr;
            curr = curr.next;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */

 /**
  *Original code below. Got error - 
  java.lang.NullPointerException: Cannot read field "key" because "<local4>" is null
  at line 67, MyHashMap.remove
  at line 73, __Driver__.__helperSelectMethod__
  at line 93, __Driver__.__helper__
  at line 114, __Driver__.main
  
  The issue was - I was checking curr!=null || curr.key !=key in the same line, so was getting issue that curr is null so no key exist
  
class MyHashMap {
    
    class Node{
        int key;
        int value;
        Node next;
        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    Node arr[];

    public MyHashMap() {
        arr = new Node[10000];
    }
    public int hash(int key){
        return key%10000;
    }
    
    public void put(int key, int value) {
        int idx = hash(key);
        if(arr[idx]==null){
            arr[idx] = new Node(-1,-1);
        }
        Node prev = arr[idx];
        Node curr = prev.next;
        while(curr != null || curr.key != key){
            prev = curr;
            curr = curr.next;
        }
        if (curr == null){
            prev.next = new Node(key,value);
        }else{
            prev.next = new Node(key,value);
        }
    }
    
    public int get(int key) {
        int idx = hash(key);
        if(arr[idx]==null){
            return -1;
        }
        Node prev = arr[idx];
        Node curr = prev.next;
        while(curr.key != key){
            prev = curr;
            curr = curr.next;
        }
        return curr.value;
    }
    
    public void remove(int key) {
        int idx = hash(key);
        if(arr[idx]==null){
            return;
        }
        Node prev = arr[idx];
        Node curr = prev.next;
        while(curr.key != key){
            prev = curr;
            curr = curr.next;
        }
        prev.next = prev.next.next;
    }
}

  */