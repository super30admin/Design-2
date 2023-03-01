import java.util.Arrays;
import java.util.Stack;

// Time Complexity : O(1)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :
//No

// Your code here along with comments explaining your approach


class MyQueue {
    private Stack<Integer> data = new Stack<Integer>();;
    public MyQueue() {
     
    }
    
    public void push(int x) {
        this.data.push(x);
    }
    
    public int pop() {
        Stack<Integer> temp = new Stack<Integer>();
        while(this.data.size() !=1){
            temp.push(this.data.pop());
        }
        int y = this.data.pop();
        while(temp.size()!=0){
            this.data.push(temp.pop());
        }
        return y;
    }
    
    public int peek() {
        Stack<Integer> temp = new Stack<Integer>();
        while(this.data.size() !=1){
            temp.push(this.data.pop());
        }
        int y = this.data.peek();
        while(temp.size()!=0){
            this.data.push(temp.pop());
        }
        return y;
    }
    
    public boolean empty() {
        return this.data.isEmpty();
    }
}


//2.

class MyHashMap {
    int[] arr; 
    public MyHashMap() {
        arr = new int[1000001];
        Arrays.fill(arr, -1);
    }

    public void put(int key, int value) {
        arr[key] = value;
    }

    public int get(int key) {
        return arr[key];
    }

    public void remove(int key) {
        arr[key] = -1;
    }
}
