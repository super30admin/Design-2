class MyQueue:

    def __init__(self):
        self.stack_left = []
        self.stack_right = []

    def push(self, x: int) -> None:
        self.stack_left.append(x)

    def update_stack(self):
        if len(self.stack_right) == 0:
            left_size = len(self.stack_left)
            for i in range(left_size):
                self.stack_right.append(self.stack_left.pop())

    def pop(self) -> int:
        self.update_stack()
        return self.stack_right.pop()

    def peek(self) -> int:
        self.update_stack()
        return self.stack_right[-1]

    def empty(self) -> bool:
        return len(self.stack_right) == 0 and len(self.stack_left) == 0

# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()
