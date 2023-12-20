""" Explanation of the Code Below: I initialzed a variable to hold the size for the hash map, since the input is 10**6
    Then I just assigned the value to the given key of the initialized list (array) for insertion
    For deletion, I just lookup the key and reduce the value by -1 for that key, since we know that each key only has one value
    For getting a specific value, I first check if the value for the associated key is not empty, if it's then return none, otherwise return the associated value
    Time Complexcity: O(1)
    Space Complexcity: O(1)
"""



class MyHashMap(object):
    
    def __init__(self):
        array_size = 10**6+1 # +1 so that the 10**6 required space does not go out of index for some cases on LeetCode
        # initializing an empty array
        self.search = [None]*array_size
    

    def put(self, key, value):
        """
        :type key: int
        :type value: int
        :rtype: None
        """
        self.search[key] = value
     
        
    def get(self, key):
        """
        :type key: int
        :rtype: int
        """
        if self.search[key] == None:
            return -1
        return self.search[key]
        

    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        self.search[key] = -1
   


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)