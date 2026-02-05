
'''

https://leetcode.com/problems/design-hashmap/description/
# Time Complexity :
    put  : O(1)
    get   : O(1) 
    remove  : O(1)
    
# Space Complexity : O(n), where n is the number of elements.
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : NO
# Tip: Use dummy node for managing edge cases for linked list operations
'''


class Node:
        def __init__(self, key=None, val=None):
            self.key = key
            self.val = val
            self.next = None


class MyHashMap:

    def __init__(self):
        self.primaryBucket = 10000
        self.hashmap = [None for i in range(10000)]
        
    def getHash(self, key):
        return key % self.primaryBucket

    def put(self, key: int, value: int) -> None:
        index = self.getHash(key)

        if not self.hashmap[index]:
            self.hashmap[index] = Node()
            self.hashmap[index].next = Node(key, value)
            return
        
        prev = self.getPrev(self.hashmap[index], key)

        if prev.next == None:
            prev.next = Node(key, value)
            return
        
        prev.next.val = value
        return

    def getPrev(self, head, key):
        curr = head
        prev = None
        while curr is not None and curr.key != key:
            prev = curr
            curr = curr.next
        
        return prev


    def get(self, key: int) -> int:
        index = self.getHash(key)

        if not self.hashmap[index]:
            return -1
        
        prev = self.getPrev(self.hashmap[index], key)
        
        if prev.next == None:
            return -1
        else:
            return prev.next.val

    def remove(self, key: int) -> None:
        index = self.getHash(key)

        if not self.hashmap[index]:
            return

        prev = self.getPrev(self.hashmap[index], key)
        if prev.next is not None:
            curr = prev.next
            prev.next = curr.next
            del curr    
        
# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)