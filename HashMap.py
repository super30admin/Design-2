# Time Complexity:
#   put: O(K) where K is length of the chain (Assumption: k =100) - Hence, its o(1)
#   get: O(1)
#   remove: O(1)

# Space Complexity: O(N) where N is number of unique keys

# Did this code successfully run on Leetcode:
#  Yes

# Explanation:
# We use a fixed-size array of buckets with dummy nodes to handle collisions via linked lists.
# For each operation (put/get/remove), we hash the key to find the correct bucket,
# then traverse that bucket's chain to find or modify the key-value pair.

class ListNode:
    def __init__(self, key=-1, val=-1, next=None):
        self.key = key
        self.val = val
        self.next = next

class MyHashMap:

    def __init__(self):
        # Size of primary array (number of buckets)
        self.size = 10000
        # Initialize buckets with dummy head nodes
        self.buckets = [ListNode() for _ in range(self.size)]

    def _index(self, key: int) -> int:
        # Hash function: key modulo bucket size
        return key % self.size

    def _find(self, head: ListNode, key: int) -> ListNode:
        # Helper to find the node before the one with the given key
        prev = head
        curr = head.next
        while curr and curr.key != key:
            prev = curr
            curr = curr.next
        return prev

    def put(self, key: int, value: int) -> None:
        index = self._index(key)
        prev = self._find(self.buckets[index], key)
        if prev.next:
            # Key exists: update value
            prev.next.val = value
        else:
            # Key doesn't exist: insert new node
            prev.next = ListNode(key, value)

    def get(self, key: int) -> int:
        index = self._index(key)
        prev = self._find(self.buckets[index], key)
        if prev.next:
            return prev.next.val
        return -1

    def remove(self, key: int) -> None:
        index = self._index(key)
        prev = self._find(self.buckets[index], key)
        if prev.next:
            prev.next = prev.next.next
