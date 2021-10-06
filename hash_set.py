# Time Complexity: O(1)
# Space Complexity: O (n)
# Did this code successfully run on Leetcode: ✔️
# Any problem you faced while coding this: Is it okay if we use dict to implement this?
class MyHashSet:

    def __init__(self):
        self.hash_size = 10000
        self.hash_set = [None] * self.hash_size

    def calculate_hash(self, value: int) -> int:
        return value % self.hash_size

    def add(self, key: int) -> None:
        hash_value = self.calculate_hash(key)
        if self.hash_set[hash_value] is None:
            self.hash_set[hash_value] = [key]
        else:
            self.hash_set[hash_value].append(key)

    def remove(self, key: int) -> None:
        hash_value = self.calculate_hash(key)
        if self.hash_set[hash_value] is not None:
            while key in self.hash_set[hash_value]:
                self.hash_set[hash_value].remove(key)

    def contains(self, key: int) -> bool:
        hash_value = self.calculate_hash(key)
        if self.hash_set[hash_value] is not None:
            return key in self.hash_set[hash_value]
        return False

# # Your MyHashSet object will be instantiated and called as such:
# key = 1
# obj = MyHashSet()
# obj.add(key)
# print(obj.contains(key))
# obj.remove(key)
