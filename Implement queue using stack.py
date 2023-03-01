class MyQueue:

    def __init__(self):
        self.stack = []
        self.popstack = []

    def push(self, x: int) -> None: O(1)
        self.stack.append(x)

    def pop(self) -> int: #Amortised O(1)
        if not self.popstack:
            while self.stack:
                self.popstack.append(self.stack.pop())
        return self.popstack.pop()
    def peek(self) -> int: #O(1)
        if not self.popstack:
            while self.stack:
                self.popstack.append(self.stack.pop())
        return self.popstack[-1]

    def empty(self) -> bool: #O(1)
        if not self.popstack:
            if not self.stack:
                return True
        return False


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()