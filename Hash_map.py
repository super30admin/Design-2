class MyHashMap:
    class Node:
        def __init__(self, key, val):
            self.key = key
            self.val = val
            self.next = None

    def __init__(self):
        self.plength = 10000
        self.ar = [None] * self.plength

    def has1(self, key):
        return key % self.plength

    def find_prev_node(self, head, key):
        prev = head
        curr = head.next

        while (curr and curr.key != key):
            prev = curr
            curr = curr.next

        return prev

    def put(self, key: int, value: int) -> None:

        val1 = self.has1(key)
        if self.ar[val1] is None:
            self.ar[val1] = self.Node(-1, -1)
        prev_node = self.find_prev_node(self.ar[val1], key)

        if prev_node.next is None:
            prev_node.next = self.Node(key, value)
        else:
            prev_node.next.val = value

    def get(self, key: int) -> int:
        val1 = self.has1(key)

        if self.ar[val1] is None:
            return -1
        prev_node = self.find_prev_node(self.ar[val1], key)
        if prev_node.next is None:
            return -1
        return prev_node.next.val

    def remove(self, key: int) -> None:
        val1 = self.has1(key)

        if self.ar[val1] is None:
            return

        prev_node = self.find_prev_node(self.ar[val1], key)
        if prev_node.next is None:
            return -1
        prev_node.next = prev_node.next.next

# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)