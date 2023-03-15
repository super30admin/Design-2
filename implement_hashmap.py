# Time Complexity : put, get, remove- O(1)
# Space Complexity :O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach
"""Used a very similar appraoch as implementing a Hashset, but intead or storing True or False, 
stored the value itself at the relevant indices."""

class MyHashMap:

    def __init__(self):
        self.bucketsize = 1000
        self.array1 = [-1] * self.bucketsize

    def put(self, key: int, value: int) -> None:
        bucket = key%1000
        bucketitem = key//1000

        if self.array1[bucket] == -1:
            if bucket == 0:
                self.array1[bucket] = [-1] * (self.bucketsize + 1)
            else:
                self.array1[bucket] = [-1] * self.bucketsize
        
        self.array1[bucket][bucketitem] = value
        
    def get(self, key: int) -> int:
        bucket = key%1000
        bucketitem = key//1000

        if self.array1[bucket] == -1: return self.array1[bucket]
        else: return self.array1[bucket][bucketitem] 

    def remove(self, key: int) -> None:
        bucket = key%1000
        bucketitem = key//1000

        if self.array1[bucket] != -1: 
            self.array1[bucket][bucketitem] = -1 
        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)