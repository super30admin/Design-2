"""
// Time Complexity : o(1) for for all operations
// Space Complexity : o(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : null checks did not check instead of == None in python and it failed for get(0)

"""


class MyHashMap:

    def __init__(self):
        self.map = [None] * 1000
        self.divisor = 1000

    def put(self, key: int, value: int) -> None:
        main_index = key % self.divisor
        if not self.map[main_index]:
            self.map[main_index] = [None] * 1000 if main_index != 0 else [None] * 1001
        secondary_index = key // self.divisor
        self.map[main_index][secondary_index] = value

    def get(self, key: int) -> int:
        main_index = key % self.divisor
        if not self.map[main_index]:
            return -1
        secondary_index = key // self.divisor
        if self.map[main_index][secondary_index] == None:
            return -1
        return self.map[main_index][secondary_index]

    def remove(self, key: int) -> None:
        main_index = key % self.divisor
        if not self.map[main_index]:
            return
        secondary_index = key // self.divisor
        if self.map[main_index][secondary_index] == None:
            return
        self.map[main_index][secondary_index] = None


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)
