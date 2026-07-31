# Time Complexity:
# Average: O(1) for put, get, and remove
# Worst case: O(n) if all keys fall into the same bucket

# Space Complexity: O(B + n), where B is the number of buckets and n is the number of key-value pairs

# Did this code successfully run on LeetCode: Yes

# Approach:
# 1. Use an array of buckets and calculate the bucket index using key % bucket_count.
# 2. Each bucket is a Python list that stores [key, value] pairs to handle collisions.
# 3. Search only within the selected bucket for put, get, and remove operations.

class MyHashMap(object):

    def __init__(self):
        self.buckets = 1009       # A prime number helps distribute keys more evenly
        self.storage = [None] * self.buckets
        

    def get_hash(self, key):
        return key % self.buckets

    def put(self, key, value):
        """
        :type key: int
        :type value: int
        :rtype: None
        """
        index = self.get_hash(key)
        if self.storage[index] is None:
            self.storage[index] = []

        bucket = self.storage[index]
        for pair in bucket:
            if pair[0] == key:
                pair[1] = value
                return
        bucket.append([key, value])
        

    def get(self, key):
        """
        :type key: int
        :rtype: int
        """
        index = self.get_hash(key)
        bucket = self.storage[index]
        if bucket is None:
            return -1
        for pair in bucket:
            if pair[0] == key:
                return pair[1]
        return -1
        

    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        index = self.get_hash(key)
        bucket = self.storage[index]
        if bucket is None:
            return -1
        for i, pair in enumerate(bucket):
            if pair[0] == key:
                bucket.pop(i)
                if len(bucket) == 0:
                    self.storage[index] = None
                return
        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)