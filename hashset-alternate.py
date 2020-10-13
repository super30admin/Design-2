# Coding out the implementation discussed in class as an alternate
# Time Complexity - O(1) for add, remove, contains
# Space Complexity 
# - O(n) - Average case
# - O(range of dataset) - Every entry in 2D grid is populated


class MyHashSet(object):
    
    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.buckets = 1000
        self.bucketList = 1001
        self.arr = [None]*self.buckets
        
    def _hash1(self, key):
        return key%self.buckets
    
    def _hash2(self, key):
        return key//self.bucketList

    def add(self, key):
        """
        :type key: int
        :rtype: None
        """
        _h1 = self._hash1(key)
        _h2 = self._hash2(key)
        if self.arr[_h1] is None:
            self.arr[_h1] = self.arr[_h1] = [None]*self.bucketList
        self.arr[_h1][_h2] = True

    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        _h1 = self._hash1(key)
        _h2 = self._hash2(key)
        if self.arr[_h1] is None:
            return
        else:
            self.arr[_h1][_h2] = False
    
    def contains(self, key):
        """
        Returns true if this set contains the specified element
        :type key: int
        :rtype: bool
        """
        _h1 = self._hash1(key)
        _h2 = self._hash2(key)
        if self.arr[_h1] is None:
            return False
        return self.arr[_h1][_h2]
        
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)