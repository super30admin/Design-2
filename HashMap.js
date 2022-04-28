/ Time Complexity : O(1) for put(),get(),remove()
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
 I created array of size 10^6+1 and then using concept of mapping value with key checked for put(),get() whether value prexists inside them or not if yes then update value for that specific key and used delete to remove specific key.


var MyHashMap = function() {
    this.arr = new Array(1000001);
};

/** 
 * @param {number} key 
 * @param {number} value
 * @return {void}
 */
MyHashMap.prototype.put = function(key, value) {
    return this.arr[key]=value;
};

/** 
 * @param {number} key
 * @return {number}
 */
MyHashMap.prototype.get = function(key) {
    return this.arr[key]!==undefined? this.arr[key]:-1;
};

/** 
 * @param {number} key
 * @return {void}
 */
MyHashMap.prototype.remove = function(key) {
    delete this.arr[key];
};

/** 
 * Your MyHashMap object will be instantiated and called as such:
 * var obj = new MyHashMap()
 * obj.put(key,value)
 * var param_2 = obj.get(key)
 * obj.remove(key)
 */