/**
 *  I used double hashing technique here
 *  First hash function uses mod and second hash function uses division
 *  Created a method called getFinalLocation which uses both hashOne and hashTwo functions and gives the locations to put the key and value pair.
 *  put can insert a new key, val pair or update the value if there is an existant key.
 *  get implemented to get the value associated with the key
 *  remove deletes the entry of the key value pair in the index. 
 */


class MyHashMap {
    constructor() {
        this.bucketSize = 1000;
        this.parentArray = Array.from({
            length: this.bucketSize
        }, () => []);
    }

    hashOne = (key) => {
        return key % this.bucketSize;
    }

    hashTwo = (key) => {
        return Math.floor(key / this.bucketSize);
    }

    getFinalLocation = (key) => {
        const mainIndex = this.hashOne(key);
        const firstHashLoc = this.parentArray[mainIndex];
        const secondHashIndex = this.hashTwo(key);
        return [firstHashLoc, secondHashIndex];
    }

};

/** 
 * @param {number} key 
 * @param {number} value
 * @return {void}
 */
MyHashMap.prototype.put = function (key, value) {
    let [firstHashLoc, secondHashIndex] = this.getFinalLocation(key);
    if (!firstHashLoc[secondHashIndex]) {
        firstHashLoc[secondHashIndex] = [key, value];
    } else {
        firstHashLoc[secondHashIndex][1] = value;
    }
};

/** 
 * @param {number} key
 * @return {number}
 */
MyHashMap.prototype.get = function (key) {
    let [firstHashLoc, secondHashIndex] = this.getFinalLocation(key);
    if (!firstHashLoc[secondHashIndex]) return -1;
    return firstHashLoc[secondHashIndex][1];
};

/** 
 * @param {number} key
 * @return {void}
 */
MyHashMap.prototype.remove = function (key) {
    let [firstHashLoc, secondHashIndex] = this.getFinalLocation(key);
    if (!firstHashLoc[secondHashIndex]) return;
    // setting null removes both key and val from this location
    firstHashLoc[secondHashIndex] = null;
};

/** 
 * Your MyHashMap object will be instantiated and called as such:
 * var obj = new MyHashMap()
 * obj.put(key,value)
 * var param_2 = obj.get(key)
 * obj.remove(key)
 */
