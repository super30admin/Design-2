class MyQueue:

    def __init__(self):
        self.first_stack = []
        self.second_stack = []
        

    def push(self, x: int) -> None:
        self.first_stack.append(x)

    def pop(self) -> int:
        self.peek()
        return self.second_stack.pop()

    def peek(self) -> int:
        if not self.second_stack:
            while self.first_stack:
                self.second_stack.append(self.first_stack.pop())

        return self.second_stack[-1]
        

    def empty(self) -> bool:
        return not self.first_stack and not self.second_stack
