#
class MyHashSet(object):

    def __init__(self):
        self.MyHash= {}

    def add(self, key):
        """
        :type key: int
        :rtype: None
        """
        self.MyHash[key]=key

        

    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        del self.MyHash[key]
        

    def contains(self, key):
        """
        :type key: int
        :rtype: bool
        """
        if key in self.MyHash:
            return True
        else:
            return False
        


# Your MyHashSet object will be instantiated and called as such:
obj = MyHashSet()
obj.add(4)
param_3 = obj.contains(4)
print(param_3)
obj.remove(4)
param_3 = obj.contains(4)
print(param_3)