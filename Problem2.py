// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Implemented Hash Map with Linear chaining method. Added linked list when inserting new key,value


class Node:
    def __init__(self, k, val):
        self.key = k
        self.value = val
        self.next = None

class MyHashMap:

    def __init__(self):
        self.bucketSize = 1000
        self.storage = [None]*self.bucketSize

    def hashFunction(self, key):
        return key%self.bucketSize

    def find(self, head: Node, key: int ):
        prev = None
        current = head
        while (current and current.key != key):
            prev = current
            current = current.next
        
        return prev

    def put(self, key: int, value: int) -> None:
        index = self.hashFunction(key)
        if (self.storage[index]==None):
            head = Node(-1, -1)
            self.storage[index] = head
        prev = self.find(self.storage[index], key)
        if prev.next:
            prev.next.value = value
        else:
            prev.next = Node(key, value)
            

    def get(self, key: int) -> int:
        index = self.hashFunction(key)
        if (self.storage[index]==None):
            return -1
        else:
            prev = self.find(self.storage[index], key)
            if prev.next:
                return prev.next.value
            else:
                return -1

    def remove(self, key: int) -> None:
        index = self.hashFunction(key)
        if (self.storage[index]==None):
            return
        else:
            prev = self.find(self.storage[index], key)
            if prev.next:
                prev.next = prev.next.next

# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)