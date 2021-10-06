# Time Complexity: O(1)
# Space Complexity: O (n)
# Did this code successfully run on Leetcode: ✔️
# Any problem you faced while coding this: Is it okay if we use dict to implement this?

class MyHashSet:

    def __init__(self):
        self.hash_set = dict()

    def add(self, key: int) -> None:
        self.hash_set[key] = 1

    def remove(self, key: int) -> None:
        if key in self.hash_set:
            del self.hash_set[key]

    def contains(self, key: int) -> bool:
        return True if key in self.hash_set else False

# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)