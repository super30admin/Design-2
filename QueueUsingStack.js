//Approach 1
// Time Complexity : push - O(n) pop/peek-O(1)
// Space Complexity : O(n) n is number of entries
// Did this code successfully run on Leetcode : Yes

//Approach 2
// Time Complexity : push - O(n)  pop/peek - O(1)
// Space Complexity : O(n) n is number of entries
// Did this code successfully run on Leetcode : Yes


var MyQueue = function () {
    this.stack1 = [];
    this.stack2 = [];
};


MyQueue.prototype.push = function (x) {
    while (this.stack1.length > 0) {
        this.stack2.push(this.stack1.pop());
    }

    this.stack1.push(x);

    while (this.stack2.length > 0) {
        this.stack1.push(this.stack2.pop());
    }
};


MyQueue.prototype.pop = function () {
    if (this.stack1.length > 0) {
        return this.stack1.pop();
    } else {
        return undefined;
    }
};


MyQueue.prototype.peek = function () {
    if (this.stack1.length > 0) {
        return this.stack1[this.stack1.length - 1];
    } else {
        return undefined;
    }
};


MyQueue.prototype.empty = function () {
    return this.stack1.length === 0;
};




//Approach 2

var MyQueue = function () {
    this.stack = [];
};


MyQueue.prototype.push = function (x) {
    this.stack.unshift(x);
};


MyQueue.prototype.pop = function () {
    return this.stack.pop();
};


MyQueue.prototype.peek = function () {
    return this.stack[this.stack.length - 1];
};


MyQueue.prototype.empty = function () {
    return this.stack.length === 0;
};


/**
 * Your MyQueue object will be instantiated and called as such:
 * var obj = new MyQueue()
 * obj.push(x)
 * var param_2 = obj.pop()
 * var param_3 = obj.peek()
 * var param_4 = obj.empty()
 */





