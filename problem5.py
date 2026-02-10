## Problem 2:
#Design Hashmap (https://leetcode.com/problems/design-hashmap/)

class Node:

    def __init__(self,key,val):
        self.key = key 
        self.val = val 
        self.next = None

class MyHashMap:

    def __init__(self):
        self.primary_length = 1000
        self.storage = [None]*self.primary_length

    def hash_function(self,key):
        return key%self.primary_length
    

    def getPrev(self,head,key):
        prev = None 
        current = head 
        while current and current.key != key:
            prev = current
            current = current.next
        return prev

    def put(self, key: int, value: int) -> None:
        index_val = self.hash_function(key)
        if self.storage[index_val] is None:
            self.storage[index_val] = Node(-1,-1)
            self.storage[index_val].next = Node(key,value)
        else:
            prev_node = self.getPrev(self.storage[index_val],key)
            if prev_node.next is None:
                prev_node.next = Node(key,value) 
            else:
                prev_node.next.val = value
        

    def get(self, key: int) -> int:
        index_val = self.hash_function(key)
        head = self.storage[index_val]
        if head is None:
            return -1
        prev_node = self.getPrev(self.storage[index_val],key)
        print(prev_node.val)
        if prev_node.next is None:
            return -1
        return prev_node.next.val

    def remove(self, key: int) -> None:
        index_val = self.hash_function(key)
        head = self.storage[index_val]
        if head is None:
            return
        prev_node = self.getPrev(self.storage[index_val],key)
        if prev_node.next is None:
            return
        prev_node.next = prev_node.next.next


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)