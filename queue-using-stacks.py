# O(n) time
# O(n) space

class MyQueue:

    def __init__(self):
        self.inStack = [] # stores all newly pushed elements
        self.outStack=[] # used for popping and peeking elements in fifo order

    def push(self, x: int) -> None:
        self.inStack.append(x)

    def pop(self) -> int:
        if not self.outStack:
            while self.inStack:
                self.outStack.append(self.inStack.pop())
        
        return self.outStack.pop()

    def peek(self) -> int:
        if not self.outStack:
            while self.inStack:
                self.outStack.append(self.inStack.pop())
        
        return self.outStack[-1]

    def empty(self) -> bool:
        if len(self.inStack)==0 and len(self.outStack)==0:
            return True
        else:
            return False


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()