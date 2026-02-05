#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Wed Feb  4 20:52:59 2026

@author: rishigoswamy


    Approach:
    ----------
    We use a fixed-size array as buckets and apply a hash function (key % size)
    to map each key to a bucket index.
    Each bucket is implemented as a singly linked list (separate chaining) to
    handle collisions by storing multiple key-value pairs at the same index.
    For put, get, and remove operations, we traverse the linked list at the
    computed bucket to update, retrieve, or delete the target key.
    
    Time Complexity:
    ----------------
    put    : O(1) average, O(n) worst case
    get    : O(1) average, O(n) worst case
    remove : O(1) average, O(n) worst case
    
    Space Complexity:
    -----------------
    O(n), where n is the number of key-value pairs stored in the hash map.
    
"""


class Node:
    def __init__(self, key, value):
        self.key = key
        self.value = value
        self.next = None

class MyHashMap:

    def __init__(self):
        self.size = 10000
        self.array = [Node(None, None) for _ in range(self.size)]        

    def hashFunction(self, key):
        return key % self.size

    
    def put(self, key: int, value: int) -> None:
        idx = self.hashFunction(key)
        prev = self.array[idx]
        nxt = prev
        presentInLinkedList = False
        
        while nxt:
            prev = nxt
            nxt = nxt.next
            if prev.key == key:
                prev.value = value
                presentInLinkedList = True
                break

        if not presentInLinkedList:
            prev.next = Node(key, value)

    def get(self, key: int) -> int:
        idx = self.hashFunction(key)
        curr = self.array[idx]
        while curr:
            if curr.key == key:
                return curr.value
            curr = curr.next
        return -1
        

    def remove(self, key: int) -> None:
        idx = self.hashFunction(key)

        prev = self.array[idx]
        nxt = prev.next

        while nxt:
            if nxt.key == key:
                prev.next = nxt.next
                break
            prev = nxt
            nxt = nxt.next
        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)