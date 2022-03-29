class MyQueue:

    def __init__(self):
        self.stack1 = []
        self.stack2 = []

    def push(self, x: int) -> None:
        self.stack1.append(x)

    def pop(self) -> int:
        while self.stack1:
            self.stack2.append(self.stack1.pop())
        ans = self.stack2.pop()

        while self.stack2:
            self.stack1.append(self.stack2.pop())
        return ans

    def peek(self) -> int:
        while self.stack1:
            self.stack2.append(self.stack1.pop())
        ans = self.stack2[-1]

        while self.stack2:
            self.stack1.append(self.stack2.pop())
        return ans

    def empty(self) -> bool:
        if not self.stack1 and not self.stack2:
            return True
