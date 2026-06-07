# https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/
# Time Complexity O(1) here both loops have same range so it wont be m+n
# Space Complexity O(n)
class MyHashMap:

    def __init__(self):
        self.primaryBucket = 1000
        self.secondaryBucket = 1000
        self.storage = [None] * self.primaryBucket

    def hash1(self, key):
        return key % self.primaryBucket

    def hash2(self, key):
        return key // self.secondaryBucket

    def put(self, key: int, value: int) -> None:
        primaryIndex = self.hash1(key)
        if self.storage[primaryIndex] == None:
            if primaryIndex == 0:
                self.storage[primaryIndex] = [-1] * (self.secondaryBucket + 1)
            else:
                self.storage[primaryIndex] = [-1] * (self.secondaryBucket)
        secondaryIndex = self.hash2(key)
        self.storage[primaryIndex][secondaryIndex] = value

    def get(self, key: int) -> int:
        primaryIndex = self.hash1(key)
        if self.storage[primaryIndex] == None:
            return -1
        secondaryIndex = self.hash2(key)
        return self.storage[primaryIndex][secondaryIndex]

    def remove(self, key: int) -> None:
        primaryIndex = self.hash1(key)
        if not self.storage[primaryIndex]:
            return
        secondaryIndex = self.hash2(key)
        self.storage[primaryIndex][secondaryIndex] = -1


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)
