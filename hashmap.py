"""
This implementation uses a chaining approach with a fixed-size array of buckets to handle collisions.
Each bucket is a list that stores elements that hash to the same index, allowing for efficient O(1) average case operations.
The hash function uses modulo operation to map keys to bucket indices, and the implementation handles add, remove, and contains operations with proper collision management.
"""

# Time Complexity : O(1)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class MyHashMap:

    def __init__(self):
        # Initialize with a size of 1000 to handle collisions
        self.size = 1000
        self.buckets = [[] for _ in range(self.size)]
        
    def _hash(self, key: int) -> int:
        # Simple hash function to get bucket index
        return key % self.size

    def put(self, key: int, value: int) -> None:
        # Get the bucket index
        bucket_idx = self._hash(key)
        bucket = self.buckets[bucket_idx]
        
        # Check if key already exists
        for i, (k, v) in enumerate(bucket):
            if k == key:
                bucket[i] = (key, value)
                return
        
        # If key doesn't exist, append new key-value pair
        bucket.append((key, value))

    def get(self, key: int) -> int:
        # Get the bucket index
        bucket_idx = self._hash(key)
        bucket = self.buckets[bucket_idx]
        
        # Search for the key in the bucket
        for k, v in bucket:
            if k == key:
                return v
        
        # Key not found
        return -1

    def remove(self, key: int) -> None:
        # Get the bucket index
        bucket_idx = self._hash(key)
        bucket = self.buckets[bucket_idx]
        
        # Find and remove the key-value pair
        for i, (k, v) in enumerate(bucket):
            if k == key:
                bucket.pop(i)
                return


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)