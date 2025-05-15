"""
Time Complexity -> On average,it will be O(1) for all the methods
Space Complexity = O(capacity)
Used chaining method for collision resolution.
"""


class ListNode:
    def __init__(self, key=-1, value=-1):
        self.key = key
        self.value = value
        self.next = None


class MyHashMap:

    def __init__(self):
        self.capacity = 1000
        self.map = [ListNode() for _ in range(self.capacity)]

    def hash(self, key):
        return key % self.capacity

    def find(self, head, key):
        prev = head
        curr = head.next
        while curr and curr.key != key:
            prev = curr
            curr = curr.next
        return prev

    def put(self, key: int, value: int) -> None:
        index = self.hash(key)
        previous = self.find(self.map[index], key)
        if previous.next:
            previous.next.value = value
        else:
            previous.next = ListNode(key, value)

    def get(self, key: int) -> int:
        index = self.hash(key)
        previous = self.find(self.map[index], key)
        if previous.next:
            return previous.next.value
        return -1

    def remove(self, key: int) -> None:
        index = self.hash(key)
        previous = self.find(self.map[index], key)
        if previous.next:
            previous.next = previous.next.next

# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)
