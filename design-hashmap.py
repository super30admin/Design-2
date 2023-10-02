
# Q. Design queue using stacks
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Intuition: Designing hashmap with double hashing.

class MyHashMap:

    def __init__(self):
        self.primArrLen = 1000  # primary array length = 1000
        # initialize primary Array with null ptr
        self.primArr = [None] * self.primArrLen
        self.secArrLen = 1000  # sec nested array length = 1000

    def hash1(self, key):
        return key % self.primArrLen

    def hash2(self, key):
        return key//self.secArrLen

    def put(self, key: int, value: int) -> None:  # TC: O(1) SC: O(1000) i.e scales with input
        hash1 = self.hash1(key)
        hash2 = self.hash2(key)

        if self.primArr[hash1] is None:
            # initialize sec array with -1 ptr
            if hash1 == 0:
                # if 0th idx of primary array, add + 1 to length of nested array to handle boundary case
                self.primArr[hash1] = [-1] * (self.secArrLen+1)
            else:
                self.primArr[hash1] = [-1] * (self.secArrLen)

        self.primArr[hash1][hash2] = value
        return

    def get(self, key: int) -> int:  # TC: O(1) SC: O(1)
        hash1 = self.hash1(key)
        hash2 = self.hash2(key)

        if self.primArr[hash1] is None:
            return -1

        return self.primArr[hash1][hash2]

    def remove(self, key: int) -> None:  # TC: O(1) SC: O(1)
        hash1 = self.hash1(key)
        hash2 = self.hash2(key)

        if self.primArr[hash1] is None:
            return -1

        self.primArr[hash1][hash2] = self.primArr[hash1][-1]
        return


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)
