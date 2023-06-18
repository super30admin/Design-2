"""
HashSet implemented using double hashing.

All operation O(1) operation as inner list and outer lists are of constant size

"""
class MyHashSet(object):
    
    arr = []
    hash_1 = 25*25*25
    hash_2 = 4*4*4
    
    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.arr = [None for i in range(self.hash_1)]
    
    
    def add(self, key):
        """
        :type key: int
        :rtype: None
        """
        h1 = key % self.hash_1
        if not self.arr[h1] :
            self.arr[h1] = [False for i in range(self.hash_2)]
        self.arr[h1][key % self.hash_2] = True
    
    
    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        h1 = key % self.hash_1
        if self.arr[h1] :
            self.arr[h1][key % self.hash_2] = False
    
    
    
    
    def contains(self, key):
        """
        Returns true if this set contains the specified element
        :type key: int
        :rtype: bool
        """
        h1 = key % self.hash_1
        if self.arr[h1] :
            return self.arr[h1][key % self.hash_2]
        return False


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)