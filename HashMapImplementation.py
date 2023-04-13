# Design Hashmap (https://leetcode.com/problems/design-hashmap/)

# Time Complexity : O(1)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class MyHashMap(object):
    storage = []
    bucket = 2003  # primary number reduces collision
    bucketItem = 2003

    def __init__(self):
        self.storage = [False] * self.bucket
        for i in range(self.bucket):
            self.storage[i] = [False] * self.bucketItem

    def bucketHash(self, key):
        return key % self.bucket

    def bucketItemHash(self, key):
        return key / self.bucketItem

    def put(self, key, value):
        bucketHash = self.bucketHash(key)
        bucketItemHash = self.bucketItemHash(key)
        if not self.storage[bucketHash]:
            self.storage[bucketHash] = [False] * self.bucketItem
        self.storage[bucketHash][bucketItemHash] = value

    def get(self, key):
        bucketHash = self.bucketHash(key)
        bucketItemHash = self.bucketItemHash(key)
        if self.storage[bucketHash]:
            return self.storage[bucketHash][bucketItemHash]
        else:
            return -1

    def remove(self, key):
        bucketHash = self.bucketHash(key)
        bucketItemHash = self.bucketItemHash(key)
        if self.storage[bucketHash]:
            self.storage[bucketHash][bucketItemHash] = False
