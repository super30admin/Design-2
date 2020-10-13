#Time Complexity : O(n/k) where n = total number of elements in the set and k = number of buckets
#Space Complexity : O(n) where n = total number of elements in the set
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No


#Your code here along with comments explaining your approach
class ListNode:
    def __init__(self, key, next=None):
        self.key = key
        self.next = next

class MyHashSet:
    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.size = 1000
        self.buckets = [[] for _ in range(self.size)]

    def calculateHash(self, key):
        return key % self.size

    def add(self, key):
        index = self.calculateHash(key)
        cur = self.buckets[index]
        if not cur:
            self.buckets[index] = ListNode(key, None)
            return
        if cur.key == key:
            return
        while cur:
            if cur.key == key:
                return
            if not cur.next:
                cur.next = ListNode(key,None)
                return
            if cur.next:
                cur = cur.next
        return


    def remove(self, key):
        index = self.calculateHash(key)
        cur = self.buckets[index]
        if not cur:
            return
        if cur.key == key:
            self.buckets[index] = cur.next
        while cur.next:
            if cur.next.key == key:
                cur.next = cur.next.next
                return
            cur = cur.next
        return

    def contains(self, key):
        """
        Returns true if this set contains the specified element
        """
        index = self.calculateHash(key)
        cur = self.buckets[index]
        while cur:
            if cur.key == key:
                return True
            cur = cur.next
        return False
