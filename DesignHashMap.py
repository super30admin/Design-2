#Time Complexity : O(1) for all the operation that is put, get, remove
#Space Complexity : O(N) where N is the number of keys added to the hash map
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No

#Approach: Here we again use data structure in data structure approach where in we create a linked list at each index of an arrary storage.
#When a new key-value pair is to be added to a index (we get this index after applying the hash function) in the storage array, a new linkedlist
#is initiate with a dummy node at the start with key-value as (-1,-1). We have defined a function called find() which returns the prev pointer 
#of the key (we use this for reference in all the functions).

class MyHashMap:
    class Node:
        def __init__(self, key, value):
            self.key = key
            self.value = value
            self.next = None

    def __init__(self):
        self.buckets = 10000
        self.storage = [None] * self.buckets

    def hash(self, key):
        return key % self.buckets
        
    def find(self, head, key):
        prev = None
        curr = head
        while curr and curr.key != key:
            prev = curr
            curr = curr.next
        return prev

    def put(self, key: int, value: int) -> None:
        bucket = self.hash(key)
        if not self.storage[bucket]:
            self.storage[bucket] = self.Node(-1,-1)
        prev = self.find(self.storage[bucket], key)
        if not prev.next:
            prev.next = self.Node (key, value)
        else:
            prev.next.value = value        

    def get(self, key: int) -> int:
        bucket = self.hash(key)
        if not self.storage[bucket]: return -1
        prev = self.find(self.storage[bucket], key)
        if not prev.next: return -1
        return prev.next.value
        

    def remove(self, key: int) -> None:
        bucket = self.hash(key)
        if not self.storage[bucket]: return
        prev = self.find(self.storage[bucket], key)
        if not prev.next: return
        prev.next = prev.next.next
        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)