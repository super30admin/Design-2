#Time Complexity :O(1)
#Space Complexity :O(n)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No
#Your code here along with comments explaining your approach: Hash with chaining using linked list 

class Node:
    def __init__(self,key,val,next):
        self.next=next
        self.key=key
        self.val=val

class MyHashMap:

    def __init__(self):
        self.buckets=10000
        self.storage=[Node(-1,-1,None) for i in range(self.buckets)]

    def hash1(self, key):
        return key%self.buckets

    def find(self,head,key):
        index = self.hash1(key)
        prev = None
        curr = head
        while(curr is not None and curr.key!=key):
            prev=curr
            curr=curr.next
        return prev

    def put(self, key: int, value: int) -> None:
        bucket=self.hash1(key)
        if self.storage[bucket] is None:
            self.storage[bucket]=Node(-1,-1,None) 
        else:
            prev=self.find(self.storage[bucket],key)
            if prev.next is None:
                prev.next=Node(key,value,None)
            else:
                prev.next.val=value

    def get(self, key: int) -> int:
        bucket=self.hash1(key)
        if self.storage[bucket] is None:
            return -1
        else:
            prev=self.find(self.storage[bucket],key)
            if prev.next is None:
                return -1
            else:
                return prev.next.val


    def remove(self, key: int) -> None:
        bucket=self.hash1(key)
        if self.storage[bucket] is None:
            return
        else:
            prev=self.find(self.storage[bucket],key)
            if prev.next is None:
                return
            else:
                prev.next=prev.next.next


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)