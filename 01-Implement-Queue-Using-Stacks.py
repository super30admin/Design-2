# Problem 1: Design Queue using Stacks (https://leetcode.com/problems/implement-queue-using-stacks/)

# Time Complexity : O(1) for push operation, O(n) for pop and peek operations in the worst case
# Space Complexity : O(n) where n is the number of elements in the queue
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# We will use two stacks to implement the queue. The inStack will be used for enqueue operations (push)
# and the outStack will be used for dequeue operations (pop and peek). When outStack is empty, we will transfer
# all elements from inStack to outStack to maintain the correct order.

class MyQueue:

    def __init__(self):
        self.inStack = []
        self.outStack = []

    def push(self, x: int) -> None:
        self.inStack.append(x)
        
    def pop(self) -> int:
        self.peek()
        return self.outStack.pop()

    def peek(self) -> int:
        if len(self.outStack) == 0:
            while len(self.inStack) >0:
                self.outStack.append(self.inStack.pop())
        return self.outStack[-1]
        
    def empty(self) -> bool:
        return len(self.inStack) == 0 and len(self.outStack) == 0 
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()