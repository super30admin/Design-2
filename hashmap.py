# Problem: Design HashMap
# Time Complexity: O(1) average for put, get, remove (O(n) worst case due to chaining)
# Space Complexity: O(n) where n is number of keys inserted
# Did this code successfully run on Leetcode: YES
# Any problem you faced while coding this: Understanding linked list chaining approach

class MyHashMap:
    class Node:
        def __init__(self, key=None, value=None, next=None):
            self.key = key
            self.value = value
            self.next = next

    def __init__(self):
        self.arr = [None] * 10000

    def hash_func(self, key):
        return key % 10000

    def find(self, head, key):
        prev = None
        curr = head
        while curr is not None and curr.key != key:
            prev = curr
            curr = curr.next
        return prev

    def put(self, key, value):
        hash_val = self.hash_func(key)
        if self.arr[hash_val] is None:
            self.arr[hash_val] = self.Node(-1, -1, None)
        prev = self.find(self.arr[hash_val], key)
        if prev.next is None:
            prev.next = self.Node(key, value, None)
        else:
            prev.next.value = value

    def get(self, key):
        hash_val = self.hash_func(key)
        if self.arr[hash_val] is None:
            return -1
        prev = self.find(self.arr[hash_val], key)
        if prev.next is None:
            return -1
        return prev.next.value

    def remove(self, key):
        hash_val = self.hash_func(key)
        if self.arr[hash_val] is None:
            return
        prev = self.find(self.arr[hash_val], key)
        if prev.next is None:
            return
        prev.next = prev.next.next


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)