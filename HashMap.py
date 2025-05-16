"""
Time Complexity
#   put()     -> O(n)
#   get()     -> O(n)
#   remove()  -> O(n)

Space Complexity : O(n)

Did this code successfully run on Leetcode : Yes  
Any problem you faced while coding this : No

# using separate chaining with lists to handle collisions.
"""

class MyHashMap(object):

    def __init__(self):
        self.size = 1000
        self.buckets = [[] for _ in range(self.size)]

    def _hash(self, key):
        return key % self.size

    def put(self, key, value):
        h = self._hash(key)
        for i, (k, v) in enumerate(self.buckets[h]):
            if k == key:
                self.buckets[h][i] = (key, value)
                return
        self.buckets[h].append((key, value))

    def get(self, key):
        h = self._hash(key)
        for k, v in self.buckets[h]:
            if k == key:
                return v
        return -1

    def remove(self, key):
        h = self._hash(key)
        for i, (k, v) in enumerate(self.buckets[h]):
            if k == key:
                del self.buckets[h][i]
                return