//Implement Queue using Stacks
// Time Complexity :
// push(): O(1)
// pop(): O(1)
// peek(): O(1)
//empty(): O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : -

import java.io.*;
import java.util.*;class MyQueue {

  private Stack<Integer> in;
  private Stack<Integer> out;

  public MyQueue() {
    this.in = new Stack<Integer>();
    this.out = new Stack<Integer>();
  }

  public void push(int x) {
    this.in.push(x);
  }

  public int pop() {
    peek();
    return out.pop();
  }

  public int peek() {
    if (out.isEmpty()) {
      while (!in.isEmpty()) {
        out.push(in.pop());
      }
    }
    return out.peek();
  }

  public boolean empty() {
    return in.isEmpty() && out.isEmpty();
  }
}

class Problem1 {

  public static void main(String[] args) {
    MyQueue obj = new MyQueue();
    obj.push(4);
    obj.push(7);
    obj.push(1);
    int param_2 = obj.pop();
    System.out.println(param_2);
    int param_3 = obj.peek();
    System.out.println(param_3);
    boolean param_4 = obj.empty();
    System.out.println(param_4);
  }
}
