# Time Complexity : O(1)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Approach : use an array of buckets with linked lists to handle collisions.
# Each bucket stores a dummy head node, and operations traverse the linked list to insert, find, or remove a key.

class Node:
    def __init__(self, key, value):
        self.key = key
        self.value = value
        self.next = None

class MyHashMap:

    def __init__(self):
        self.capacity = 10000
        self.storage = [Node(None, None) for _ in range(self.capacity)]

    def getHash(self, key: int) -> int:
        return key % self.capacity

    def getPrevNode(self, head: Node, key: int) -> Node:
        prev = None
        curr = head

        while curr and curr.key != key:
            prev = curr
            curr = curr.next

        return prev

    def put(self, key: int, value: int) -> None:
        primaryIndex = self.getHash(key)

        if not self.storage[primaryIndex].key:
            self.storage[primaryIndex] = Node(-1, -1)
            self.storage[primaryIndex].next = Node(key, value)
            return

        prev = self.getPrevNode(self.storage[primaryIndex], key)

        if not prev.next:
            prev.next = Node(key, value)
        else:
            prev.next.value = value
        

    def get(self, key: int) -> int:
        primaryIndex = self.getHash(key)

        if not self.storage[primaryIndex].key:
            return -1

        prevNode = self.getPrevNode(self.storage[primaryIndex], key)

        if not prevNode.next:
            return -1

        return prevNode.next.value

    def remove(self, key: int) -> None:
        primaryIndex = self.getHash(key)

        if not self.storage[primaryIndex].key:
            return

        prev = self.getPrevNode(self.storage[primaryIndex], key)

        if not prev.next:
            return

        prev.next = prev.next.next