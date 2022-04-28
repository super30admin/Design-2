// Time Complexity : O(1) for push,pop,peek,empty().
// Space Complexity : O(N)
// Did this code successfully run on Leetcode :  yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

Used two stack approach one to just insert value from front to last(st1) and other(st2) to get popped out value from first stack(st1)
var MyQueue = function() {
    this.st1=[];
    this.st2=[];
};

/** 
 * @param {number} x
 * @return {void}
 */
MyQueue.prototype.push = function(x) {
    
    this.st1.push(x);
    
};

/**
 * @return {number}
 */
MyQueue.prototype.pop = function() {
    if(this.st2.length){
        return this.st2.pop();
    }
    else {
        while(this.st1.length)
            {
                this.st2.push(this.st1.pop());
            }
        return this.st2.pop();
    }
};

/**
 * @return {number}
 */
MyQueue.prototype.peek = function() {
   if(this.st2.length) return this.st2[this.st2.length-1];
    else{
         while(this.st1.length)
            {
                this.st2.push(this.st1.pop());
            }
        return this.st2[this.st2.length-1];
        
    }
};
/**
 * @return {boolean}
 */
MyQueue.prototype.empty = function() {
    return this.st1.length===0 && this.st2.length===0;
};

/** 
 * Your MyQueue object will be instantiated and called as such:
 * var obj = new MyQueue()
 * obj.push(x)
 * var param_2 = obj.pop()
 * var param_3 = obj.peek()
 * var param_4 = obj.empty()
 */