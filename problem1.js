
var MyQueue = function() {
    this.pushStack = [];
    this.popStack = [];
    
};

/** 
 * @param {number} x
 * @return {void}
 */
MyQueue.prototype.push = function(x) {
    this.pushStack.push(x);
};

/**
 * @return {number}
 */
MyQueue.prototype.pop = function() {
    for(var i=this.pushStack.length-1;i>=1;i--)
        {
            this.popStack.push(this.pushStack[i]);
            this.pushStack.splice(i,1)
        }
    var popedItem = this.pushStack[0];
    this.pushStack.splice(0,1);
    this.pushStack = [];
    if(this.popStack.length > 0)
    {
        for(var i=this.popStack.length-1;i>=0;i--)
        {
            this.pushStack.push(this.popStack[i]);
            this.popStack.splice(i,1);
        }
    }
    return popedItem;
};

/**
 * @return {number}
 */
MyQueue.prototype.peek = function() {
    return this.pushStack[0];
};

/**
 * @return {boolean}
 */
MyQueue.prototype.empty = function() {
    if(this.pushStack.length)
    {
        return false;
    }
    return true;
    
};

/** 
 * Your MyQueue object will be instantiated and called as such:
 * var obj = new MyQueue()
 * obj.push(x)
 * var param_2 = obj.pop()
 * var param_3 = obj.peek()
 * var param_4 = obj.empty()
 */