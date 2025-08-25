#Time Complexity: Amortized - O(1)

#Space Complexity:O(n)
"""
Uses linear chaining (linked lists) to handle collisions in buckets.

Uses a dummy head node and a custom getPrev method which acts as a helper to simplify all the operations.

"""
class HashMap:

    class Node:
        def __init__(self,key,val):
            self.key = key
            self.val = val
            self.next = None

    def __init__(self):
        self.bucket = 1000
        self.storage = [None] * self.bucket

    def getHash(self,key):
        return key % self.bucket
    
    def getPrev(self,head,key):
        prev = None
        curr = head
        while curr and curr.key!=key:
            prev = curr
            curr = curr.next
        return prev
    
    def put(self,key: int, val: int) -> None:

        index = self.getHash(key)
        if self.storage[index ]is None:
            self.storage[index] = self.Node(-1,-1)
            self.storage[index].next = self.Node(key,val)
            return
        
        prev = self.getPrev(self.storage[index],key)
        if prev.next is None:
            prev.next = self.Node(key,val)
        else:
            prev.next.val = val

    def get(self, key: int) -> int:

        index = self.getHash(key)
        if self.storage[index] is None:
            return -1
        prev = self.getPrev(self.storage[index], key)
        if prev.next is None:
            return -1
        return prev.next.val
    
    def remove(self, key: int) -> None:
        index = self.getHash(key)
        if self.storage[index] is None:
            return
        prev = self.getPrev(self.storage[index], key)
        if prev.next is None:
            return
        prev.next = prev.next.next



