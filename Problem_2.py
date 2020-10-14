"""
Time Complexity : O(1)
Space Complexity : O(n)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this :No
Your code here along with comments explaining your approach:
I have used double hashing for this question. Firstly i have defined an array of size 1000. I have taken 1000
as it is the square root of the limit of range of numbers. Now, whenever a number is added, the first 
hash function will be calculated as key%1000. If that index is already None, I will create another array there
of size 1001, calculate another index by using hash function 2 as key/1001. Go to index, array[index1][index2] and save the value
similarly, for removing, go to the particular location and make it false.
Same procedure would be followed for search operation.
"""


class MyHashSet(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.buckets = 1000
        self.bucketitems = 1001
        self.hashset = [None for i in range(self.buckets)]

    def add(self, key):
        """
        :type key: int
        :rtype: None
        """
        index1 = key % self.buckets
        index2 = key / self.bucketitems
        if not self.hashset[index1]:
            self.hashset[index1] = [False for i in range(self.bucketitems)]
        self.hashset[index1][index2] = True

    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        index1 = key % self.buckets
        index2 = key / self.bucketitems
        if not self.hashset[index1]:
            return None
        self.hashset[index1][index2] = False

    def contains(self, key):
        """
        Returns true if this set contains the specified element
        :type key: int
        :rtype: bool
        """
        index1 = key % self.buckets
        index2 = key / self.bucketitems
        if not self.hashset[index1]:
            return False
        return self.hashset[index1][index2]


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)
