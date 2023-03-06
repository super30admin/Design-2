# Brute Force Approach
class MyHashMap(object):

    def __init__(self):
        
        self.hashmap= [-1 for _ in range(1000001)]

    def put(self, key, value):
        """
        :type key: int
        :type value: int
        :rtype: None
        """
        
        self.hashmap[key]= value

    def get(self, key):
        """
        :type key: int
        :rtype: int
        """
        return self.hashmap[key]
        

    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        self.hashmap[key]= -1


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# key=1
# value= 2
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)