class MyHashMap:

    class Node:
        def __init__(self, key, value):
            self.key = key
            self.value = value
            self.next = None

    # using Linear chaining
    def __init__(self):
        self.primary = 10000
        self.map = [None] * self.primary

    def hash(self, key):
        return key % self.primary

    def getPrev(self, node, key):
        while node.next:
            if node.next.key == key:
                return node
            node = node.next
        return node

    def put(self, key: int, value: int) -> None:
        idx = self.hash(key)
        if not self.map[idx]:
            n = self.Node(key=-1, value=-1)
            self.map[idx] = n
        node = self.map[idx]
        prevNode = self.getPrev(node, key)
        if prevNode.next:
            prevNode.next.value = value
        else:
            prevNode.next = self.Node(key=key, value=value)

    def get(self, key: int) -> int:
        idx = self.hash(key)
        node = self.map[idx]
        if not node:
            return -1
        prevNode = self.getPrev(node, key)
        if prevNode.next:
            return prevNode.next.value
        return -1

    def remove(self, key: int) -> None:
        idx = self.hash(key)
        node = self.map[idx]
        if not node:
            return
        prevNode = self.getPrev(node, key)
        if not prevNode.next:
            return
        prevNode.next = prevNode.next.next


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)
