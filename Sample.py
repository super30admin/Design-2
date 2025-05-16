# Time Complexity : serach amortized O(1), 
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this: NO
# Your code here along with comments explaining your approach: IMPLENETED THIS APPROACH IN PYTHON WITH CHAINING USING SINGLE LINKED LIST IN CASE OF COLLISION

class Node:
    def __init__(self,data, val):
        self.data = data
        self.next = None
        self.val = val
                
class MyHashMap:

    def __init__(self):
        self.size = 1000
        self.buckets = [Node(0,0) for i in range(1000)]
    def hashcode(self,key):
        return key % self.size
        
    def put(self, key: int, value: int) -> None:
        idx = self.hashcode(key)
        prev = self.buckets[idx]
        myhead = prev.next
        while myhead != None:
            if myhead.data == key:
                myhead.val = value
                return
            prev = myhead 
            myhead = myhead.next
        prev.next = Node(key,value)
            

    def get(self, key: int) -> int:

        idx = self.hashcode(key)
        myhead = self.buckets[idx].next
        while myhead:
            if myhead.data == key:
                return myhead.val
            myhead = myhead.next 
        return -1 

    def remove(self, key: int) -> None:
        idx = self.hashcode(key)
        prev = self.buckets[idx]
        myhead = prev.next 
        while myhead:
            if myhead.data == key:
                prev.next = myhead.next 
                return 
            prev = myhead 
            myhead = myhead.next 
        

    
# Time Complexity : pop O(1) amortized, push o(1), peek O(1)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this :NO
# Your code here along with comments explaining your approach: used two stack approach where, reverse the first stack and added it to list 2 in case of pop and peek operations 
class MyQueue:

    def __init__(self):
        self.mystack1 = []
        self.mystack2 = []
        
    def push(self, x: int) -> None:
        self.mystack1.append(x)
        
    def pop(self) -> int:
        if len(self.mystack2) == 0 and len(self.mystack1) != 0:
            while len(self.mystack1) != 0:
                elem = self.mystack1.pop(-1)
                self.mystack2.append(elem)
        return self.mystack2.pop(-1)
        

    def peek(self) -> int:
        if len(self.mystack2) == 0 and len(self.mystack1) !=0:        
            while len(self.mystack1) !=0:
                elem = self.mystack1.pop(-1)
                self.mystack2.append(elem)
        return self.mystack2[-1]
        
    def empty(self) -> bool:
        return len(self.mystack1)== 0 and len(self.mystack2) == 0