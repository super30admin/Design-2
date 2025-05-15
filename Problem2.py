"""
Time Complexity:
- put: O(1)
- get: Amortized O(1), 
- remove: Amortized O(1),

Space Complexity: O(n+k), where n is the number of elements in the queue (e.g., 1000 in this case) and k
is numebr of buckets

Successfully ran on Leetcode: Yes

Notes:
- 
"""


class Node():
    def __init__(self,key):
        self.key = key
        self.next = None

class Node1():

    def __init__(self,key,value):
        self.key = key
        self.value = value
        self.next = None


class MyHashMap(object):

    def __init__(self):
        self.hash_map = [Node(i) for i in range(1000)]
        

    def put(self, key, value):
        """
        :type key: int
        :type value: int
        :rtype: None
        """

        bucket = (key%len(self.hash_map))
        rec = self.hash_map[bucket]
        while rec.next:
            if rec.next.key == key:
                rec.next.value = value
                return
            rec = rec.next
        rec.next = Node1(key,value)
        return
        


        

    def get(self, key):
        """
        :type key: int
        :rtype: int
        """
        bucket = (key%len(self.hash_map))
        rec = self.hash_map[bucket]
        while rec.next:
            if rec.next.key == key:
                return rec.next.value
            rec = rec.next
        return -1
        


        

    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        bucket = (key%len(self.hash_map) )
        rec = self.hash_map[bucket]
        while rec.next:
            if rec.next.key == key:
                rec.next = rec.next.next
                return
            rec = rec.next


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)