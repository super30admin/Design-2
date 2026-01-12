"""
Implemented hashmap using linkedList - used array to locate the address of the key using hash function
create dummy Node first and then point the given key, value to next
getprev method gets the previous Node so that we can handle all the cases easily
Time Complexity: O(1) for find the address and O(n) for finding the key
Space Complexity: O(n)
"""
class Node:
    def __init__(self, key, val):
        self.key = key
        self.val = val
        self.next = None


class MyHashMap:

    def __init__(self):
        self.bucket = [None] * 1000

    def hash1(self, key):
        return key % 1000

    def getPrev(self, key, head):

        prev = None
        curr = head

        while curr and curr.key != key:
            prev = curr
            curr = curr.next

        return prev

    def put(self, key: int, value: int) -> None:

        h1 = self.hash1(key)

        if not self.bucket[h1]:
            self.bucket[h1] = Node(-1, -1)
            self.bucket[h1].next = Node(key, value)
            return

        prev = self.getPrev(key, self.bucket[h1])

        if prev.next:
            prev.next.val = value
            return

        prev.next = Node(key, value)
        return

    def get(self, key: int) -> int:

        h1 = self.hash1(key)

        if not self.bucket[h1]:
            return -1

        prev = self.getPrev(key, self.bucket[h1])

        if prev.next:
            return prev.next.val

        return -1

    def remove(self, key: int) -> None:

        h1 = self.hash1(key)

        if not self.bucket[h1]:
            return

        prev = self.getPrev(key, self.bucket[h1])

        if prev.next:
            prev.next = prev.next.next
            return


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)
