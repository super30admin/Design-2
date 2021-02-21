"""
Search Complexity: O(1)
Addition Complexity: O(1)
Removing Complexity: O(1)
Space Complexity: O(1)

Problems I faced: The code passed the initial test case by leetcode, but it failed the very large test cases and I couldn't figure out why it failed as I tried out multiple similar test cases.
"""

class MyHashSet:

    def __init__(self):
        self.col, self.row = (([False] * 1000), ([False] * 1000))
        self.buckets = 1000
        self.bucketItems = 1000
        """
        Initialize your data structure here.
        """

    def bucket(self, key):
        return int(key / self.buckets)

    def bucketItem(self, key):
        return int(key % self.bucketItems)

    def add(self, key: int) -> None:
        b = self.bucket(key)
        bi = self.bucketItem(key)
        if self.col[b] is False:
            self.col[b] = True
        if self.row[bi] is False:
            self.row[bi] = True
        return

    def remove(self, key: int) -> None:
        b = self.bucket(key)
        bi = self.bucketItem(key)
        if self.col[b] == True and self.row[bi] == True:
            self.col[b] = False
            self.row[bi] = False
        return

    def contains(self, key: int) -> bool:
        b = self.bucket(key)
        bi = self.bucketItem(key)
        if self.col[b] is True:
            if self.row[bi] is True:
                return True
        return False
H = MyHashSet()
print(H.add(1))
print(H.add(2))
print(H.contains(1))
print(H.contains(3))
print(H.add(2))
print(H.contains(2))
print(H.remove(2))
print(H.contains(2))

