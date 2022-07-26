class Node:
    def __init__(self, key=None, value=None):
        self.key = key
        self.value = value
        self.next = None


class MyHashMap:
    def hashFunction(self, key):
        return key % 10000

    def searchHashMap(self, key, node) -> Node:

        self.prev = node
        self.curr = node.next
        while self.curr is not None and self.curr.key != key:
            self.prev = self.prev.next
            self.curr = self.curr.next
        return self.prev

    def __init__(self):
        self.hashMap = [None] * 10000

    def put(self, key: int, value: int) -> None:
        hash = self.hashFunction(key)
        if self.hashMap[hash] is None:
            self.dummyNode = Node(-1, -1)
            self.hashMap[hash] = self.dummyNode

        self.prev = self.searchHashMap(key, self.hashMap[hash])
        if self.prev.next is None:
            self.prev.next = Node(key, value)
        else:
            self.prev = self.prev.next
            self.prev.value = value

    def get(self, key: int) -> int:
        hash = self.hashFunction(key)
        if self.hashMap[hash] is None:
            return -1
        self.prev = self.searchHashMap(key, self.hashMap[hash])
        if self.prev.next is None:
            return -1
        else:
            return self.prev.next.value

    def remove(self, key: int) -> None:
        hash = self.hashFunction(key)
        if self.hashMap[hash] is None:
            return
        self.prev = self.searchHashMap(key, self.hashMap[hash])
        if self.prev.next is None:
            return
        else:
            self.prev.next = self.prev.next.next


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)
