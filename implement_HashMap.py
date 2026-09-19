// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
#I have designed HashMap using LinkedList that is linear chaining.

class MyHashMap:

    class Node:

        def __init__(self, key, value):
            self.key = key
            self.value = value
            self.next = None

    def __init__(self):
        self.data = 1000
        self.storage = [None] * self.data

    def hash1(self, key):
        index = key % self.data
        return index

    def findPrev(self, head, key):
        currentNode = head
        prev = None
        while currentNode != None and currentNode.key != key:
            prev = currentNode
            currentNode = currentNode.next
        return prev

    def put(self, key:int, value:int) -> None:
        data_index = self.hash1(key)
        if self.storage[data_index] is None:
            self.storage[data_index] = self.Node(-1,-1)
        prev = self.findPrev(self.storage[data_index], key)
        if prev.next is None:
            prev.next = self.Node(key, value)
        else:
            prev.next.value = value


    def remove(self, key:int) -> None:
        data_index = self.hash1(key)
        if self.storage[data_index] is None:
            return
        prev = self.findPrev(self.storage[data_index], key)
        if prev.next == None:
            return
        temp = prev.next
        prev.next = prev.next.next
        temp.next = None

    def get(self, key:int) -> int:
        data_index = self.hash1(key)
        if self.storage[data_index] is None:
            return -1
        prev = self.findPrev(self.storage[data_index], key)
        if prev.next == None:
            return -1
        return prev.next.value
            

            