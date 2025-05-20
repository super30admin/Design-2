# Time Complexity : O(1)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode :
yes
# Any problem you faced while coding this :
No


# Your code here along with comments explaining your approach

class MyHashMap:

    class Node:
        def __init__(self, key, val):
            self.key = key
            self.val = val
            self.next = None

    def __init__(self):
        self.buckets = 10000
        self.storage = [None] * self.buckets

    def __hash(self, key):
        return key % self.buckets

    def __helper(self, head, key):
        prev = head
        curr = head.next

        while curr is not None and curr.key != key:
            prev = curr
            curr = curr.next
        return prev

    def put(self, key, value):
        idx = self.__hash(key)
        if self.storage[idx] is None:
            self.storage[idx] = self.Node(-1, -1) # Sentinel node
        prev = self.__helper(self.storage[idx], key)
        if prev.next is None:
            prev.next = self.Node(key, value)
        else:
            prev.next.val = value

    def get(self, key):
        idx = self.__hash(key)
        if self.storage[idx] is None:
            return -1
        prev = self.__helper(self.storage[idx], key)
        if prev.next is None:
            return -1
        return prev.next.val

    def remove(self, key):
        idx = self.__hash(key)
        if self.storage[idx] is None:
            return
        prev = self.__helper(self.storage[idx], key)
        if prev.next is None:
            return
        temp = prev.next
        prev.next = prev.next.next
        temp.next = None

# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)