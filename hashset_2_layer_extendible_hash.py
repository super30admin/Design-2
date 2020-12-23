"""
Hashset using Extendible Hashing (2 level hierarchy) discussed in class
"""
class MyHashSet:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.bucketSize = 1001
        self.bucketTotal = 1000
        self.hashSet = [None for i in range(0,self.bucketTotal)]
        self.firstHash = lambda x: x%self.bucketTotal # first hashing
        self.bucketHash = lambda x: x//self.bucketSize
    

    def add(self, key: int) -> None:
        if(self.hashSet[self.firstHash(key)]==None):
            self.hashSet[self.firstHash(key)] = [False for i in range(0,self.bucketSize)]
        self.hashSet[self.firstHash(key)][self.bucketHash(key)] = True 
    def remove(self, key: int) -> None:
        if(self.hashSet[self.firstHash(key)]==None):
            return
        self.hashSet[self.firstHash(key)][self.bucketHash(key)] = False

    def contains(self, key: int) -> bool:
        """
        Returns true if this set contains the specified element
        """
        if(self.hashSet[self.firstHash(key)]!=None and self.hashSet[self.firstHash(key)][self.bucketHash(key)]==True):
            return True
        else:
            return False
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)