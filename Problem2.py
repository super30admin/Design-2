class MyHashMap:
    class Node:
        def __init__(self, key: int, val: int):
            self.key = key
            self.val = val
            self.next = None

    def __init__(self):
        self.buckets = 10000
        self.storage = [None] * self.buckets

    def hash(self, key: int) -> int:
        return key % self.buckets

    def put(self, key: int, value: int) -> None:
        bucket = self.hash(key)
        if self.storage[bucket] is None:
            self.storage[bucket] = self.Node(-1, -1)
        prev_node = self._find_prev_node(key, bucket)
        if prev_node.next is None:
            prev_node.next = self.Node(key, value)
        else:
            prev_node.next.val = value

    def get(self, key: int) -> int:
        bucket = self.hash(key)
        prev_node = self._find_prev_node(key, bucket)
        if prev_node.next is None:
            return -1
        else:
            return prev_node.next.val

    def remove(self, key: int) -> None:
        bucket = self.hash(key)
        prev_node = self._find_prev_node(key, bucket)
        if prev_node.next is not None:
            prev_node.next = prev_node.next.next

    def _find_prev_node(self, key: int, bucket: int) -> Node:
        if self.storage[bucket] is None:
            return self.Node(-1, -1)
        prev_node = self.storage[bucket]
        while prev_node.next is not None and prev_node.next.key != key:
            prev_node = prev_node.next
        return prev_node
