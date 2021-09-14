// Time Complexity : 0(1)
// Space Complexity : 0(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

class MyHashSet {

    /** Initialize your data structure here. */
    var array : [Int]
    init() {
      array = Array(repeating: -1, count: 1000002) 
    }
    
    func add(_ key: Int) {
        if array[key] == -1 {
        array[key] = key
        }
    }
    
    func remove(_ key: Int) {
        array[key] = -1
    }

    
    
    /** Returns true if this set contains the specified element */
    func contains(_ key: Int) -> Bool {
        if array[key] != -1  {
            return true
        }
        return false
    }
}


