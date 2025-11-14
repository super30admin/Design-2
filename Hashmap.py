# Time Complexity : O(1)-avg , O(n)-worst case
# Space Complexity :O(n)
# Did this code successfully run on Leetcode :yes
# Any problem you faced while coding this :No


# Your code here along with comments explaining your approach
# Initialized a node structure and to avoid collisions i initialized a linked list as a sub array to each index and Uses a dummy head node and a custom getPrev method to simplify operations.
# for put i checked if that element is present or not and replaced the value
#for remove and get, i checked whether that element is there or not if not there i return -1 or none

class MyHashMap:
    class Node:
        def __init__(self,key,value):
            self.key = key
            self.value = value
            self.next = None

    def __init__(self):
        self.buckets = 1000
        self.storage = [None]*self.buckets
    def getHash(self,key):
        return key % 1000
    def getPrev(self,head,key):
        prev = None
        curr = head
        while(curr!= None and curr.key != key):
            prev = curr
            curr = curr.next
        return prev
        
    def put(self, key: int, value: int) -> None:
        hash_1 = self.getHash(key)
        if(self.storage[hash_1] == None):
            self.storage[hash_1] = self.Node(-1,-1)
            self.storage[hash_1].next = self.Node(key,value)
            return
        prev = self.getPrev(self.storage[hash_1],key)
        if(prev.next == None):
            prev.next = self.Node(key,value)
        else:
            prev.next.value = value

    def get(self, key: int) -> int:
        hash_1 = self.getHash(key)
        if(self.storage[hash_1]==None):
            return -1
        prev = self.getPrev(self.storage[hash_1],key)
        if (prev.next == None):
            return -1
        return prev.next.value
        

    def remove(self, key: int) -> None:
        hash_1 = self.getHash(key)
        if(self.storage[hash_1]==None):
            return
        prev = self.getPrev(self.storage[hash_1],key)
        if (prev.next == None):
            return
        else:
            temp = prev.next
            prev.next = prev.next.next
            temp.next = None
        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)