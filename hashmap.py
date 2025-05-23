"""
# Time Complexity :
- init: O(1)
- put: O(N) in worst case (traverse linked list in a bucket)
- get: O(N) in worst case
- remove: O(N) in worst case

# Space Complexity :
- O(K), where K is the number of unique keys stored

# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
"""

class ListNode:
    def __init__(self, key, value):
        self.key = key
        self.value = value
        self.next = None

class MyHashMap:

    def __init__(self):
        self.size = 1000
        self.buckets = [None] * self.size

    def _hash(self, key):
        return key % self.size

    def put(self, key: int, value: int) -> None:
        index = self._hash(key)
        if self.buckets[index] is None:
            self.buckets[index] = ListNode(key, value)
        else:
            curr = self.buckets[index]
            while True:
                if curr.key == key:
                    curr.value = value
                    return
                if curr.next is None:
                    break
                curr = curr.next
            curr.next = ListNode(key, value)

    def get(self, key: int) -> int:
        index = self._hash(key)
        curr = self.buckets[index]
        while curr:
            if curr.key == key:
                return curr.value
            curr = curr.next
        return -1

    def remove(self, key: int) -> None:
        index = self._hash(key)
        curr = self.buckets[index]
        if not curr:
            return
        if curr.key == key:
            self.buckets[index] = curr.next
            return
        prev = curr
        curr = curr.next
        while curr:
            if curr.key == key:
                prev.next = curr.next
                return
            prev, curr = curr, curr.next

# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key, value)
# param_2 = obj.get(key)
# obj.remove(key)
