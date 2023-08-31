/*
* TC:
* Push - O(1)
* Pop - O(N)
* Peek - O(N)
* Empty - O(1)
*
* Did this code successfully run on Leetcode : Yes
* Any problem you faced while coding this : No
*
*
* Since Queue is FIFO, and the requriement states to use 2 arrays
*    we use 2 arrays to solve this we are modifying it to behave like a queue
*     - Push => directly pushes the element ot the stack
*     - Pop & Peek => since Peek and pop have similar we have to first move the elements to the second stack and then pop the first element.
*     - isEmpty - check if both the stacks are empty

* */


var MyQueue = function() {
  this.inStack = [];
  this.outStack = [];
};

/**
 * @param {number} x
 * @return {void}
 */
MyQueue.prototype.push = function(x) {
  this.inStack.push(x);
};

/**
 * @return {number}
 */
MyQueue.prototype.pop = function() {
  this.peek();
  return this.outStack.pop();
};

/**
 * @return {number}
 */
MyQueue.prototype.peek = function() {
  if (this.outStack.length === 0) {
    //worst case would be O(N) when all the elements are pushed into one stack and the end has a pop/peek operation
    while (this.inStack.length !==0) {
      this.outStack.push(this.inStack.pop());
    }
  }
  return this.outStack[this.outStack.length - 1];
};

/**
 * @return {boolean}
 */
MyQueue.prototype.empty = function() {
  return this.inStack.length === 0 && this.outStack.length === 0
};

/**
 * Your MyQueue object will be instantiated and called as such:
 * var obj = new MyQueue()
 * obj.push(x)
 * var param_2 = obj.pop()
 * var param_3 = obj.peek()
 * var param_4 = obj.empty()
 */