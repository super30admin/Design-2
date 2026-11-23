# Time Complexity :
# Space Complexity :
# Did this code successfully run on Leetcode :
# Any problem you faced while coding this :
#
# Approach (3 sentences only):
#


class MyHashMap:

    def __init__(self):
        self.arr_size = 1000
        self.sec_size = 1000
        self.storage = [None] * self.arr_size

    def primary(self, key):
        return key % self.arr_size

    def secondary(self, key):
        return key // self.sec_size

    def put(self, key: int, value: int) -> None:
        index = self.primary(key)
        if self.storage[index] is None:
            size = self.sec_size + 1 if self.primary(key) == 0 else self.sec_size
            self.storage[index] = [-1] * size
        self.storage[index][self.secondary(key)] = value


    def get(self, key: int) -> int:
        i = self.primary(key)
        if self.storage[i] is None:
            return -1
        return self.storage[i][self.secondary(key)]

    def remove(self, key: int) -> None:
        i = self.primary(key)
        if self.storage[i] is not None:
            self.storage[i][self.secondary(key)] = -1
            
        


if __name__ == "__main__":
    m = MyHashMap()
    m.put(1, 1)
    m.put(2, 2)
    print(m.get(1))  # 1
    print(m.get(3))  # -1
    m.put(2, 1)
    print(m.get(2))  # 1
    m.remove(2)
    print(m.get(2))  # -1
