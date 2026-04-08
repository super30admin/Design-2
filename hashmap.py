# // Time Complexity : O(1) for put, get and remove
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : NA

class MyHashMap(object):
    buckets = 1000
    bucket_size=1001

    def __init__(self):
        self.hashmap=[None] * self.buckets

    def hashfunc1(self,key):
        return key % self.buckets
    
    def hashfunc2(self,key):
        return key // self.buckets
        

    def put(self, key, value):
        """
        :type key: int
        :type value: int
        :rtype: None
        """
        primary_bucket = self.hashfunc1(key)
        secondary_index = self.hashfunc2(key)
        if self.hashmap[primary_bucket] is None:
            self.hashmap[primary_bucket] = [None] * self.bucket_size
        
        self.hashmap[primary_bucket][secondary_index] = value

    def get(self, key):
        """
        :type key: int
        :rtype: int
        """
        primary_bucket = self.hashfunc1(key)
        secondary_index = self.hashfunc2(key)

        if self.hashmap[primary_bucket] is not None:
            if self.hashmap[primary_bucket][secondary_index] is not None:
                return self.hashmap[primary_bucket][secondary_index]

        return -1 
        

    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        primary_bucket = self.hashfunc1(key)
        secondary_index = self.hashfunc2(key)

        if self.hashmap[primary_bucket] is not None:
            self.hashmap[primary_bucket][secondary_index]=None


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)