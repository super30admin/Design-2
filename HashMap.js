// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


/*
* Approach - Double Hashing
*   Since the constraint was 0 - 10^6 we use the sqrt to split buckets to avoid huge memory wastage
*   We use double hashing to avoid collision
*   PUT:
*     - We get the first hash value by using key % buckets
*     - We get the second hash value by key / bucketItems
*     - if the array of the fist hash is empty or null we initialize it to a 2D
*         array with the bucketItems length and defaulting it to -1.
*     - if it's not then we do storage[bucket][bucketItem] and set the value to true
*
*   Remove:
*     - We get the first hash value by using key % buckets
*     - We get the second hash value by key / bucketItems
*     - if the array of the fist hash is empty or null we return null
*     - if it's not then we do storage[bucket][bucketItem] = -1 since we are removing the value
*
*   GET:
*     - We get the first hash value by using key % buckets
*     - We get the second hash value by key / bucketItems
*     - if the array of the fist hash is empty or null we return -1
*     - if it's not then we return storage[bucket][bucketItem]
*         which would be value / -1 depending on if the value exists
*
* */
const MyHashMap = function() {
  this.buckets = 1000;
  this.bucketItems = 1000;
  this.storage = new Array(this.buckets).fill(null);
};

/**
 * @param {number} key
 * @return {number}
 */
MyHashMap.prototype.getBuckets = function (key) {
  return key % this.buckets;
}

/**
 * @param {number} key
 * @return {number}
 */
MyHashMap.prototype.getBucketItems = function (key) {
  return Math.floor(key / this.bucketItems);
}

/**
 * @param {number} key
 * @param {number} value
 * @return {void}
 */
MyHashMap.prototype.put = function(key, value) {
  const bucket = this.getBuckets(key);
  const bucketItem = this.getBucketItems(key);

  if (this.storage[bucket] === null) {
    this.storage[bucket] = new Array(this.bucketItems).fill(-1)
  }

  this.storage[bucket][bucketItem] = value;
};

/**
 * @param {number} key
 * @return {number}
 */
MyHashMap.prototype.get = function(key) {
  const bucket = this.getBuckets(key);
  const bucketItem = this.getBucketItems(key);
  if (this.storage[bucket] === null) {
    return -1;
  }
  return this.storage[bucket][bucketItem]
};

/**
 * @param {number} key
 * @return {void}
 */
MyHashMap.prototype.remove = function(key) {
  const bucket = this.getBuckets(key);
  const bucketItem = this.getBucketItems(key);
  if (this.storage[bucket] === null) {
    return;
  }
  this.storage[bucket][bucketItem] = -1;
};

/**
 * Your MyHashMap object will be instantiated and called as such:
 * var obj = new MyHashMap()
 * obj.put(key)
 * obj.remove(key)
 * var param_3 = obj.get(key)
 */

