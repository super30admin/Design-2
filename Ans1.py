#  Time Complexity : push: O(1), pop: O(N), peek: O(N), isEmpty: O(1)
#  Space Complexity : O(N)
#  Did this code successfully run on Leetcode : Yes 
#  Any problem you faced while coding this : No


#  Your code here along with comments explaining your approach in three sentences only: New elements are pushed into inqueue, while pop/peek operations are handled by outqueue, which gets refilled (in reverse order) only when empty. This ensures FIFO (First-In-First-Out) behavior, as elements moved from inqueue to outqueue are popped in the correct order. The empty check returns True only when both stacks are empty

class MyQueue:

    def __init__(self):
        self.inqueue = []
        self.outqueue = []

    def push(self, x: int) -> None:
        self.inqueue.append(x)
        
    def pop(self) -> int:
        if len(self.outqueue) == 0:
            while len(self.inqueue) != 0:
                self.outqueue.append(self.inqueue.pop())
        return self.outqueue.pop()

    def peek(self) -> int:
        if len(self.outqueue) == 0:
            while len(self.inqueue) != 0:
                self.outqueue.append(self.inqueue.pop())
        return self.outqueue[-1]
        
    def empty(self) -> bool:
        return not self.inqueue and not self.outqueue