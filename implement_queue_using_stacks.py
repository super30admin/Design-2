"""
# Time Complexity :

Push - O(1)

Pop - O(1) amortized, since each element gets moved between stacks just once

Peek - O(1) amortized, since each element gets moved between stacks just once


# Space Complexity :

O(N), where N is the number of elements pushed to the queue

# Did this code successfully run on Leetcode :

Yes

# Any problem you faced while coding this :
- have faced some difficulty in the past visualizing the logic between both stacks, but I am able to understand it now

"""

#Explanation (within 3 lines) - made use of two stacks and conditional movement of elements between them to simulate O(1) push, pop and peek for the queue in amortized time

from collections import deque

class MyQueue:

    def __init__(self):
        self.st1 = deque()
        self.st2 = deque()
        

    def push(self, x: int) -> None:
        self.st1.append(x)
        
        

    def pop(self) -> int:
        if self.st2:
            val = self.st2[-1]
            self.st2.pop()
            return val
        elif self.st1:
            while self.st1:
                val = self.st1[-1]
                self.st1.pop()
                self.st2.append(val)
            val = self.st2[-1]
            self.st2.pop()
            return val
        

    def peek(self) -> int:
        if self.st2:
            val = self.st2[-1]
            return val
        elif self.st1:
            while self.st1:
                val = self.st1[-1]
                self.st1.pop()
                self.st2.append(val)
            return self.st2[-1]
        

    def empty(self) -> bool:
        return len(self.st1) == 0 and len(self.st2) == 0
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()
