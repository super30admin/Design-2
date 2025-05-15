# Time Complexity : O(1)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes (https://leetcode.com/problems/design-hashset/)
# Any problem you faced while coding this : Figuring the size of the hashmap and how to handle collisions.

class MyHashMap:

    def __init__(self):
        self.size = 1000
        self.buckets = [[] for _ in range(self.size)]

    def _hash(self, key: int) -> int:
        return key % self.size

    def put(self, key: int, value: int) -> None:
        index = self._hash(key)
        for i, (k,v) in enumerate(self.buckets[index]):
            if k==key:
                self.buckets[index][i] = (key,value)
                return
        self.buckets[index].append((key, value))

    def get(self, key: int) -> int:
        index = self._hash(key)
        for k, v in self.buckets[index]:
            if k == key:
                return v
        return -1
        

    def remove(self, key: int) -> None:
        index = self._hash(key)
        self.buckets[index] = [(k,v) for k,v in self.buckets[index] if k!=key]


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)