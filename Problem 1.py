class MyQueue:

    def __init__(self):
        self.s1 = deque()
        self.s2 = deque()

    def push(self, x: int) -> None:
        self.s1.append(x)

    def pop(self) -> int:
        while self.s1:
            self.s2.append(self.s1.pop())

        popped = self.s2.pop()

        while self.s2:
            self.s1.append(self.s2.pop())
        return popped

    def peek(self) -> int:
        return self.s1[0]

    def empty(self) -> bool:
        print(self.s1)
        return len(self.s1) == 0
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()
