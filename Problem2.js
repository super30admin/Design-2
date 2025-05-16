// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NONE
// ## Problem 2:
// Design Hashmap (https://leetcode.com/problems/design-hashmap/)

var MyHashMap = function() {
    this.bucketElements = 1000
    this.bucket = 1000
    this.storage = new Array(this.bucket)
};

/** 
 * @param {number} key 
 * @param {number} value
 * @return {void}
 */
MyHashMap.prototype.hash1 = function(key) {
    //Hash1 for primary bucket
    return key % this.bucket
};

MyHashMap.prototype.hash2 = function(key) {
    //Hash for secondary bucket
    return Math.floor(key / this.bucket)
};

MyHashMap.prototype.put = function(key, value) {
    //Time Complexity : O(1)
    //Space Complexity : O(1)
    //! SUre we are adding here a array to store it but its value is already defined and we know its range is gonna be from x to y so its not increasing with the input, we are always UNDER the best cases bases and hence, it is a O(1) space 
    let i = this.hash1(key)
    //If we already have it , then override the value
    if(!this.storage[i]){
        //if not create array (secondary)
        this.storage[i] = new Array(this.bucketElements).fill(-1)
    }
    //put the value for [hash1][hash2] = value  
    this.storage[i][this.hash2(key)] = value
};

/** 
 * @param {number} key
 * @return {number}
 */
MyHashMap.prototype.get = function(key) {
    //calculate the hashes and just return whatever is held in that nested postition
    if(!this.storage[this.hash1(key)]) return -1
    return this.storage[this.hash1(key)][this.hash2(key)]
};

/** 
 * @param {number} key
 * @return {void}
 */
MyHashMap.prototype.remove = function(key) {
    //if hash is not present return -1
    //or set the value to -1 whatever is held in that nested postition
    let i = this.hash1(key)
    if(!this.storage[i]) return -1
    this.storage[i][this.hash2(key)] = -1
};