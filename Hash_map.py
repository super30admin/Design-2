# Time Complexity : O(n)
# Space Complexity : O(n) 
# Did this code successfully run on Leetcode : yea
# Any problem you faced while coding this :
'''  understanding the concept took time and also I amnew to this so I took help from GPT looks like i need more practice on this concept'''

#Your code here along with comments explaining your approach

class MyHashMap:

    def __init__(self):
        self.size = 1000
        self.buckets = [[] for _ in range(self.size)]

    def hash(self, key):
        return key % self.size

    def put(self, key: int, value: int) -> None:
        index = self.hash(key)
        for i, (k, v) in enumerate(self.buckets[index]):
            if k == key:
                self.buckets[index][i] = (key, value)
                return
        self.buckets[index].append((key, value))

    def get(self, key: int) -> int:
        index = self.hash(key)
        for k, v in self.buckets[index]:
            if k == key:
                return v
        return -1

    def remove(self, key: int) -> None:
        index = self.hash(key)
        self.buckets[index] = [(k, v) for (k, v) in self.buckets[index] if k != key]
