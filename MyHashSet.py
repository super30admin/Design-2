# // Time Complexity : O(n)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : Yes
# I am not sure of the solution I implemented because I am not hashing the key
class MyHashSet(object):

    def __init__(self):
        self.hashset = []

    def add(self, key):
        """
        :type key: int
        :rtype: None
        """
        if key not in self.hashset:
            self.hashset.append(key)

    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        if key in self.hashset:
            self.hashset.remove(key)

    def contains(self, key):
        """
        :type key: int
        :rtype: bool
        """
        return key in self.hashset


# Your MyHashSet object will be instantiated and called as such:
key = 1
obj = MyHashSet()
obj.add(key)
obj.remove(key)
param_3 = obj.contains(key)
print(param_3)
