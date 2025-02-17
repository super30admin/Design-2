class ListNode:
    def __init__(self, key, val):
        self.data = (key, val)
        self.next = None

class MyHashMap:
    def __init__(self):
        self.hash1 = 1001
        self.storage = [None] * self.hash1

    def put(self, key: int, value: int) -> None:
        hash1 = key % self.hash1
        if not self.storage[hash1]:
            self.storage[hash1] = ListNode(key, value)
        else:
            curr = self.storage[hash1]
            while curr:
                if curr.data[0] == key:
                    curr.data = (key, value)
                    return
                if not curr.next:
                    break
                curr = curr.next
            curr.next = ListNode(key, value)

    def get(self, key: int) -> int:
        hash1 = key % self.hash1
        curr = self.storage[hash1]
        while curr:
            if curr.data[0] == key:
                return curr.data[1]
            curr = curr.next
        return -1

    def remove(self, key: int) -> None:
        hash1 = key % self.hash1
        curr = self.storage[hash1]
        prev = None
        while curr:
            if curr.data[0] == key:
                if prev:
                    prev.next = curr.next
                else:
                    self.storage[hash1] = curr.next
                return
            prev, curr = curr, curr.next
