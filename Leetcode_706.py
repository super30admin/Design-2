# Problem: Design HashMap
# time complexity: O(1)
# space complexity: O(1)

class MyHashMap:
    class Node:
        def __init__(self, key, value):
            self.key = key
            self.value = value
            self.next = None

    def __init__(self):
        self.storage = [None] * 10000

    def hash(self, key):
        return hash(key) % len(self.storage)

    def find(self, node, key):
        curr = node
        prev = None
        while curr is not None and curr.key != key:
            prev = curr
            curr = curr.next
        return prev

    def put(self, key, value):
        idx = self.hash(key)
        if self.storage[idx] is None:
            self.storage[idx] = self.Node(-1, -1)
        prev = self.find(self.storage[idx], key)
        if prev.next is None:
            prev.next = self.Node(key, value)
        else:
            prev.next.value = value

    def get(self, key):
        idx = self.hash(key)
        if self.storage[idx] is None:
            return -1
        prev = self.find(self.storage[idx], key)
        if prev.next is None:
            return -1
        return prev.next.value

    def remove(self, key):
        idx = self.hash(key)
        if self.storage[idx] is None:
            return
        prev = self.find(self.storage[idx], key)
        if prev.next is None:
            return
        temp = prev.next
        prev.next = prev.next.next
        temp.next = None


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)