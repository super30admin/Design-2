"""
Approach: As designing a HashMap, we will check what are our constraints, as we have 0 <= key, value <= 1000000, and we will have a static array and each index
we will be having a linked list, and as we have 1000000 data we will divide that number in such a way that we can traverse through the linkedlist very easily
and in this case we will have 10000 size array so that we will have 100 nodes of linkedlist. and we will store each data by hashing it. We will also create a search
function so that we can get the previous node of the element we will be removing or getting the value and even adding it. 

Time Complexity: O(1)
Space Complexity: O(1)
"""

class MyHashMap:
    class Node:
        def __init__(self, key, val):
            self.key = key
            self.val = val
            self.next = None

    def __init__(self):
        self.storage = [None] * 10000
    
    def hash(self, key):
        return key % 10000

    def search(self, head, key):
        prev = None
        curr = head
        while curr is not None and curr.key != key:
            prev = curr
            curr = curr.next
            # break
        return prev

    def put(self, key: int, value: int) -> None:
        idx = self.hash(key)
        if self.storage[idx] == None:
            self.storage[idx] = self.Node(-1,-1)
        prev = self.search(self.storage[idx], key)
        if prev.next == None:
            prev.next = self.Node(key, value)
        else:
            prev.next.val = value

    def get(self, key: int) -> int:
        idx = self.hash(key)
        if self.storage[idx] == None:
            return -1
        prev = self.search(self.storage[idx], key)
        if prev.next == None:
            return -1
        return prev.next.val

    def remove(self, key: int) -> None:
        idx = self.hash(key)
        if self.storage[idx] == None:
            return 
        prev = self.search(self.storage[idx], key)
        if prev.next == None:
            return
        temp = prev.next
        prev.next = prev.next.next
        temp.next = None


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)