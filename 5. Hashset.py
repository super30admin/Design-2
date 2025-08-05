class MyHashMap:

    class Node:
        # Node for linked list: stores key, value, and next pointer
        def __init__(self, key, value):
            self.key = key
            self.value = value
            self.next = None

    def __init__(self):
        # Initialize storage with 1000 buckets
        self.buckets = 1000
        self.storage = [None] * self.buckets

    def getHash(self, key):
        # Simple hash function: modulo operation
        return key % self.buckets

    def getPrev(self, head, key):
        # Find previous node of the node with the given key
        prev = None
        curr = head
        while curr and curr.key != key:
            prev = curr
            curr = curr.next
        return prev

    def put(self, key: int, value: int) -> None:
        # Insert or update the value for the given key
        index = self.getHash(key)
        if self.storage[index] is None:
            # Create dummy head and insert new node
            self.storage[index] = self.Node(-1, -1)
            self.storage[index].next = self.Node(key, value)
            return

        prev = self.getPrev(self.storage[index], key)
        if prev.next is None:
            # Key not found, insert new node
            prev.next = self.Node(key, value)
        else:
            # Key found, update value
            prev.next.value = value

    def get(self, key: int) -> int:
        # Retrieve value for the given key
        index = self.getHash(key)
        if self.storage[index] is None:
            return -1
        prev = self.getPrev(self.storage[index], key)
        if prev.next is None:
            # Key not found
            return -1
        return prev.next.value

    def remove(self, key: int) -> None:
        # Remove the node with the given key
        index = self.getHash(key)
        if self.storage[index] is None:
            return
        prev = self.getPrev(self.storage[index], key)
        if prev.next is None:
            # Key not found
            return
        # Remove node by skipping it
        prev.next = prev.next.next

#Time Complexity: O(1) on average, O(n) in worst case
#Space Complexity: O(n) 
