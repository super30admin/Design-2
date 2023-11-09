// Implement a queue using stack (https://leetcode.com/problems/design-hashmap/)
//time complexity O(1) and space complexity O(n)
//Accepted in leetcode
/* this implementation follows creating two stacks in and out 
the instack pushes all elemets while outstack pops perfoms pop and peek functions
elements are transferred between the stacks as needed to maintain the order of the queue*/

var MyQueue = function() {

    this.inStack = [];
    this.outStack =[];
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
    if (this.outStack.length===0){
        while(this.inStack.length>0){
            this.outStack.push(this.inStack.pop());
        }
    }
    return this.outStack.pop();
};

/**
 * @return {number}
 */
MyQueue.prototype.peek = function() {
    
if(this.outStack.length === 0){
    while(this.inStack.length>0){
        this.outStack.push(this.inStack.pop());
    }

}
return this.outStack[this.outStack.length-1];
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