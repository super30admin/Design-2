# Time Complexity:
# put: O(1)
# get: O(1)
# remove: O(1)

# Space Complexity:
# O(n+k): n is number of buckets and k is key-pair values


class MyHashMap(object):

    def __init__(self):
        self.size = 1000
        self.list = [[] for i in range(self.size)]
        
    def hash_function(self, key):
        return key % self.size

    def put(self, key, value):
        """
        :type key: int
        :type value: int
        :rtype: None
        """
        hv = self.hash_function(key)
        for item in self.list[hv]:
            if item[0] == key:
                item[1] = value
                return
        self.list[hv].append([key, value])

    def get(self, key):
        """
        :type key: int
        :rtype: int
        """
        hv = self.hash_function(key)
        for item in self.list[hv]:
            if item[0] == key:
                return item[1]  
        return -1
        

    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        hv = self.hash_function(key)
        for index, item in enumerate(self.list[hv]):
            if item[0] == key:
                del self.list[hv][index]


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)