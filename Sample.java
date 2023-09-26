// ## Problem 1: (https://leetcode.com/problems/implement-queue-using-stacks/)
// Time Complexity : O(1) for push and empty 0(n) for pop and peek - it has to pop and peek all the elements from one stack to another in worst case
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : I didnt face any problem while coding this.

// Your code here along with comments explaining your approach
class MyQueue {
    
    Stack<Integer> s1;
    Stack<Integer> s2;
    
    //Initializing the stack data structure
    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }
    
    //Pushing the element x to the stack
    public void push(int x) {
       s1.push(x); 
    }
    
    //Popping the element - first in first out from the queue & return the element
    //To pop the first element as we are implementing queue data structure, check whether s1 size is greater
    //than 0, if so pop the element to the another stack s2 until it is greater than 0, then pop the first element and store it the new value and return it.
    public int pop() {
        while(s1.size() > 1){
            s2.push(s1.pop());
        }
        int popVal = s1.pop();
        while(!s2.isEmpty()){
            s1.push(s2.pop());
        }
        return popVal;
    }
    
    //Peek the first element
    //To peek the first element as we are implementing queue data structure, check whether s1 size is greater
    //than 0, if so pop the element to the another stack s2 until it is greater than 0, then peek the first element and store it the value and return it.
    public int peek() {
        while(s1.size() > 1){
            s2.push(s1.pop());
        }
        int peekVal = s1.peek();
        while(!s2.isEmpty()){
            s1.push(s2.pop());
        }
        return peekVal;
    }
    
    //To check whether queue is empty
    public boolean empty() {
        return s1.isEmpty();
    }
}

// ## Problem 2: Design Hashmap (https://leetcode.com/problems/design-hashmap/)
// Time Complexity : O(n)
// Space Complexity : O(n+m) - bucket max size and num of entries in the hashMap
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : This was little challenging to work on. 
// Implementing the linked list, checking the hash bucket using modulo operation for 
// mapping key to specific bucket.

// Your code here along with comments explaining your approach

import java.util.LinkedList;

class MyHashMap {
    //to store the key value pair
    private LinkedList<HashEntry>[] hashMap;
    private static final int maxSize = 769;

    //Initializing the data structure
    public MyHashMap() {
        hashMap = new LinkedList[maxSize];
    }
    
    //Take the key value pair and adds or updates the value associated with it
    public void put(int key, int value) {
        //check the hash bucket for the key
        int bucket = key % maxSize;
        if (hashMap[bucket] == null) {
            //if bucket empty new linked list created and added as key-value
            hashMap[bucket] = new LinkedList<>();
            hashMap[bucket].add(new HashEntry(key, value));
        } else {
            //check if the key is found, updated the value with it
            for (HashEntry entry : hashMap[bucket]) {
                if (entry.key == key) {
                    entry.value = value;
                    return;
                }
            }
            //New entry added
            hashMap[bucket].add(new HashEntry(key, value));
        }
    }
    //Takes key and returns value associated with it
    public int get(int key) {
        int bucket = key % maxSize;
        LinkedList<HashEntry> entry = hashMap[bucket];
        if (entry == null) {
            return -1;
        }
        for (HashEntry e : entry) {
            if (e.key == key) {
                return e.value;
            }
        }
        return -1;
    }
    
    //Takes key and remove the key and value associated with that key
    public void remove(int key) {
        int bucket = key % maxSize;
        LinkedList<HashEntry> entry = hashMap[bucket];
        if (entry == null) {
            return;
        } else {
            HashEntry removeVal = null;
            for (HashEntry e : entry) {
                if (e.key == key) {
                    removeVal = e;
                    break;
                }
            }
            if (removeVal != null) {
                hashMap[bucket].remove(removeVal);
            }
        }
    }
}
//key-value pair HashEntey in the hash map
class HashEntry {
    public int key;
    public int value;

    public HashEntry(int key, int value) {
        this.key = key;
        this.value = value;
    }
}