//Time Complexity = Push:O(1), Pop,Peek: Avg O(1)
//Space Complexity = O(n)
var MyQueue = function() {
  this.stack1 = new Array();
  this.stack2 = new Array();
};

/**
 * @param {number} x
 * @return {void}
 */
MyQueue.prototype.push = function(x) {
  this.stack1.push(x);
};

/**
 * @return {number}
 */
MyQueue.prototype.pop = function() {
  var peekResult = this.peek();
  this.stack2.pop();
  return peekResult;
};

/**
 * @return {number}
 */
MyQueue.prototype.peek = function() {
  var isEmpty = this.empty();
  if (!isEmpty) {
    if (this.stack2.length) {
      return this.stack2[this.stack2.length - 1];
    } else if (this.stack1.length) {
      let counter = this.stack1.length;
      while (counter > 0) {
        this.stack2.push(this.stack1[counter - 1]);
        counter -= 1;
      }
      this.stack1 = new Array();
    }
    // console.log("pop",this.stack2[this.stack2.length-1])
    return this.stack2[this.stack2.length - 1];
  } else {
    return -1;
  }
};

/**
 * @return {boolean}
 */
MyQueue.prototype.empty = function() {
  if (this.stack1.length === 0 && this.stack2.length === 0) {
    return true;
  } else {
    return false;
  }
};

/**
 * Your MyQueue object will be instantiated and called as such:
 * var obj = new MyQueue()
 * obj.push(x)
 * var param_2 = obj.pop()
 * var param_3 = obj.peek()
 * var param_4 = obj.empty()
 */
