# HashMap using Linear Chaining: Collision happens when multiple keys hash to the same bucket.
# Time complexity:
# Average Case: O(1) for all operations (put, get, remove), because the hash function distributes keys uniformly and the linked lists (chains) in each bucket are short.
# Worst Case: O(N) for all operations, where N is the number of keys inserted, if all keys hash to the same bucket (causing a long linked list).
# Space complexity: O(n) - where n is the number of entries in HashMap 

class MyHashMap:

    #Each node stores one (key, value) pair and a reference to the next node.
    class Node:
        def __init__(self, key, val):
            self.key = key
            self.val = val
            self.next = None

    def __init__(self):
        self.buckets = 10000 #Number of buckets in the hash map
        self.storage = [None] * self.buckets  #Initialize storage with None

    def hash(self, key):
        return key % self.buckets #Hash function to get bucket index

    # helper to be used in all 3 (put, get and remove)
    def find_node(self, head, key):
        prev = head
        curr = head.next
        # till null or till we find the key
        while(curr!=None and curr.key!=key):
            prev=curr
            curr=curr.next
        return prev

    def put(self, key: int, value: int) -> None:
        index = self.hash(key) #Get bucket index
        if self.storage[index] == None:
            #Create dummy node if bucket is empty
            self.storage[index] = self.Node(-1, -1)
            
        prev = self.find_node(self.storage[index], key)
        if prev.next == None:
            #new node
            prev.next = self.Node(key, value)
        else:
            #if existing node #update value
            prev.next.val = value

    def get(self, key: int) -> int:
        index = self.hash(key)
        if self.storage[index] == None:
            return -1
        
        prev = self.find_node(self.storage[index], key)
        if prev.next == None:
            return -1
        
        return prev.next.val

    def remove(self, key: int) -> None:
        index = self.hash(key)
        if self.storage[index] == None:
            return

        prev = self.find_node(self.storage[index], key)
        if prev.next == None:
            return

        temp = prev.next
        prev.next = prev.next.next #Remove node from chain
        temp = None #Free memory (optional)


# # HashMap using Array:
# class MyHashMap:
#     def __init__(self):
#         self.data = [None] * 1000001
#     def put(self, key: int, val: int) -> None:
#         self.data[key] = val
#     def get(self, key: int) -> int:
#         val = self.data[key]
#         return val if val != None else -1
#     def remove(self, key: int) -> None:
#         self.data[key] = None
