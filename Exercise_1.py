


class MyQueue:

    def __init__(self):
        self.pushstack = []
        self.popstack = []

    def push(self, x: int) -> None:
        self.pushstack.append(x)

    def pop(self) -> int:
        if not self.popstack:
            while self.pushstack:
                self.popstack.append(self.pushstack.pop())
        return self.popstack.pop()

    def peek(self) -> int:
        if self.popstack:
            return self.popstack[len(self.popstack)-1]
        if self.pushstack:
            return self.pushstack[0]
        

    def empty(self) -> bool:
        return not (self.popstack or self.pushstack)
        