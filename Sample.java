// Time Complexity : O(n)
// Space Complexity :o(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//Created 2 stacks , one to push in the elements other to push out the elements
// FIFO
class MyQueue:

    def __init__(self):
        self.stack=[]
        self.stack_1=[]
    def push(self, x: int) -> None:
        self.stack.append(x)

    def pop(self) -> int:
        self.peek()
        return self.stack_1.pop()
    def peek(self) -> int:
        if not self.stack_1:
            while self.stack:
                self.stack_1.append(self.stack.pop())
        return self.stack_1[-1]
    def empty(self) -> bool:
        return  not self.stack and  not self.stack_1
// Time Complexity : O(n)
// Space Complexity :o(1)
// Did this code successfully run on Leetcode : Runtime error
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//Seperate chaining method, where linked list is creatd to the for each key and value
class MyHashMap:
    class Node:
        def __init__(self, key: int, value: int):

           self.key = key
           self.value = value
           self.next = None
    def getBucket(self, key: int):
        return key % self.buckets
    def __init__(self):
       self.buckets = 1000
       self.size = [None] * self.buckets
    def find(self, key:int, head:Node) -> Node:
        previous = head
        current =head.next
        while current != None and current.key != key:
            previous = current
            current.next = current 
        return previous

    def put(self, key: int, value: int) -> None:
        Key_value = self.getBucket(key)
        if self.size[Key_value] == None:
            self.size[Key_value] = self.Node(-1, -1) # created dummy node for being helpful in removing the first element
        previous = self.find(key, self.size[Key_value])
        if previous.next == None: ## to add a new key value pair
            previous.next = self.Node(key, value)
        else:
            previous.next.value = value ## if there is an update for key value

    def get(self, key: int) -> int:
      Key_value = self.getBucket(key)
      if self.size[Key_value] is None:
          return -1
      previous = self.find(key, self.size[Key_value])
      if previous.next == None:
          return -1 ## It didnot find anything
      return previous.next.value
       

    def remove(self, key: int) -> None:
        Key_value = self.getBucket(key)
        if self.size[Key_value] == None:
            return
        previous = self.find(key, self.size[Key_value])
        if previous.next == None:
            return 
        previous.next = previous.next.next
