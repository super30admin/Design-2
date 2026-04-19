
"""
@author: chinmayprajapati

Time: O(1) amortized
Space: O(n)
"""

class MyQueue:

    def __init__(self):
        self.instack = list()
        self.outstack = list()        

    def push(self, x: int) -> None:
        self.instack.append(x)

    def pop(self) -> int:
        self.peek()
        return self.outstack.pop()

    def peek(self) -> int:
        if len(self.outstack) == 0:
            while len(self.instack) != 0:
                self.outstack.append(self.instack.pop())
        return self.outstack[-1]

    def empty(self) -> bool:
        return len(self.instack) == 0 and len(self.outstack) == 0
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()