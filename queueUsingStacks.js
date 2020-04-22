// Time Complexity : O(1) for push, peek and emtpty, O(n) for pop
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class MyQueue {
    /**
 * Push element x to the back of queue. 
 * @param {number} x
 * @return {void}
 */
    data = [];
    push(num) {
        this.data.push(num);
    }
    /**
 * Removes the element from in front of queue and returns that element.
 * @return {number}
 */
    pop() {
        return this.data.shift();
    }
    /**
 * Get the front element.
 * @return {number}
 */
    peek() {
        return this.data[0];
    }
    /**
 * Returns whether the queue is empty.
 * @return {boolean}
 */
    empty() {
        if(this.data.length === 0) return true;
        else return false;
    }
}



/** 
 * Your MyQueue object will be instantiated and called as such:
 * var obj = new MyQueue()
 * obj.push(x)
 * var param_2 = obj.pop()
 * var param_3 = obj.peek()
 * var param_4 = obj.empty()
 */