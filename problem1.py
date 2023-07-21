# Time Complexity : amortized O(1)
# Space Complexity :O(1) 
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : NO

# Your code here along with comments explaining your approach


class MyHashMap:
    class Node:
        def __init__(self, key, val):
            self.key = key
            self.val = val
            self.next = None

    def __init__(self):
        self.bucket = 100000 # No of Buckets
        self.storage = [None] * self.bucket #array to store buckets
    def _HashIdx(self, key):
        return key % self.bucket
    
    def _find(self, head, key):
        prev = None
        curr = head
        while curr is not None and curr.key != key:
            prev = curr
            curr = curr.next
        return prev

    def put(self, key: int, value: int) -> None:
        idx = self._HashIdx(key)
        if self.storage[idx] is None: #bucket is empty
            self.storage[idx] = self.Node(-1, -1)
        prev = self._find(self.storage[idx], key) #find
        if prev.next is None:
            #does not exist
            prev.next = self.Node(key, value)
        else:
            # key exists, update the value of the existing node
            prev.next.val = value
        
    def get(self, key: int) -> int:
        idx = self._HashIdx(key)
        if self.storage[idx] is None:
            return -1
        prev = self._find(self.storage[idx], key)
        if prev.next is None:
            return -1
        return prev.next.val

    def remove(self, key: int) -> None:
        idx = self._HashIdx(key)
        if self.storage[idx] is None:
            return
        prev = self._find(self.storage[idx], key)
        if prev.next is None:
            return
        prev.next = prev.next.next



        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)

