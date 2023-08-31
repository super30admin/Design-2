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
*         which would be valye / -1 depending on if the value exists
*
* */
// const MyHashMap = function() {
//   this.buckets = 1000;
//   this.bucketItems = 1000;
//   this.storage = new Array(this.buckets).fill(null);
// };

// /**
//  * @param {number} key
//  * @return {number}
//  */
// MyHashMap.prototype.getBuckets = function (key) {
//   return key % this.buckets;
// }

// /**
//  * @param {number} key
//  * @return {number}
//  */
// MyHashMap.prototype.getBucketItems = function (key) {
//   return Math.floor(key / this.bucketItems);
// }

// /**
//  * @param {number} key
//  * @param {number} value
//  * @return {void}
//  */
// MyHashMap.prototype.put = function(key, value) {
//   const bucket = this.getBuckets(key);
//   const bucketItem = this.getBucketItems(key);

//   if (this.storage[bucket] === null) {
//     this.storage[bucket] = new Array(this.bucketItems).fill(-1)
//   }

//   this.storage[bucket][bucketItem] = value;
// };

// /**
//  * @param {number} key
//  * @return {number}
//  */
// MyHashMap.prototype.get = function(key) {
//   const bucket = this.getBuckets(key);
//   const bucketItem = this.getBucketItems(key);
//   if (this.storage[bucket] === null) {
//     return -1;
//   }
//   return this.storage[bucket][bucketItem]
// };

// /**
//  * @param {number} key
//  * @return {void}
//  */
// MyHashMap.prototype.remove = function(key) {
//   const bucket = this.getBuckets(key);
//   const bucketItem = this.getBucketItems(key);
//   if (this.storage[bucket] === null) {
//     return;
//   }
//   this.storage[bucket][bucketItem] = -1;
// };

/**
 * Your MyHashMap object will be instantiated and called as such:
 * var obj = new MyHashMap()
 * obj.put(key)
 * obj.remove(key)
 * var param_3 = obj.get(key)
 */

// var obj = new MyHashMap()
// console.log(obj.remove(2))
// obj.put(3,11)
// obj.put(4,13)
// obj.put(15,6)
// obj.put(6,15)
// obj.put(8,8)
// obj.put(11,0)
// obj.get(11);
// console.log(obj.storage[11])

// Time Complexity : O(N) - To find the node
// Space Complexity : O(n)
/*Approach - Single Hashing with Linked list
* Similar approach as double hashing but instead of we use a single hash as the primary array
* for the secondary array we use a linked list to store the list of items.
*
* Note: % is mostly used so that the values dont cross the upper bound
* Put:
*   - To perform put we first have to get the bucket but the first hashing (%)
*   - The we have the find if the node exists in the storage,
*   - if it doesn't then we create a linked list with the dummy node elements fist.
*   - the dummy node is used a reference to the head in case we have to delete the first element/
*   - if the element is found using findNode then we check if the next value is null
*   - if it is we add prev.next = new Node(value, key)
*     else which means that the next element is the key then  we do prev.next.value = value
* Find:
*   - It has dummyNode and the key as the arguemtns
*   - we assign dummy node to prev and curr to the dummyNodes.next
*   - if the curr is null or the curr.key is the key then we return the prev
*   else we loop till the condition breaks and return prev
*
* Remove
*   - To perform put we first have to get the bucket but the first hashing (%)
*   - The we have the find if the node exists in the storage,
*   - if it doesn't then we create a linked list with the dummy node elements fist.
*   - the dummy node is used a reference to the head in case we have to delete the first element/
*   - if the element is found using findNode then we check if the next value is null
*   - if the prev.next is null then we return
*   else we do prev.next = prev.next.next to remove
*
* Get
*  - To perform put we first have to get the bucket but the first hashing (%)
*   - The we have the find if the node exists in the storage,
*   - if it doesn't then we create a linked list with the dummy node elements fist.
*   - the dummy node is used a reference to the head in case we have to delete the first element/
*   - if the element is found using findNode then we check if the next value is null
*   - if prev.next is null then we return -1
*   - else we return the value at prev.next
* */

class Node {
  constructor(data, key) {
    this.val = data;
    this.key = key;
    this.next = null
  }
}

const MyHashMap = function() {
  this.buckets = 10000;
  this.bucketItems = 100;
  this.storage = new Array(this.buckets).fill(null);
};

/**
 * @param {number} key
 * @return {number}
 */
MyHashMap.prototype.getBuckets = function (key) {
  return key % this.buckets;
}

MyHashMap.prototype.findNode = function (dummyNode, key) {
  let prev = dummyNode;
  let curr = dummyNode.next;

  while (curr && curr.key !== key) {
    prev = curr;
    curr = curr.next;
  }
  return prev;

}
/**
 * @param {number} key
 * @return {number}
 */

/**
 * @param {number} key
 * @param {number} value
 * @return {void}
 */
MyHashMap.prototype.put = function(key, value) {
  const bucket = this.getBuckets(key);
  if (!this.storage[bucket]) {
    this.storage[bucket] = new Node(-1, key);
  }
  let prev = this.findNode(this.storage[bucket], key);
  if (prev.next == null) {
    prev.next =  new Node(value, key)
  } else {
    prev.next.val = value;
  }
};

/**
 * @param {number} key
 * @return {number}
 */
MyHashMap.prototype.get = function(key) {
  const bucket = this.getBuckets(key);
  if (!this.storage[bucket]) {
    return -1
  }
  let prev = this.findNode(this.storage[bucket], key);
  if (!prev.next) {
    return -1;
  }
  return prev.next.val;

};

/**
 * @param {number} key
 * @return {void}
 */
MyHashMap.prototype.remove = function(key) {
  const bucket = this.getBuckets(key);
  if (!this.storage[bucket]) {
    return;
  }
  let prev = this.findNode(this.storage[bucket], key);
  if (!prev.next) {
    return;
  } else {
    prev.next = prev.next.next;
  }

};