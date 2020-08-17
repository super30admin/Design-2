# 705. Design HashSet

# Design a HashSet without using any built-in hash table libraries.

# To be specific, your design should include these functions:

# add(value): Insert a value into the HashSet. 
# contains(value) : Return whether the value exists in the HashSet or not.
# remove(value): Remove a value in the HashSet. If the value does not exist in the HashSet, do nothing.

# Example:

# MyHashSet hashSet = new MyHashSet();
# hashSet.add(1);         
# hashSet.add(2);         
# hashSet.contains(1);    // returns true
# hashSet.contains(3);    // returns false (not found)
# hashSet.add(2);          
# hashSet.contains(2);    // returns true
# hashSet.remove(2);          
# hashSet.contains(2);    // returns false (already removed)

class MyHashSet:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.res = {}

    def add(self, key: int) -> None:
        if key not in self.res:
            self.res[key]=key
        
        print("Values in the set : ", self.res)
        

    def remove(self, key: int) -> None:
        if key in self.res:
            del self.res[key]

        

    def contains(self, key: int) -> bool:
        """
        Returns true if this set contains the specified element
        """
        return key in self.res
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)

hashSet = MyHashSet()
hashSet.add(1)       
hashSet.add(2)         
print(hashSet.contains(1))    #// returns true
print(hashSet.contains(3))   #// returns false (not found)
hashSet.add(2)       
print(hashSet.contains(2))    #// returns true
hashSet.remove(2)       
hashSet.contains(2)