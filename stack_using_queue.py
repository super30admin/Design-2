"""
Time Complexity:
For push, O(1)
For pop and peek, O(n) where n is number of elements in stack1. We have made the pop operation
an expensive operation.
"""


class MyQueue:

    def __init__(self):
        self.stack1 = []
        self.stack2 = []

    @staticmethod
    def helper_pop_push(source, dest):
        while source:
            dest.append(source.pop())

    def push(self, x: int) -> None:
        self.stack1.append(x)

    def pop(self) -> int:
        self.helper_pop_push(self.stack1, self.stack2)
        popped = self.stack2.pop()
        self.helper_pop_push(self.stack2, self.stack1)
        return popped

    def peek(self) -> int:
        self.helper_pop_push(self.stack1, self.stack2)
        peeked = self.stack2[-1]
        self.helper_pop_push(self.stack2, self.stack1)
        return peeked

    def empty(self) -> bool:
        return len(self.stack1) == 0

# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()
