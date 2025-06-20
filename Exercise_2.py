# Time Complexity : O(l) for put, remove and get operations
# Space Complexity : O(n) where n is the number of elements in the hashmap
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
class Node:
    def __init__(self, key, value, next=None):
        self.key = key
        self.value = value
        self.next = next


class MyHashMap:

    def __init__(self):
        self.buckets = 1000

        self.storage = [None] * self.buckets

    def get_bucket(self, key):
        return key % self.buckets

    def find(self, dummy: Node, key: int) -> Node:

        # traverse the list to return the previous node
        prev = dummy
        curr = dummy.next

        while curr and curr.key != key:
            prev = curr
            curr = curr.next

        # if key is found, return the previous node
        return prev

    def put(self, key: int, value: int) -> None:

        # get bucket index for the key
        index = self.get_bucket(key)

        # if bucket is empty, create a dummy node
        if self.storage[index] is None:
            self.storage[index] = Node(-1, -1)

        prev = self.find(self.storage[index], key)

        if prev.next is None:
            # if key not found, insert new node
            prev.next = Node(key, value)
        else:
            # if key found, update the value
            prev.next.value = value

    def get(self, key: int) -> int:

        index = self.get_bucket(key)

        # if bucket is empty, create a dummy node
        if self.storage[index] is None:
            return -1

        prev = self.find(self.storage[index], key)

        if prev.next is not None:
            # if key found, return value
            return prev.next.value

        # if key not found, return -1
        return -1

    def remove(self, key: int) -> None:
        index = self.get_bucket(key)

        # if bucket is empty, create a dummy node
        if self.storage[index] is None:
            return None

        prev = self.find(self.storage[index], key)

        if prev.next is not None:
            # if key found, remove the node
            prev.next = prev.next.next

        return None


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)
