# Time Complexity : O(1)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class MyHashSet:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.hashSet = {}
        

    def add(self, key: int) -> None:
        self.hashSet[key] = True

    def remove(self, key: int) -> None:
        if key in self.hashSet:
            del self.hashSet[key]

    def contains(self, key: int) -> bool:
        """
        Returns true if this set contains the specified element
        """
        if key in self.hashSet:
            return True
        return False
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)