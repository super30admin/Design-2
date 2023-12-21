#Time Complexity : O(1)
#Space Complexity : O(1)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No


#Your code here along with comments explaining your approach: Implemented the approach discussed in the class.
class MyHashSet:
    def __init__(self):
        self.buckets = 1000
        self.bucketitems = 1000
        self.storage = [None] * self.buckets

    def bucket(self, key):
        return key % self.buckets

    def bucket_item(self, key):
        return key // self.bucketitems

    def add(self, key):
        bucket = self.bucket(key)
        bucket_item = self.bucket_item(key)
        if self.storage[bucket] is None:
            if bucket == 0:
                self.storage[bucket] = [False] * (self.bucketitems + 1)
            else:
                self.storage[bucket] = [False] * self.bucketitems
        self.storage[bucket][bucket_item] = True

    def remove(self, key):
        bucket = self.bucket(key)
        bucket_item = self.bucket_item(key)
        if self.storage[bucket] is not None:
            self.storage[bucket][bucket_item] = False

    def contains(self, key):
        bucket = self.bucket(key)
        bucket_item = self.bucket_item(key)
        if self.storage[bucket] is None:
            return False
        return self.storage[bucket][bucket_item]