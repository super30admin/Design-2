# // Time Complexity : O(1), since we designed the primary list to be of size 10,000 and linked list to be 100 at max at each 10,000 indices. 
# // Space Complexity : O(n), n is number of elemnts in the hashmap.
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach
# Implemented Linear Chaining with Linked Lists to avoid collisions. 
# Wrote findPrevNode fucntion to find previous node since searching is a common feature in all others fucntionalitites.
# In put fucntion, firstly, if bucket is null, create the head node with new ele. If not, search if key already exists, if it does overwrite the current value. If it doesn't exists, traverse till end and append a new node with key,value pair.
# In get fucntion, if bucket is null, return -1 else check if key exists in the Linked List, if it does, return value else -1
# In remvoe fucntion, if bucket is not null, find prev node of node to be removed and remove the node by chnaging the pointers.

class Node:
    def __init__(self,key=-1,val=-1):
        self.key=key
        self.val=val
        self.next=None
  
class MyHashMap: 
   
    def __init__(self):
        self.buckets=[None for _ in range(10000)]

    def hash(self,key):
        return key%10000

    def findPrevNode(self,key,bucket):
        curr=self.buckets[bucket]
        if curr!=None:
            while curr!=None and curr.key!=key:
                prev=curr
                curr=curr.next
        else:
            prev=Node()
            self.buckets[bucket]=prev
        return prev

    def put(self, key: int, value: int) -> None:
        bucket=self.hash(key)
        prev=self.findPrevNode(key,bucket)
        if prev.next!=None:
            prev.next.val=value
            return
        else:
            prev.next=Node(key,value)

    def get(self, key: int) -> int:
        bucket=self.hash(key)
        if self.buckets[bucket]==None:
            return -1
        prev=self.findPrevNode(key,bucket)
        if prev.next==None:
            return -1
        else:
            return prev.next.val

    def remove(self, key: int) -> None:
        bucket=self.hash(key)
        if self.buckets[bucket]!=None:
            prev=self.findPrevNode(key,bucket)
            if prev.next!=None:
                prev.next=prev.next.next

# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)