# Time Complexity : O(1) for all operations
# Space Complexity : O(1) for all operations
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach in three sentences only

class MyHashMap:

    def __init__(self):
        # Initalize bucket with 1000
        self.primary_bucket = 1000
        # Dynamically allocate second buckte
        self.secondary_bucket = 1000
        self.storage = [None] * self.primary_bucket

    # Calculate primary hash
    def primary_hash(self, key: int) -> int:
        return key % self.primary_bucket

    # Calculate Scondary Hash
    def secondary_hash(self, key: int) -> int:
        return key // self.secondary_bucket

    def put(self, key: int, value: int) -> None:
        primary_index = self.primary_hash(key)
        if self.storage[primary_index] is None:
            # Handling edge case for max element
            if primary_index == 0:
                self.storage[primary_index] = [None] * (self.secondary_bucket + 1)
            else:
                # Dynamically allocation
                self.storage[primary_index] = [None] * self.secondary_bucket
        secondary_index = self.secondary_hash(key)
        # After retrieving primary and secondary index storing the value at that location
        self.storage[primary_index][secondary_index] = value

    def get(self, key: int) -> int:
        # Retrieve primary and secondary indexes
        primary_index = self.primary_hash(key)
        secondary_index = self.secondary_hash(key)
        # If primary index position or combo of primary and secondary index both are empty return -1
        if self.storage[primary_index] is None or self.storage[primary_index][secondary_index] is None:
            return -1
        else:
            # Retreive element at the location
            return self.storage[primary_index][secondary_index]

    def remove(self, key: int) -> None:
        # Retrieve primary and secondary indexes
        primary_index = self.primary_hash(key)
        secondary_index = self.secondary_hash(key)
        # If primary index is none do nothing
        if self.storage[primary_index] is None:
            return
        else:
            # Setting element at the location to None
            self.storage[primary_index][secondary_index] = None

# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)