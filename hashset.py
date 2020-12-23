class MyHashSet:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.hashValue = 2069
        self.hashSet = [[] for i in range(0,self.hashValue)]
        self.hashFunction = lambda x: x%self.hashValue
    
    # average: O(1)
    def add(self, key: int) -> None:
        if(not self.contains(key)):
            self.hashSet[self.hashFunction(key)].append(key)
    # average: O(1)
    def remove(self, key: int) -> None:
        if(self.contains(key)):
            self.hashSet[self.hashFunction(key)].remove(key)

    # average: O(1)
    def contains(self, key: int) -> bool:
        """
        Returns true if this set contains the specified element
        """
        if(key in self.hashSet[self.hashFunction(key)]):
            return True
        else:
            return False
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)