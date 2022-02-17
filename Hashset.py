class MyHashSet:

    # Time Complexity : O(1)
    # Space Complexity : O(n)
    # Did this code successfully run on Leetcode : Yes
    # Any problem you faced while coding this : No

    # Initialize a 2D array of 1000
    def __init__(self):
        self.hashset = [[] for _ in range(1000)]

    # Time Complexity : O(1)
    # Space Complexity : O(1)
    # Did this code successfully run on Leetcode : Yes
    # Any problem you faced while coding this : No

    # Hash the key and check if it exists, if not then add it to the sub array
    def add(self, key: int) -> None:
        hashkey = key%1000
        if not self.contains(key):
            self.hashset[hashkey].append(key)

    # Time Complexity : O(1)
    # Space Complexity : O(1)
    # Did this code successfully run on Leetcode : Yes
    # Any problem you faced while coding this : No

    # Check if the key exists, if it does then remove it
    def remove(self, key: int) -> None:
        hashkey = key%1000
        if self.contains(key):
            self.hashset[hashkey].remove(key)

    # Time Complexity : O(1)
    # Space Complexity : O(1)
    # Did this code successfully run on Leetcode : Yes
    # Any problem you faced while coding this : No

    # Hash the key and check if the key is the subarray
    def contains(self, key: int) -> bool:
        hashkey = key%1000
        return key in self.hashset[hashkey]


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)
