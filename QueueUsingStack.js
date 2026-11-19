
var MyQueue = function() {
    this.arr1 = [];
    this.arr2 = [];
};

/** 
 * @param {number} x
 * @return {void}
 */
MyQueue.prototype.push = function(x) {
    this.arr1.push(x);
};

/**
 * @return {number}
 */
MyQueue.prototype.pop = function() {
        // now pop from arr2
        this.peek();
        if(this.arr2.length>0)
            return this.arr2.pop();
};

/**
 * @return {number}
 */
MyQueue.prototype.peek = function() {
    if(this.arr1.length > 0 || this.arr2.length>0) {
    if(this.arr2.length === 0) {
        // check if there are elements in stack - arr1
        // add these elements to arr2 - since arr1 is stack it we can extract in LIFO fahion
        while(this.arr1.length>0) {
            this.arr2.push(this.arr1.pop());
        } 
    }
    return this.arr2[this.arr2.length-1]
    }
};

/**
 * @return {boolean}
 */
MyQueue.prototype.empty = function() {
    // if there are elements in either - meanst there are elements still
    return this.arr1.length === 0 && this.arr2.length === 0
};

/** 
 * Your MyQueue object will be instantiated and called as such:
 * var obj = new MyQueue()
 * obj.push(x)
 * var param_2 = obj.pop()
 * var param_3 = obj.peek()
 * var param_4 = obj.empty()
 */