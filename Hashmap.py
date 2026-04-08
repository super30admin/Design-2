#// Time Complexity : Averge of O(1) unless everything ends up in one bucket.
#// Space Complexity : O(N)
#// Did this code successfully run on Leetcode : Yes
#// Any problem you faced while coding this : Had mutliple issues when converting theory concept to coding like referncing to one with 10000 copies of it. 


#// Your code here along with comments explaining your approach
#using array of buckets and small list to store collions.
#used modulo function as hashing function to find key

class MyHashMap(object):

    def __init__(self):
        self.size = 1001
        self.table = [[] for _ in range(self.size)]

    def _hash(self,key):
        return key % self.size    

    def put(self, key, value):
        """
        :type key: int
        :type value: int
        :rtype: None
        """  
        index = self._hash(key)
        bucket = self.table[index]

        for pair in bucket:
            if pair[0] == key:
                pair[1] = value
                return
        bucket.append([key,value])
          

    def get(self, key):
        """
        :type key: int
        :rtype: int
        """
        index = self._hash(key)
        bucket = self.table[index]

        for pair in bucket:
            if pair[0] == key:
                return pair[1]
        return -1

    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        index = self._hash(key)
        bucket = self.table[index]

        for i,pair in enumerate(bucket):
            if pair[0] == key:
                bucket.pop(i)
                return
        

# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)