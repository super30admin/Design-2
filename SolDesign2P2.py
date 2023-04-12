"""
LC 706: Design HashMaps
-Time Complexity : O(K) where K = number of items in one bucket 
(the items which collided are in 1 bucket)
-Space Complexity : O(M * K) where K = number of items in one bucket 
and M = number of buckets
-Did this code successfully run on Leetcode : Yes

-Any problem you faced while coding this : 
Yes. Trouble intializing the list with None and then updating it to store 
the head of the Linked Lists. Python showed an error- "Argument of type "Node" cannot be assigned to parameter "__o" of type "Iterable[None]" in function "__setitem__"
  "Node" is incompatible with protocol "Iterable[None]"
  But the error did not hinder when i ran the code. It was just appearing while
  I was typing the code. 

-Your code here along with comments explaining your approach
I have used Linked List to store the items that collide for a bucket.
All the functions of the hash map are using a common functionality - search for
the node in a bucket and return the node prev to it.
So we write a function for it. 
Also, for the key, find the corresponding bucket using hash function "% 1000"
1. Put function = if the bucket is null, then create the head node of the Linked 
list with the new elem and replace the bucket with the node obejct.
If not, traverse the LL to find the last node and to append the new node

2. GET = if the bucket is null, then return -1. Otherwise, check if the key is 
present in the Linked List of the bucket. If yes, return the value of the node, else
return -1.

3. REMOVE - If bucket is not null and the node traversal is done by the common find 
function, and it finds the node, remove it by bypassing the node and adjusting ptrs.
"""

class MyHashMap:
    class Node:
        def __init__(self, key = -1, val = -1, next = None):
            self.data = [key,val]
            self.next = next
            
    def __init__(self):
        self.buckets = [None] * pow(10,4)

    def findBucket(self, key):
        return key % pow(10,4)
    
    def findPrevNode(self, key, bucket):
        curr = self.buckets[bucket]
        if curr != None:
            while curr != None and curr.data[0] != key:
                prev = curr
                curr = curr.next
        else:
            prev = self.Node()
            self.buckets[bucket] = prev
        return prev
        
    def put(self, key: int, value: int) -> None:
        bucket = self.findBucket(key)
        prev = self.findPrevNode(key, bucket)
        #updating the already existing key
        if prev.next != None:
            prev.next.data[1] = value
            return
        #add new key
        prev.next = self.Node(key, value)

    def get(self, key: int) -> int:
        bucket = self.findBucket(key)
        if self.buckets[bucket] == None:
            return -1
        prev = self.findPrevNode(key, bucket)
        if prev.next == None:
            return -1
        else:
            return prev.next.data[1]

    def remove(self, key: int) -> None:
        bucket = self.findBucket(key)
        if self.buckets[bucket] != None:
            prev = self.findPrevNode(key, bucket)
            if prev.next != None:
                prev.next = prev.next.next
