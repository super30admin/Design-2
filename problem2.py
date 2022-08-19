
"""
Time Complexity: Average Space Complexity O(1) for all the operations
Space Complexity: O(n) where n is the total number of elements in a stack

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Your code here along with comments explaining your approach:
#Declare Two stacks inStack and outStack

push:
Always push element to the inStack

Pop:
if outStack is empty:
    pop all the elements from the inStack to the outStack
    pop the peek element of the outStack
else:
    pop the peek element of the outStack

peek:
To follow the FIFO
if outStack is empty:
    pop all the elements from the inStack to the outStack
    return the peek element of the outStack
else:
    return the peek element of the outStack

empty:
if both the stacks are empty:
    return True
else:
    return False
"""
class MyQueue:

    def __init__(self):
        #Declare two stacks
        self.inStack = []
        self.outStack = []
    
    def push(self, x: int) -> None:
        self.inStack.append(x)
        

    def pop(self) -> int:
        self.peek()
        return self.outStack.pop()
        
    def peek(self) -> int:
        if len(self.outStack) > 0:
            return self.outStack[-1]
        while len(self.inStack) > 0:
            self.outStack.append(self.inStack.pop())
        return self.outStack[-1]
        
    def empty(self) -> bool:
        return False if len(self.outStack) > 0 or len(self.inStack) > 0 else True
        
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()