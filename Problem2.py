"""
DESIGN HASHMAP
https://leetcode.com/problems/design-hashmap/
"""

# put(key, value):
# Traverse linked list in that bucket → O(k), where k = # of nodes in that bucket.
# Average case (with good hash and large table size): O(1).
# Worst case (all keys collide into one bucket): O(n).

# get(key):
# Traverse list in that bucket → O(k).
# Average: O(1), Worst: O(n)

# remove(key):
# Traverse list in bucket → O(k).
# Average: O(1), Worst: O(n).

# Overall average: O(1) (amortized)

class ListNode(object):
    def __init__(self, key = -1, value = -1, next=None):
        self.key = key
        self.value = value
        self.next = next

class MyHashMap(object):

    def __init__(self):
        self.size = 10000
        self.table = [ListNode] * self.size
        
    def calculate_hash_value(self, key):
        return key % self.size
    
    def put(self, key, value):
        """
        :type key: int
        :type value: int
        :rtype: None
        """
        hv = self.calculate_hash_value(key)
        cur = self.table[hv]
        while cur.next:
            if cur.next.key == key:
                cur.next.value = value
                return
            cur = cur.next
        cur.next = ListNode(key, value)    

    def get(self, key):
        """
        :type key: int
        :rtype: int
        """
        hv = self.calculate_hash_value(key)
        cur = self.table[hv]
        while cur:
            if cur.key == key:
                return cur.value
            cur = cur.next
        return -1 

    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        hv = self.calculate_hash_value(key)
        cur = self.table[hv]
        while cur and cur.next:
            if cur.next.key == key:
                cur.next = cur.next.next
                return
            cur = cur.next
        