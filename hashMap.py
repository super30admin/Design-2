# Use a 2D list to simulate a hash map with double hashing for collision resolution
# The outer list (store) has a fixed size, and each element is either None or an inner list (bucket). The inner list (bucket) is initialized when needed and has a fixed size
# The key is mapped to an index in the outer list using modulo operation. The key is mapped to an index in the inner list using integer division
class MyHashMap:
    def __init__(self):
        self.storeSize = 1000
        self.bucketSize = 1000
        self.store = [None] * self.storeSize

    def getStoreIndex(self, key: int) -> int:
        return key % self.storeSize

    def getBucketIndex(self, key: int) -> int:
        return key // self.storeSize

    def put(self, key: int, value: int) -> None:
        storeIndex = self.getStoreIndex(key)
        if self.store[storeIndex]:
            bucketIndex = self.getBucketIndex(key)
            self.store[storeIndex][bucketIndex] = value
            return
        if storeIndex == 0:
            self.store[storeIndex] = [-1] * (self.bucketSize + 1)
        else:
            self.store[storeIndex] = [-1] * self.bucketSize
        bucketIndex = self.getBucketIndex(key)
        self.store[storeIndex][bucketIndex] = value

    def get(self, key: int) -> int:
        storeIndex = self.getStoreIndex(key)
        if not self.store[storeIndex]:
            return -1
        bucketIndex = self.getBucketIndex(key)
        return self.store[storeIndex][bucketIndex]

    def remove(self, key: int) -> None:
        storeIndex = self.getStoreIndex(key)
        if not self.store[storeIndex]:
            return
        bucketIndex = self.getBucketIndex(key)
        self.store[storeIndex][bucketIndex] = -1