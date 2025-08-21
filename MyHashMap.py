# Time Complexity : O(n) for all the functions. I know we can optimize it to Amortized O(1), but planning to do that after the class to understand better before implementation
# Space Complexity : O(1) for all the functions from user's perspective.
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class MyHashMap:

    def __init__(self):
        self.storage = []

    def put(self, key: int, value: int) -> None:
        for k, v in self.storage:
            if k == key:
                self.storage.remove([k, v])
        self.storage.append([key, value])

    def get(self, key: int) -> int:
        for k, v in self.storage:
            if k == key:
                return v
        return -1

    def remove(self, key: int) -> None:
        for k, v in self.storage:
            if k == key:
                self.storage.remove([k, v])

# Your MyHashMap object will be instantiated and called as such:
obj = MyHashMap()
obj.put(1,1)
obj.put(2, 2)
obj.put(3, 3)
obj.put(2, 1)
param_2 = obj.get(2)
obj.remove(1)