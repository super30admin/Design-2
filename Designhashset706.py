# --------------------------------------------------------------------
# Time Complexity : O(1)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
#-------------------------------------------------------------------------------
class MyHashSet:

    def __init__(self):
        self.buckets=1000
        self.bucketsItems=1000
        self.storage=[False] * self.buckets
    
    def getBucket(self,key)->int:
        return key % self.buckets
    
    def getBucketItems(self,key)->int:
        return key // self.bucketsItems

    def add(self, key: int) -> None:
        bucket=self.getBucket(key)
        bucketItems =self.getBucketItems(key)
        
        if (self.storage[bucket]==False):
            if bucket ==0:
                self.storage[bucket]=[False]*(self.bucketsItems+1)
            else:
                self.storage[bucket]=[False]*(self.bucketsItems)
        self.storage[bucket][bucketItems]=True

    def remove(self, key: int) -> None:
        bucket=self.getBucket(key)
        bucketItems=self.getBucketItems(key)
        if self.storage[bucket] is False:
            return
        self.storage[bucket][bucketItems]=False

    def contains(self, key: int) -> bool:
        bucket=self.getBucket(key)
        bucketItems=self.getBucketItems(key)
        if self.storage[bucket] == False:
            return self.storage[bucket]
        else:
            return self.storage[bucket][bucketItems]
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)
