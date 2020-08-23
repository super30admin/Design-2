# Time complexity - O(1)
# Space complexity - O(n)
# Did this solution run on leetcode? - yes
# Open addressing (Double Hashing)
class MyHashSet:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.hashset = [None] * 1000
        self.minSize = 1000

    
    def hashFunc1(self, key):
        return key%len(self.hashset)
    
    
    def hashFunc2(self, key):
        return key//self.minSize
    
    
    def add(self, key: int) -> None:
        idx1 = self.hashFunc1(key)
        idx2 = self.hashFunc2(key)
        
        if self.hashset[idx1] is None:
            self.hashset[idx1] = [None] * 1000
        
        self.hashset[idx1][idx2] = True
        

    def remove(self, key: int) -> None:
        idx1 = self.hashFunc1(key)
        idx2 = self.hashFunc2(key)
        
        if self.hashset[idx1] is None:
            return
        
        self.hashset[idx1][idx2] = False
            

    def contains(self, key: int) -> bool:
        """
        Returns true if this set contains the specified element
        """
        idx1 = self.hashFunc1(key)
        idx2 = self.hashFunc2(key)
        
        if self.hashset[idx1] is None:
            return False
        
        return self.hashset[idx1][idx2]


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)