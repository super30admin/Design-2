
//Problem 1: Implement Queue using stack

// Time Complexity : Each Operation would take around O(n) as to remove or add element at particular index we have traverse the whole stack
// Space Complexity : Size of the stack which is O(n) - n is the number of elements to be pushed
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Had to refer for particular stack method to achive this.

import java.util.Stack;
class MyQueue {
  int top = -1;
  Stack<Integer> s;
  /** Initialize your data structure here. */
  public MyQueue() {
    s = new Stack<>();
  }

  /** Push element x to the back of queue. */
  public void push(int x) {
    top++;
    s.add(top, x);

  }

  /** Removes the element from in front of queue and returns that element. */
  public int pop() {
    if(!empty()){
      int ele = s.get(0);
      s.remove(0);
      top--;
      return ele;
    }
    return -1;
  }

  /** Get the front element. */
  public int peek() {
    if(!empty()){
      int ele = s.get(0);
      return ele;
    }
    return -1;
  }

  /** Returns whether the queue is empty. */
  public boolean empty() {
    return s.isEmpty() ? true : false;
  }

  public static void main(String[] args){
    MyQueue obj = new MyQueue();
    obj.push(x);
    int param_2 = obj.pop();
    int param_3 = obj.peek();
    boolean param_4 = obj.empty();
  }
}





//Problem 2: Design Hashset

// Time Complexity : Each Operation would take around O(1) as it just access the particular index to retrive the element
// Space Complexity : Size of the ArrayList which is O(1000000)
// Did this code successfully run on Leetcode : No, Few scenarios were failing on larger input
// Any problem you faced while coding this : Not sure which data structure has to be used to solve the problem

class MyHashMap {

  /** Initialize your data structure here. */
  List<Integer> al;
  public MyHashMap() {
    al = new ArrayList<>(Collections.nCopies(1000000, -1));
  }

  /** value will always be non-negative. */
  public void put(int key, int value) {
    al.add(key,value);
  }

  /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
  public int get(int key) {
    return al.get(key);
  }

  /** Removes the mapping of the specified value key if this map contains a mapping for the key */
  public void remove(int key) {
    al.add(key,-1);
  }
}

  public static void main(String[] args) {
    MyHashMap obj = new MyHashMap();
    obj.put(key, value);
    int param_2 = obj.get(key);
    obj.remove(key);
  }
/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */