class MyHashSet(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.set=[0]*1000000

    def add(self, key):
        """
        :type key: int
        :rtype: None
        """
        self.set[key]=1

    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        
        self.set[key]=0

    def contains(self, key):
        """
        Returns true if this set contains the specified element
        :type key: int
        :rtype: bool
        """
        return self.set[key]==1


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)