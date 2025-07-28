// Time Complexity : O(1)
// Space Complexity : (1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/**
 * My approach was to maintain two stack because stacks are like Last In First Out  But Queues are something which works like First In First Out, 
 * So there is InStack where we will push all the values and OutStack where pop can be happend and we can achieve all FIFO. 
 * So Intially all the values will be pushed to inStack, But when we wawnt pop something as per the queue the first element should be remove but we are using stack
 * so last element will be removed. That's why we transfer all the elements to outStack and now first element becomes last and we pop it.
 */

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
    if(!this.empty()) {
        this.peek();
        return this.outStack.pop();
    }   

    return -1; 
};

/**
 * @return {number}
 */
MyQueue.prototype.peek = function() {
    if(this.outStack.length == 0) {
        while(this.inStack.length > 0) {
            this.outStack.push(this.inStack.pop());
        } 
    }

    return this.outStack[this.outStack.length - 1];
};

/**
 * @return {boolean}
 */
MyQueue.prototype.empty = function() {
    return this.inStack.length == 0 && this.outStack.length == 0;
};

/** 
 * Your MyQueue object will be instantiated and called as such:
 * var obj = new MyQueue()
 * obj.push(x)
 * var param_2 = obj.pop()
 * var param_3 = obj.peek()
 * var param_4 = obj.empty()
 */