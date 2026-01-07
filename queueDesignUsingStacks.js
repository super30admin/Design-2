
/**
 * Intuition:
 * Here, i am using two stack to create the queue.
 * Inside the constructor, i am initializing the in and out stacks.
 * Whenever we need to put an element in to the queue, i am pushing that into in stack.
 * Whenever we need to pop an element from the queue, i am popping the peak element from outqueue.
 * Inside the peak, i am seeing if the out queue is empty or not.if it is empty i am moving all the element available from in stack(pop the last ele) to outstack(push).
 * This will allow us to have the first inserted element to be on the top of outstack.
 * 
 * Time complexity: 
 * 
 */

class MyQueue {
    constructor() {
        
        this.inStack = [];
        this.outStack = [];
    }
};

/** 
 * @param {number} x
 * @return {void}
 */
MyQueue.prototype.push = function (x) {
    this.inStack.push(x);
};

/**
 * @return {number}
 */
MyQueue.prototype.pop = function () {
    this.peek();
    return this.outStack.pop();
};

/**
 * @return {number}
 */
MyQueue.prototype.peek = function () {
     if (!this.outStack.length) {
        while (this.inStack.length > 0) {
            this.outStack.push(this.inStack.pop());
        }
    }
    if(!this.outStack.length) return;
    return this.outStack[this.outStack.length - 1];
};

/**
 * @return {boolean}
 */
MyQueue.prototype.empty = function () {
    return this.outStack.length === 0 && this.inStack.length === 0;
};

/** 
 * Your MyQueue object will be instantiated and called as such:
 * var obj = new MyQueue()
 * obj.push(x)
 * var param_2 = obj.pop()
 * var param_3 = obj.peek()
 * var param_4 = obj.empty()
 */