#Approach - using a secondary stack(reversed stack) created using the primary stack to lazily populate reversed stack only when it is empty
#pop from secondary stack
#T.c. => auxiliary O(1) worst case O(n)
#s.c. => o(n)
from collections import deque

class MyQueue:

    def __init__(self):
        self.stack = deque()
        self.reversedStack = deque()

    def push(self, x: int) -> None:
        self.stack.append(x)
        

    def pop(self) -> int:
        if self.reversedStack:
            return self.reversedStack.pop()
        else:
            while self.stack:
                self.reversedStack.append(self.stack.pop())
        
            return self.reversedStack.pop()
        

    def peek(self) -> int:
        if self.reversedStack:
            return self.reversedStack[-1]
        else:
            while self.stack:
                self.reversedStack.append(self.stack.pop())
            return self.reversedStack[-1]
        
        

    def empty(self) -> bool:
        if not self.stack and not self.reversedStack:
            return True
        return False
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()