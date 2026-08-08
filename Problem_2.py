#Time Complexity : Amortized O(1)
#Space Complexity : O(n)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No
class MyHashMap:
    class Node():
        def __init__(self, key, value):
            self.key = key
            self.value = value
            self.next = None

    def __init__(self):
        self.num_buckets = 1000
        self.storage = [None] * self.num_buckets

    def put(self, key: int, value: int):
        hash_val = self.hash_function(key)
        if not self.storage[hash_val]:
            self.storage[hash_val] = self.Node(-1,-1)
            self.storage[hash_val].next = self.Node(key, value)
        else:
            prev_node = self.prev_node(self.storage[hash_val], key)
            if prev_node.next:
                prev_node.next.value = value
            else:
                prev_node.next = self.Node(key, value)

    def get(self, key: int):
        hash_val = self.hash_function(key)
        if self.storage[hash_val] is not None:
            prev_node = self.prev_node(self.storage[hash_val], key)
            if prev_node.next:
                    return prev_node.next.value
        return -1
        
    def remove(self, key: int):
        hash_val = self.hash_function(key)
        if self.storage[hash_val] is not None:
            prev_node = self.prev_node(self.storage[hash_val], key)
            if prev_node.next is not None:
                prev_node.next = prev_node.next.next

    def prev_node(self, head, key: int) -> Node:
        temp = prev = head
        while temp is not None and temp.key != key:
            prev = temp
            temp = temp.next
        return prev

    def hash_function(self, key):
        return key % self.num_buckets

