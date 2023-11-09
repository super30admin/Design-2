// design a hashmap (https://leetcode.com/problems/implement-queue-using-stacks/)

// time compelxity is O(1) space is O(n)
//Accepted in LeetCode
/* approch: Implemented hashmap using double hashing to handle collisions, this
involves two hash functions to calculate outer and inner hash and that insert the keys*/

var MyHashMap = function() {
    this.size =1000;
    this.map=new Array(this.size); //storage
    
    this.hash1= function(key){
        return key % this.size;
    
    }
    
    this.hash2 =function(key){
        return key/this.size;
    }
     
        
    };
    
    /** 
     * @param {number} key 
     * @param {number} value
     * @return {void}
     */
    MyHashMap.prototype.put = function(key, value) {
        
        let outerHash = this.hash1(key);
        if(this.map[outerHash] === undefined){
            this.map[outerHash] = [];
        }
        let innerHash = this.hash2(key);
        if (this.map[outerHash][innerHash] === undefined) {
        this.map[outerHash][innerHash] = [];
      }
    
      this.map[outerHash][innerHash] = value;
    };
    
    
    /** 
     * @param {number} key
     * @return {number}
     */
    MyHashMap.prototype.get = function(key) {
        
       let outerHash=this.hash1(key);
       if(this.map[outerHash]=== undefined){
           return -1; //key not found
       }
       else{
           let innerHash = this.hash2(key);
           if (
          this.map[outerHash][innerHash] === undefined ||
          this.map[outerHash][innerHash] === null
        ) {
          return -1; // Key not found
        } else {
          return this.map[outerHash][innerHash];
        }
      }
           
       }
    
    
    
    
    /** 
     * @param {number} key
     * @return {void}
     */
    MyHashMap.prototype.remove = function(key) {
         let outerHash = this.hash1(key);
        if(this.map[outerHash]!== undefined){
            let innerHash = this.hash2(key);
            this.map[outerHash][innerHash]= undefined;
        }
        
    };
    
    /** 
     * Your MyHashMap object will be instantiated and called as such:
     * var obj = new MyHashMap()
     * obj.put(key,value)
     * var param_2 = obj.get(key)
     * obj.remove(key)
     */