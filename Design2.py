# Time Complexity : O(1)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach:
# I am using double hashing to create this hashmap. I have created a single bucket that has 1000 size. In the put operation I am
# using the first hash function to find the index of the bucket and the second hash function to find the index within the bucket.
# If the bucket is empty, I create a new bucket with a size of 1001 and insert and update the value of the key. For get I am checking the
# value at the calculated index and returning it if it exists. And for remove I am setting the value back to None for that index.
class MyHashMap:

    def __init__(self):
        self.bucket = [None] * 1000

    def hash1(self,key:int):
        return key%1000
    
    def hash2(self,key:int):
        return key//1000
    
    def put(self, key: int, value: int) -> None:
        i = self.hash1(key)
        j = self.hash2(key)
        if self.bucket[i] is None:
            self.bucket[i] = [None] * 1001
        self.bucket[i][j] = value
        
    def get(self, key: int) -> int:
        i = self.hash1(key)
        j = self.hash2(key)
        if self.bucket[i] is not None:
            if self.bucket[i][j]is not None:
                return self.bucket[i][j]
        return -1

    def remove(self, key: int) -> None:
        i = self.hash1(key)
        j = self.hash2(key)
        if self.bucket[i] is not None:
            if self.bucket[i][j] is not None:
                self.bucket[i][j] = None
        else:
            return 
