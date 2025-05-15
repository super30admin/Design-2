# Create a input stack and an output stack to implement a queue using two stacks.
# Helper transfer function to move elements from input stack to output stack when needed.
# The push operation is O(1) because we just append to the input stack.
# Time Complecity: O(1) for push, O(n) for pop and peek
# Space Complecity: O(n) for the two stacks

class MyQueue:

    def __init__(self):
        self.stack_in = []
        self.stack_out = []

    def push(self, x: int) -> None:
        self.stack_in.append(x)

    def pop(self) -> int:
        self.transfer()
        return self.stack_out.pop()

    def peek(self) -> int:
        self.transfer()
        return self.stack_out[-1]

    def empty(self) -> bool:
        return not self.stack_in and not self.stack_out

    def transfer(self):
        if not self.stack_out:
            while self.stack_in:
                self.stack_out.append(self.stack_in.pop())


# Your MyQueue object will be instantiated and called as such:
obj = MyQueue()
obj.push(1)
obj.push(2)
obj.push(3)
param_2 = obj.pop()
param_3 = obj.peek()
param_4 = obj.empty()
print(param_2)
print(param_3)
print(param_4)