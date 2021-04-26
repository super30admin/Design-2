"""
Hash set will only have values or keys and not key-value pair. Values will not be duplicated.
Input is 10^6, so create matrix of size 10^3x10^3
As list size is from 0 to 1000 (not including), this algorithm might fail for storing item 10^6 as it will lead to overflow i.e. hash1() --> 0, hash2() --> 1000, but array size if from 0 to 999 for both primary and ensted array. So, either make the size 1001x1001 or make the nested array size of only the 0th primary array as 1001.

Space Complexity: O(n)
Time Complexity:
Add --> O(n)
Remove --> O(1)
Contains --> O(1)
"""


class MyHashSet:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.arr = [None for i in range(0, 1000)]

    def primaryArray(self, key):
        # hash1
        return key % 1000

    def secondaryArray(self, key):
        # hash2
        return key // 1000

    def add(self, key: int) -> None:
        # as this algorithm will always map to unique index values with no nested array collisions and this is a hash set so we will not be searching for the value w.r.t the key, we can just store boolean values to indicate that the item was added and not the number itself to save space as characters take less space.
        primaryIndex = self.primaryArray(key)
        nestedIndex = self.secondaryArray(key)
        # Create nested array only if there are values to store in the primary array
        if self.arr[primaryIndex] == None:
            if primaryIndex == 0:
                self.arr[primaryIndex] = [None for i in range(0, 1001)]
        self.arr[primaryIndex][nestedIndex] = True

    def remove(self, key: int) -> None:
        primaryIndex = self.primaryArray(key)
        nestedIndex = self.secondaryArray(key)
        if self.arr[primaryIndex] != None:
            self.arr[primaryIndex][nestedIndex] = None

    def contains(self, key: int) -> bool:
        """
        Returns true if this set contains the specified element
        """
        primaryIndex = self.primaryArray(key)
        nestedIndex = self.secondaryArray(key)
        if self.arr[primaryIndex] != None:
            return (self.arr[primaryIndex][nestedIndex] == True)
        else:
            return False

# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)