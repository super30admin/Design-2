function ListNode(key, value, next = null) {
  this.key = key;
  this.value = value;
  this.next = next;
}

var MyHashMap = function () {
  this.SIZE = 10009;
  this.buckets = new Array(this.SIZE).fill(null);
};

MyHashMap.prototype.hash = function (key, value) {
  return key % this.SIZE;
};
/**
 * @param {number} key
 * @param {number} value
 * @return {void}
 */
MyHashMap.prototype.put = function (key, value) {
  const idx = this.hash(key);
  if (!this.buckets[idx]) this.buckets[idx] = new ListNode(-1, -1);
  let prev = this.buckets[idx];
  let curr = prev.next;

  while (curr) {
    if (curr.key == key) {
      curr.value = value;
      return;
    }
    prev = curr;
    curr = curr.next;
  }
  prev.next = new ListNode(key, value);
};

/**
 * @param {number} key
 * @return {number}
 */
MyHashMap.prototype.get = function (key) {
  const idx = this.hash(key);
  if (!this.buckets[idx]) return -1;
  let prev = this.buckets[idx];
  let curr = prev.next;
  while (curr) {
    if (curr.key == key) return curr.value;
    curr = curr.next;
  }
  return -1;
};

/**
 * @param {number} key
 * @return {void}
 */
MyHashMap.prototype.remove = function (key) {
  const idx = this.hash(key);
  if (!this.buckets[idx]) return;

  let prev = this.buckets[idx];
  let curr = prev.next;
  while (curr) {
    if (curr.key === key) {
      prev.next = curr.next;
      return;
    }
    prev = curr;
    curr = curr.next;
  }
};

/**
 * Your MyHashMap object will be instantiated and called as such:
 * var obj = new MyHashMap()
 * obj.put(key,value)
 * var param_2 = obj.get(key)
 * obj.remove(key)
 */
