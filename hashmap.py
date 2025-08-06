# Separate Chaining with Singly Linked Lists
class Node:
    def __init__(self, key=-1, value=-1, next=None):
        self.key = key
        self.val = value
        self.next = next

class MyHashMap:
    def __init__(self):
        self.buckets = 10000
        self.storage = [None] * self.buckets

    def _getHash(self, key):
        return key % self.buckets

    def _getPrev(self, head, key):
        prev = head
        curr = head.next
        while curr and curr.key != key:
            prev = curr
            curr = curr.next
        return prev

    def put(self, key: int, value: int) -> None:
        index = self._getHash(key)
        if self.storage[index] is None:
            self.storage[index] = Node()   #Dummy node
            self.storage[index].next = Node(key,value)
            return
        prev = self._getPrev(self.storage[index], key)
        if prev.next is None:
            prev.next = Node(key, value)
        else:
            prev.next.val = value

    def get(self, key: int) -> int:
        index = self._getHash(key)
        if self.storage[index] is None:
            return -1
        prev = self._getPrev(self.storage[index], key)
        if prev.next is None:
            return -1
        return prev.next.val

    def remove(self, key: int) -> None:
        index = self._getHash(key)
        if self.storage[index] is None:
            return
        prev = self._getPrev(self.storage[index], key)
        if prev.next is None:
            return
        prev.next = prev.next.next
