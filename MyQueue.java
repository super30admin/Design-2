package Day1;

import java.util.Stack;

class MyQueue {

	// Time Complexity: O(n)
	// For push, pop or peek operations, it may be needed to shift all elements from
	// one stack to another and then perform the required operations.
	// Hence, time complexity is O(n).

	// Space Complexity: O(n)
	// At any point of time, only one of the stacks will hold the elements of the
	// queue.

	// Did this code successfully run on Leetcode : Yes
	// Any problem you faced while coding this : No

	// Implementing Queue using two stacks
	// Stack s1 stores elements such that latest inserted element in queue is at top
	// of stack s1
	// Stack s2 stores elements in the reverse order of s1, i.e. latest inserted
	// element in queue is at bottom of stack s2
	Stack<Integer> s1;
	Stack<Integer> s2;

	/** Initialize your data structure here. */
	// Constructor to initialize the two stacks
	public MyQueue() {
		s1 = new Stack<>();
		s2 = new Stack<>();
	}

	/** Push element x to the back of queue. */
	// if s1 holds queue elements, then simply push the new element to s1.
	// else s2 must be holding queue elements.
	// a) transfer all elements of s2->s1 to bring back of the queue at the top of
	// s1.
	// b) Then insert the new element to s1.
	public void push(int x) {
		if (!s2.isEmpty()) {
			while (!s2.isEmpty()) {
				int temp = s2.pop();
				s1.push(temp);
			}
		}
		s1.push(x);
	}

	/** Removes the element from in front of queue and returns that element. */
	// if s2 holds queue elements, then simply push the new element to s2.
	// else s1 must be holding queue elements.
	// a) transfer all elements of s1->s2 to bring front of the queue at the top of
	// s2.
	// b) Then delete the topmost element from s2.
	public int pop() {

		int poppedElem = 0;

		if (this.empty()) {
			return 0;
		}

		if (!s1.isEmpty()) {
			while (!s1.isEmpty()) {
				int temp = s1.pop();
				s2.push(temp);
			}
		}

		poppedElem = s2.pop();
		return poppedElem;
	}

	/** Get the front element. */
	// if s2 holds queue elements, then simply push the new element to s2.
	// else s1 must be holding queue elements.
	// a) transfer all elements of s1->s2 to bring front of the queue at the top of
	// s2.
	// b) Then peek the topmost element from s2.
	public int peek() {

		int peekedElem = 0;

		if (this.empty()) {
			return 0;
		}

		if (!s1.isEmpty()) {
			while (!s1.isEmpty()) {
				int temp = s1.pop();
				s2.push(temp);
			}
		}

		peekedElem = s2.peek();
		return peekedElem;
	}

	/** Returns whether the queue is empty. */
	// If both stacks s1 and s2 are empty => the queue is empty.
	public boolean empty() {
		if (s1.isEmpty() && s2.isEmpty()) {
			return true;
		}
		return false;
	}
}

/**
 * Your MyQueue object will be instantiated and called as such: MyQueue obj =
 * new MyQueue(); obj.push(x); int param_2 = obj.pop(); int param_3 =
 * obj.peek(); boolean param_4 = obj.empty();
 */