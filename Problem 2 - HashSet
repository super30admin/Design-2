# // Time Complexity : O(1)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : None


class MyHashSet:

    def __init__(self):
        self.buckets = 1000
        self.bucketList = 1000
        self.storage = [None] * self.buckets
    
    def bucketHash(self, key):
        return key % self.buckets
    
    def bucketlistHash(self, key):
        return key // self.bucketList
        
    def add(self, key: int) -> None:
        bucketIdx = self.bucketHash(key)
        if self.storage[bucketIdx] is None:
            if bucketIdx == 0:
                self.storage[bucketIdx] = [False] * (self.bucketList + 1)
            else : 
                self.storage[bucketIdx] = [False] * self.bucketList
        bucketlistIdx = self.bucketlistHash(key)
        self.storage[bucketIdx][bucketlistIdx] = True

    def remove(self, key: int) -> None:
        bucketIdx = self.bucketHash(key)
        bucketlistIdx = self.bucketlistHash(key)
        
        if self.storage[bucketIdx] is None:
            return
    
        self.storage[bucketIdx][bucketlistIdx] = False
        

    def contains(self, key: int) -> bool:
        bucketIdx = self.bucketHash(key)
        bucketlistIdx = self.bucketlistHash(key)
        
        if self.storage[bucketIdx] is None:
            return False
    
        return self.storage[bucketIdx][bucketlistIdx] 
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)
