'''
Did it run on leetcode: Yes
Challenges faced: None

Algorithm:
1 -> Take an array of 1000000 initialized with -1
2 -> whenever you want to put a value make the index value =1
3 -> whenever you want to remove make the index value=-1
'''


class MyHashSet(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.hashmap = [-1]*1000000
        

    def add(self, key):
        """
        :type key: int
        :rtype: None
        """
        self.hashmap[key] = 1
        

    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        self.hashmap[key] = -1
        

    def contains(self, key):
        """
        Returns true if this set contains the specified element
        :type key: int
        :rtype: bool
        """
        return self.hashmap[key]==1
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)