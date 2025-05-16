//## Problem 1: (https://leetcode.com/problems/implement-queue-using-stacks/)

var MyQueue = function() {
    //maintain 2 stacks
    //inStack to push all the elements
    //OutStack to transfer all the elements from inStack and pop
    this.inStack = []
    this.outStack = []

};

/** 
 * @param {number} x
 * @return {void}
 */
MyQueue.prototype.push = function(x) {
    //Time Complexity : O(1)
    //Space Complexity : O(1)
    //Keep pushing in inStack
    this.inStack.push(x)
};

/**
 * @return {number}
 */
MyQueue.prototype.pop = function() {
    //Time Complexity : O(1) amortized, worst case still O(n)
    //Space Complexity : O(1)
    if(this.outStack.length ==0){
        //we only perform this O(n) transfer when outStack runs out of elements
        while(this.inStack.length !== 0){
            this.outStack.push(this.inStack.pop())
        }
    }
    return this.outStack.pop()
};

/**
 * @return {number}
 */
MyQueue.prototype.peek = function() {
    //Time Complexity : O(1) amortized, worst case still O(n)
    //Space Complexity : O(1)
        if(this.outStack.length ==0){
        while(this.inStack.length !== 0){
            this.outStack.push(this.inStack.pop())
        }
    }
    return this.outStack[this.outStack.length-1]
};

/**
 * @return {boolean}
 */
MyQueue.prototype.empty = function() {
    return this.inStack.length === 0 && this.outStack.length === 0;
};

/** 
 * Your MyQueue object will be instantiated and called as such:
 * var obj = new MyQueue()
 * obj.push(x)
 * var param_2 = obj.pop()
 * var param_3 = obj.peek()
 * var param_4 = obj.empty()
 */