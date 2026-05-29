class MyQueue:
    def __init__(self):
        self.inSt = []
        self.outSt = []

    def push(self, x: int) -> None:
        self.inSt.append(x)

    def pop(self) -> int:
        if self.empty():
            return -1
        self.peek()
        return self.outSt.pop()

    def peek(self) -> int:
        if not self.outSt:
            while self.inSt:
                self.outSt.append(self.inSt.pop())
        return self.outSt[-1]

    def empty(self) -> bool:
        return not self.inSt and not self.outSt
