# Time Complexity: O(L) (Length of the Linked List)
# Space Complexity: O(n)
class ListNode:

    def __init__(self, key, val):
        self.key = key
        self.val = val
        self.next = None


class MyHashMap:

    def __init__(self):
        self.buckets = 1000
        self.storage = [None] * 10000

    def get_hash(self, key):
        return key % self.buckets

    def find(self, dummy, key):
        prev = dummy
        curr = dummy.next
        while (curr is not None and curr.key != key):
            prev = curr
            curr = curr.next
        return prev

    def put(self, key: int, value: int) -> None:
        bucket = self.get_hash(key)
        if self.storage[bucket] is None:
            self.storage[bucket] = ListNode(-1, -1)
        prev = self.find(self.storage[bucket], key)
        if (prev.next is None):
            prev.next = ListNode(key, value)
        else:
            prev.next.val = value

    def get(self, key: int) -> int:
        bucket = self.get_hash(key)
        if self.storage[bucket] is None:
            return -1
        prev = self.find(self.storage[bucket], key)
        if prev.next is not None:
            return prev.next.val
        return -1

    def remove(self, key: int) -> None:
        bucket = self.get_hash(key)
        if self.storage[bucket] is None:
            return

        prev = self.find(self.storage[bucket], key)
        if prev.next is not None:
            prev.next = prev.next.next

# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)