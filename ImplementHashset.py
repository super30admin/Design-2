#Time Complexity : O(n/k) where n = total number of elements in the set and k = number of buckets
#Space Complexity : O(n) where n = total number of elements in the set
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No


#Your code here along with comments explaining your approach
class MyHashSet:
    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.bucketSize = 1000
        self.innerBucketSize = 1000
        self.buckets = [None for _ in range(self.bucketSize)]

    def calculateHash(self, key):
        return key % self.bucketSize

    def calculateInnerHash(self, key):
        return key//self.innerBucketSize

    def add(self, key):
        index = self.calculateHash(key)
        if not self.buckets[index]:
            self.buckets[index] = [None for _ in range(self.innerBucketSize)]

        self.buckets[index][self.calculateInnerHash(key)] = True

    def remove(self, key):
        index = self.calculateHash(key)
        if not self.buckets[index]:
            return
        self.buckets[index][self.calculateInnerHash(key)] = False

    def contains(self, key):
        """
        Returns true if this set contains the specified element
        """
        index = self.calculateHash(key)
        if not self.buckets[index]:
            return False
        return self.buckets[index][self.calculateInnerHash(key)]
