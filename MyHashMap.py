"""
Approach:

Implement Hashmap using list of list of size k (any constant value) - call it buckets (outer list)

Store key,value pair as a list in a bucket at an index
Index is determined using hash function
Store bucket in buckets list

buckets (example):

[
[],                                       bucket at index 0
[[1,24], [1001,5], [2001, 7],......],     bucket at index 1
[],                                       bucket at index 2
[[3,8], [1003,27], [8003, 4],.....],      bucket at index 3
.
.
.
[],                                       bucket at index 999
]

Time Complexity: O(1)
Space = O(k) + O(n)
      ~ O(n) where n is the number of pairs stored

"""

class MyHashMap:

    def __init__(self):
        self.size = 1000
        self.buckets = [[] for _ in range(self.size)]

    def _hash(self, key: int) -> int:
        return key%self.size    

    def put(self, key: int, value: int) -> None:
        # find bucket where we can store given key,value pair using hash function
        bucket = self.buckets[self._hash(key)]

        for pair in bucket:
            # if key already exists in bucket (e.g. [1,5]), and we have push(1,9) update key with new value instead of adding duplicate key
            if pair[0] == key:
                pair[1] = value
                return
        
        # if new key: add pair in bucket
        bucket.append([key,value])
        

    def get(self, key: int) -> int:
        # find bucket where we can find the value
        bucket = self.buckets[self._hash(key)]
        
        # once you find bucket, iterate through pairs and find value
        for k,v in bucket:
            if k == key:
                return v
        # element not found
        return -1
        

    def remove(self, key: int) -> None:
        # find bucket from which we need to remove pair
        bucket = self.buckets[self._hash(key)]

        for i, (k,v) in enumerate(bucket):
            # if you found key, delete key value pair from bucket
            if k == key:
                bucket.pop(i)
                return
        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)