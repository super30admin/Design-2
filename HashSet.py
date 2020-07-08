# Time Complexity : getHash1() - O(1), getHash2() - O(1), add()- O(1), remove - O(1), contains - O(1)
# Space Complexity : o(n^2)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : I see it takes more space, can you suggest what else I can do to reduce it.

class MyHashSet:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.size = 1000
        # This is kind of expensive. I will update later
        self.hashMatrix = [[False for j in range(self.size)] for i in range(self.size)]

    def getHash1(self, value):
        return value % self.size

    def getHash2(self, value):
        return value // self.size

    def add(self, key: int) -> None:
        index1 = self.getHash1(key)
        index2 = self.getHash2(key)

        self.hashMatrix[index1][index2] = True

    def remove(self, key: int) -> None:
        index1 = self.getHash1(key)
        index2 = self.getHash2(key)

        self.hashMatrix[index1][index2] = False

    def contains(self, key: int) -> bool:

        index1 = self.getHash1(key)
        index2 = self.getHash2(key)

        return self.hashMatrix[index1][index2]

# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)