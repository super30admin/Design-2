class MyQueue:
    def __init__(self):
        self.queue = []

    def push(self, x: int) -> None:
        self.queue.append(x)

    def pop(self) -> int:
        a = self.queue[0]
        del self.queue[0]
        return a

    def peek(self) -> int:
        return self.queue[0]

    def empty(self) -> bool:
        return len(self.queue)==0
