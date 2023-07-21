# Time Complexity : O(1)
# Space Complexity :O(1) 
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : NO

# Your code here along with comments explaining your approach

class MyQueue:

    def __init__(self):
        self.inSt = [] #creating in stack 
        self.outSt = [] #creating out stack
    
    def push(self, x: int) -> None:
        self.inSt.append(x) #push operation over instack 

    def pop(self) -> int:
        self.peek() #peek the top of the out stack and pop it
        return self.outSt.pop()

    def peek(self) -> int:
        if not self.outSt:  
            while self.inSt:
                self.outSt.append(self.inSt.pop())
        return self.outSt[-1]

    def empty(self) -> bool:
        return not self.inSt and not self.outSt
        