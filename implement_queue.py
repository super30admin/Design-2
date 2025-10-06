from collections import deque


class MyQueue:

    def __init__(self):
        self.instack = deque()
        self.outstack = deque()

    def push(self, x: int) -> None:
        self.instack.append(x)

    def pop(self) -> int:
        if not self.outstack:
            while self.instack:
                self.outstack.append(self.instack.pop())
        return self.outstack.pop()

    def peek(self) -> int:
        if not self.outstack:
            while self.instack:
                self.outstack.append(self.instack.pop())
        return self.outstack[-1]

    def empty(self) -> bool:
        if not self.outstack:
            if not self.instack:
                return True
        return False

# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()