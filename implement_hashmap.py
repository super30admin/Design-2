class MyHashMap:

    def __init__(self):
        self.primaryBuckets = 1000
        self.secondaryBuckets = 1000
        self.storage = [None] * self.primaryBuckets

    def getPrimaryHash(self, key):
        return key % self.primaryBuckets

    def getSecondaryHash(self, key):
        return key // self.secondaryBuckets
    
    def put(self, key, value):
        primaryIndex = self.getPrimaryHash(key)
        if self.storage[primaryIndex] == None:
            if primaryIndex == 0:
                self.storage[primaryIndex] = [-1] * (self.secondaryBuckets + 1)
            else:
                self.storage[primaryIndex] = [-1] * self.secondaryBuckets
        secondaryIndex = self.getSecondaryHash(key)
        self.storage[primaryIndex][secondaryIndex] = value
    
    def remove(self, key):
        primaryIndex = self.getPrimaryHash(key)
        if self.storage[primaryIndex] == None:
            return
        secondaryIndex = self.getSecondaryHash(key)
        self.storage[primaryIndex][secondaryIndex] = -1
    
    def get(self, key):
        primaryIndex = self.getPrimaryHash(key)
        if self.storage[primaryIndex] == None:
            return -1
        secondaryIndex = self.getSecondaryHash(key)
        return self.storage[primaryIndex][secondaryIndex]