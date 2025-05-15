# Fixed-size array of linked lists to implement a hash map, where each index corresponds to a bucket that stores key-value pairs.
# Hash function to map keys to indices of the array for retrieval of key-value pairs.

class ListNode:
    def __init__(self, key, val, next=None):
        self.key = key
        self.val = val
        self.next = next

class MyHashMap:
    def __init__(self):
        """
        Time complexity: O(n)
        Space complexity: O(n)
        """
        self.size = 10000
        self.data = [None] * self.size

    def _hash(self, key):
        """
        Time complexity: O(1)
        Space complexity: O(1)
        """
        return key % self.size

    def put(self, key: int, value: int) -> None:
        """
        Time complexity: O(1) on average, O(n) in the worst case
        Space complexity: O(1)
        """
        self.remove(key)
        h = self._hash(key)
        node = ListNode(key, value, self.data[h])
        self.data[h] = node

    def get(self, key: int) -> int:
        """
        Time complexity: O(1) on average, O(n) in the worst case
        Space complexity: O(1)
        """
        h = self._hash(key)
        node = self.data[h]
        while node:
            if node.key == key:
                return node.val
            node = node.next
        return -1

    def remove(self, key: int) -> None:
        """
        Time complexity: O(1) on average, O(n) in the worst case
        Space complexity: O(1)
        """
        h = self._hash(key)
        node = self.data[h]
        if node is None:
            return
        if node.key == key:
            self.data[h] = node.next
        else:
            while node.next:
                if node.next.key == key:
                    node.next = node.next.next
                    return
                node = node.next
