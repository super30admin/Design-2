
var MyHashMap = function() {
    this.prim = Math.sqrt(1000000);
    this.sec =  Math.sqrt(1000000);
    this.map = new Array(this.prim).fill(null);
};

MyHashMap.prototype.hash1 = function(key) {
    return key%this.prim;
}

MyHashMap.prototype.hash2 = function(key) {
    return Math.ceil(key/this.sec);
}


/** 
 * @param {number} key 
 * @param {number} value
 * @return {void}
 */
MyHashMap.prototype.put = function(key, value) {
    let first = this.hash1(key);
    let second = this.hash2(key);
    if(this.map[first] === null) {
        // create array under this element
        this.map[first] = new Array(this.sec).fill(null);
    }
    this.map[first][second] = value; // stores most upto date even if there is a duplicate key
};

/** 
 * @param {number} key
 * @return {number}
 */
MyHashMap.prototype.get = function(key) {
    let first = this.hash1(key);
    let second = this.hash2(key);
    if(this.map[first] === null) return -1;
    // if(this.map[first][second] === null) return -1
    return this.map[first][second];
};

/** 
 * @param {number} key
 * @return {void}
 */
MyHashMap.prototype.remove = function(key) {
    let first = this.hash1(key);
    let second = this.hash2(key);
    // if ther is element mark it as null
     if(!this.map[first]) return -1;
    if(this.map[first][second]) {
        this.map[first][second] = null;
    }
};

/** 
 * Your MyHashMap object will be instantiated and called as such:
 * var obj = new MyHashMap()
 * obj.put(key,value)
 * var param_2 = obj.get(key)
 * obj.remove(key)
 */