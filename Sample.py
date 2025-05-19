# Time Complexity :
# Space Complexity :
# Did this code successfully run on Leetcode :
# Any problem you faced while coding this :


# Problem 1 : Implementing Hashmap using Linear Chaining 
# Time Complexity: Amortized O(1)
# Space Complexity: O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class MyHashMap:
    class Node:
        def __init__(self, key, val, next=None):
            self.key=key
            self.val=val
            self.next=next
    def __init__(self):
        self.buckets=10000
        self.bucketItems=100
        self.storage=[None]*self.buckets

    def hash(self,key) -> int:
        return key%10000

    def helper(self,head: Node, key: int) -> Node:
        prev=head
        curr=head.next

        while((curr is not None) and curr.key!=key):
            prev=curr
            curr=curr.next
        return prev

    def put(self, key: int, value: int) -> None:
        idx1=self.hash(key)
        if self.storage[idx1] is None:
            self.storage[idx1]=self.Node(-1,-1)
        prev=self.helper(self.storage[idx1], key)
        if prev.next is None:
            prev.next= self.Node(key, value)
        else:
            prev.next.val=value


    def get(self, key: int) -> int:
        idx1=self.hash(key)
        if self.storage[idx1] is None:
            return -1
        prev=self.helper(self.storage[idx1], key)
        if prev.next is None:
            return -1
        
        return prev.next.val

    def remove(self, key: int) -> None:
        idx1=self.hash(key)
        if self.storage[idx1] is None:
            return 
        prev=self.helper(self.storage[idx1], key)
        if prev.next is None:
            return
        if prev.next.key == key:
            temp=prev.next
            prev.next=prev.next.next
            temp.next=None
            return

# Problem 2 : Implementing Queue using Stacks 
# Time Complexity: Push -> O(1) ; Pop and Peek -> Amortized O(1) ; Empty -> O(1)
# Space Complexity: O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class MyQueue:

    def __init__(self):
        self.inStack=[]
        self.outStack=[]
        self.size=0

    def push(self, x: int) -> None:
        self.inStack.append(x)
        self.size+=1

    def pop(self) -> int:
        val=self.peek()
        self.outStack.pop()
        self.size-=1
        return val

    def peek(self) -> int:
        if not self.outStack:
            while self.inStack:
                self.outStack.append(self.inStack.pop())
        
        return self.outStack[-1]


    def empty(self) -> bool:
        return self.size == 0


