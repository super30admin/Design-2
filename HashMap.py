# Time Complexity : O(1) 
# Space Complexity : less than O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


class Node:
        def __init__(self, key=-1, val=-1, next= None):
            self.key = key
            self.val = val
            self.next = next

class MyHashMap:
   
    def __init__(self):
        self.buckets = 10000
        self.storage = [Node() for i in range(self.buckets)]
       
    def getHash(self, key):
        return key % self.buckets

    def getPrev(self, head:int, key:int):
        prev = None
        curr = head
        while(curr and curr.key != key):
            prev = curr
            curr = curr.next
        return prev

    def put(self, key, value) -> None:
        index = self.getHash(key)
        if( not self.storage[index]):
            self.storage[index] = Node(-1, -1)
            self.storage[index].next = Node(key, value)
        prev = self.getPrev(self.storage[index], key)
        if(not prev.next):
            prev.next = Node(key, value)
        else:
            prev.next.val = value

    def get(self, key: int) -> int:
        index = self.getHash(key)
        if(not self.storage[index]):
            return -1
        prev = self.getPrev(self.storage[index], key)
        if(not prev.next): 
            return -1
        else:
            return prev.next.val

    def remove(self, key: int) -> None:
        index = self.getHash(key)
        if(not self.storage[index]):
            return
        prev = self.getPrev(self.storage[index], key)
        if(not prev.next): 
            return
        else:
            prev.next = prev.next.next
            return