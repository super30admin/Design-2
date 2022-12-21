//Time Complexity = O(n)
// Space Complexity = O(n) where n is the max linkedlist nodes
var MyNode = function(key, value) {
  this.key = key;
  this.value = value;
  this.next = null;
};

var MyHashMap = function() {
  this.buckets = 10000; // 10^4
  this.nodes = new Array(this.buckets);
};

MyHashMap.prototype.find = function(head, key) {
  var prev = head;
  var curr = head.next;
  while (curr != null && curr.key != key) {
    prev = curr;
    curr = curr.next;
  }
  return prev;
};

MyHashMap.prototype.getBucket = function(key) {
  return key % this.buckets;
};

/**
 * @param {number} key
 * @param {number} value
 * @return {void}
 */
MyHashMap.prototype.put = function(key, value) {
  var bucket = this.getBucket(key);
  if (this.nodes[bucket] === null || this.nodes[bucket] === undefined) {
    this.nodes[bucket] = new MyNode(-1, -1); // Not Present in constraints
  }

  var prev = this.find(this.nodes[bucket], key);
  if (prev.next !== null) {
    prev.next.value = value;
    return;
  }
  prev.next = new MyNode(key, value);
};

/**
 * @param {number} key
 * @return {number}
 */
MyHashMap.prototype.get = function(key) {
  var bucket = this.getBucket(key);
  if (this.nodes[bucket] === null || this.nodes[bucket] === undefined) {
    return -1;
  }
  var prev = this.find(this.nodes[bucket], key);
  if (prev.next !== null) {
    return prev.next.value;
  }
  return -1;
};

/**
 * @param {number} key
 * @return {void}
 */
MyHashMap.prototype.remove = function(key) {
  var bucket = this.getBucket(key);
  if (this.nodes[bucket] === null || this.nodes[bucket] === undefined) {
    return;
  }
  var prev = this.find(this.nodes[bucket], key);
  if (prev.next !== null) {
    prev.next = prev.next.next;
  }
};

/**
 * Your MyHashMap object will be instantiated and called as such:
 * var obj = new MyHashMap()
 * obj.put(key,value)
 * var param_2 = obj.get(key)
 * obj.remove(key)
 */
