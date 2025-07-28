// Time Complexity : Average O(1), Worst Case O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/**
 * To desgin a hashmap we will be using arrays of size 10000 becuase to avoid collisions we will be using Linear chanining which uses Linked List
 * In Linked List Search, Delete and Add will take a traversing throughout the LinkedList so we don't want to traverse 1000 times in worst case to find, remove or add an element.
 * So we main array size to 10k which make the max LL size of 100. 
 */
var MyHashMap = function() {
    
    
    this.primarySize = 10000;

    this.s = Array(this.primarySize).fill(null);

    class Node {
        constructor(key, value, next) {
            this.key = key;
            this.data = value;
            this.next = next;
        };
    }

    this.Node = Node;
};

/** 
 * @param {number} key 
 * @param {number} value
 * @return {void}
 */

MyHashMap.prototype.hashfunction = function(key) {
    return key % this.primarySize;
}

MyHashMap.prototype.getPrevNode = function(node, key) {
    let temp = node;
    while(temp.next != null &&  temp.next.key != key) {
        temp = temp.next;
    }

    return temp; 
}

MyHashMap.prototype.put = function(key, value) {
    const pi = this.hashfunction(key);
    if(!this.s[pi]) {
        this.s[pi] = new this.Node(-1,-1,null);
        this.s[pi].next = new this.Node(key, value, null)
        return;
    }

    const prev = this.getPrevNode(this.s[pi], key);

    if(prev.next == null) {
        const newNode = new this.Node(key,value, null);
        prev.next = newNode;
    }else {
        prev.next.data = value;
    }
};

/** 
 * @param {number} key
 * @return {number}
 */
MyHashMap.prototype.get = function(key) {
    const pi = this.hashfunction(key);
    if(this.s[pi]) {
        const prev = this.getPrevNode(this.s[pi], key);
        if(prev.next != null) {
            return prev.next.data;
        }
    }

    return -1;
};

/** 
 * @param {number} key
 * @return {void}
 */
MyHashMap.prototype.remove = function(key) {
    const pi = this.hashfunction(key);
    if(this.s[pi]) {
        const prev = this.getPrevNode(this.s[pi], key);
        if(prev.next != null) {
            const temp = prev.next;
            prev.next = prev.next.next;
            temp.next = null;
        }
    }
};

/** 
 * Your MyHashMap object will be instantiated and called as such:
 * var obj = new MyHashMap()
 * obj.put(key,value)
 * var param_2 = obj.get(key)
 * obj.remove(key)
 */