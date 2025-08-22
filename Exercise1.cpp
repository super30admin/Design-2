// Time Complexity : Push it's O(1), Pop it's O(n), Peek and empty it's also
// O(1) Space Complexity : O(n) for the two stack spaces we use Did this code
// successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yeah a little, keeping track of
// front did not click me until I faced an issue where both the stack had
// elements and I lost track of front

#include <bits/stdc++.h>
using namespace std;

class MyQueue {
public:
  stack<int> st1;
  stack<int> st2;
  int front;

  MyQueue() { front = -1; }

  // here we first check if stack1 is empty, that means it's the first element
  // and it will be front of the queue else we just push
  void push(int x) {
    if (st1.empty()) {
      front = x;
    }
    st1.push(x);
  }

  // we first check if st2 is empty, if it is then we transfer the elements to
  // stack2 now they come in order and then we take the top and pop
  // Here we are also considering the case, where pop is called without pushing
  // anything (not explicitly mentioned in Leetcode but implicitly handled by
  // them)
  int pop() {
    if (st2.empty()) {
      while (!st1.empty()) {
        st2.push(st1.top());
        st1.pop();
      }
    }
    if (st2.empty()) {
      return INT_MIN;
    }
    int val = st2.top();
    st2.pop();
    return val;
  }

  // here we check if we st2 is not empty, that means we still have elements in
  // order of push in st2 so the top of st2 will be front, otherwise we use
  // front class member and return
  int peek() { return !st2.empty() ? st2.top() : front; }

  // we check if both st1 and st2 are empty
  bool empty() { return st2.empty() && st1.empty(); }
};

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue* obj = new MyQueue();
 * obj->push(x);
 * int param_2 = obj->pop();
 * int param_3 = obj->peek();
 * bool param_4 = obj->empty();
 */
