// Time Complexity : O(n) for queue, O(1)
// Space Complexity : O(n) for queue, O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach


import java.io.*;
import java.util.*;

class MyQueue {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2= new Stack<Integer>();;

    /** Initialize your data structure here. */
    public MyQueue() {


    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack1.push(x);

    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        int x ;
        while(!stack1.isEmpty()){
            stack2.add(stack1.pop());
        }
        x = stack2.pop();
        while(!stack2.isEmpty()){
            stack1.add(stack2.pop());

        }
        return x;


    }

    /** Get the front element. */
    public int peek() {
        int x ;
        while(!stack1.isEmpty()){
            stack2.add(stack1.pop());
        }
        x = stack2.peek();
        while(!stack2.isEmpty()){
            stack1.add(stack2.pop());

        }
        return x;

    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack1.empty();

    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */


import java.util.Arrays;

class MyHashSet {
    int[] array;
    /** Initialize your data structure here. */
    public MyHashSet() {
        array = new int[1000001];
        Arrays.fill(array, -1);

    }

    public void add(int key) {
        array[key] = 1;

    }

    public void remove(int key) {
        array[key] = -1;

    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        if (array[key] == 1){
            return true;

        }
        else{
            return false;
        }

    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */