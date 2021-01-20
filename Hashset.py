"""
Design Hashset
"""
"""
Time Complexity:
Add: O(1)
Remove: O(1)
Contains: O(1)
"""

class MyHashSet:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        # initialize size of the hashSet and the hashSet as 2D array
        self.ind1_sz = 1000
        self.ind2_sz = 1000
        self.hashSet = [[None for i in range(self.ind1_sz)]for k in range(self.ind2_sz)]
    
    def hashfunc1(self, key):
        return key % self.ind1_sz
    
    def hashfunc2(self, key):
        return key // self.ind2_sz

    def add(self, key: int) -> None:
        ind1 = self.hashfunc1(key)
        ind2 = self.hashfunc2(key)
        # update the value at that particular key to True to show that it is added
        self.hashSet[ind1][ind2] = True

    def remove(self, key: int) -> None:
        ind1 = self.hashfunc1(key)
        ind2 = self.hashfunc2(key)
        # check if hashSet is empty or not at that particular key
        if self.hashSet[ind1] is not None:
            # update the value at that particular key to False to show that the value is removed
            self.hashSet[ind1][ind2] = False

    def contains(self, key: int) -> bool:
        """
        Returns true if this set contains the specified element
        """
        ind1 = self.hashfunc1(key)
        ind2 = self.hashfunc2(key)
        # check if hashSet is empty or not at that particular key
        if self.hashSet[ind1] is not None:
            # return the value at that particular key
            return self.hashSet[ind1][ind2]
        # otherwise return False
        return False

# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)