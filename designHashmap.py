# Time Complexity: put / get / remove → O(1) average
# Space Complexity: O(n) where n = number of key-value pairs
# Did this code successfully run on LeetCode: Yes
# Any problem faced while coding: No
# Approach: Separate chaining using a linked list per bucket.


class Node:
    def __init__(self, key: int, val: int):
        self.key = key
        self.val = val
        self.next = None


class MyHashMap:
    def __init__(self):
        self.size = 10**2
        self.buckets = [Node(-1, -1) for _ in range(self.size)]  # dummy heads

    def _hash(self, key: int) -> int:
        return key % self.size

    def put(self, key: int, value: int) -> None:
        idx = self._hash(key)
        curr = self.buckets[idx]

        # search if key exists → update
        while curr.next:
            if curr.next.key == key:
                curr.next.val = value
                return
            curr = curr.next

        # else append new node
        curr.next = Node(key, value)

    def get(self, key: int) -> int:
        idx = self._hash(key)
        curr = self.buckets[idx].next  # first real node

        while curr:
            if curr.key == key:
                return curr.val
            curr = curr.next

        return -1

    def remove(self, key: int) -> None:
        idx = self._hash(key)
        curr = self.buckets[idx]  # start at dummy

        while curr.next:
            if curr.next.key == key:
                curr.next = curr.next.next
                return
            curr = curr.next
