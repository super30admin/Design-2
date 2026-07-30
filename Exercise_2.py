# Design HashMap
# https://leetcode.com/problems/design-hashmap/

# Time complexity: O(1)
# Space complexity: O(n)

# Use hashing and linear chaining - use a larger bucket size to reduce the number of collisions and also make the traversal in the buckets tend to constant time lookup;
# HashMap contains both a key and a value, hence a Node needs to be used instead of just one value.

class Node:
    def __init__(
        self,
        key: int = -1,
        value: int = -1,
        next_node: Node | None = None
    ):
        self.key = key
        self.value = value
        self.next = next_node


class MyHashMap:

    def __init__(self):
        self.primary_buckets = 10000
        self.storage = [Node() for _ in range(self.primary_buckets)]

    def _get_hash(self, key: int) -> int:
        return key % self.primary_buckets

    def _get_prev(self, key: int) -> Node:
        bucket_index = self._get_hash(key)
        prev = self.storage[bucket_index]
        curr = prev.next

        while curr is not None and curr.key != key:
            prev = curr
            curr = curr.next

        return prev

    def put(self, key: int, value: int) -> None:
        prev = self._get_prev(key)

        if prev.next is not None:
            prev.next.value = value
        else:
            prev.next = Node(key, value)

    def get(self, key: int) -> int:
        prev = self._get_prev(key)

        if prev.next is None:
            return -1

        return prev.next.value

    def remove(self, key: int) -> None:
        prev = self._get_prev(key)

        if prev.next is not None:
            prev.next = prev.next.next


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)
