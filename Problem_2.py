# Time Complexity: O(1)
# Space Complexity: O(n)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No

class MyHashMap(object):
    def __init__(self):
        self.data = ([None] * 1000001)

    def put(self, key, value):
        """
        :type key: int
        :type value: int
        :rtype: None
        """
        self.data[key] = value        

    def get(self, key):
        """
        :type key: int
        :rtype: int
        """
        value = self.data[key]
        return value if value != None else -1
        
    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        self.data[key] = None

# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)