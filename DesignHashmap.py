''' Time Complexity :  Worst case for collision : O(n)
    Space Complexity : O(n) 
    Did this code successfully run on Leetcode : Yes
    Any problem you faced while coding this :  No

   Your code here along with comments explaining your approach

   Approach : Primary staorage as Array of type Node and secondary storage as linkedlist
'''
class ListNode:
    def __init__(self,key=None,value=None,next=None):
        self.key=key
        self.value=value
        self.next=next

class MyHashMap:

    def __init__(self):
        self.bucket=1000
        self.storage = [ListNode() for _ in range(self.bucket)]

    def put(self, key: int, value: int) -> None:
        print("put :",key,value)
        index = key % self.bucket
        if self.storage[index]:
            curr = self.storage[index]
            while curr.next:
                if curr.next.key == key:
                    curr.next.value = value
                    return
                curr = curr.next
            curr.next = ListNode(key, value)
            
    def get(self, key: int) -> int:
        print("get:",key)
        index = key % self.bucket
        if self.storage[index]:
            curr = self.storage[index]
            while curr.next:
                if curr.next.key == key:
                    return curr.next.value
                curr = curr.next
            return -1

    def remove(self, key: int) -> None:
        print("remove :",key)
        index = key % self.bucket
        if self.storage[index]:
            curr = self.storage[index]
            while curr.next:
                if curr.next.key == key:
                    curr.next = curr.next.next
                    return
                curr = curr.next
            
        
# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)