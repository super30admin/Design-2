# Time Complexity O(1)
# Space Compelxity O(n)


class MyHashSet:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.hash = set()

    def add(self, key: int) -> None:
        
        self.hash.add(key)

    def remove(self, key: int) -> None:
        self.hash.discard(key)

    def contains(self, key: int) -> bool:
        """
        Returns true if this set contains the specified element
        """
        if key in self.hash:
            return True
        return False
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)
