# Explain your approach in three sentences only.
# We use two stacks: `in_stack` for enqueue operations and `out_stack` for dequeue operations.
# When popping or peeking, we transfer elements from `in_stack` to `out_stack` only if `out_stack` is empty.
# This ensures efficient O(1) amortized time complexity for all operations.
# The space complexity of this queue implementation using two stacks is O(n).

class MyQueue:

    def __init__(self):
        self.in_stack = []
        self.out_stack = []

    def push(self, x: int) -> None:
        self.in_stack.append(x)

    def pop(self) -> int:
        self._move()
        return self.out_stack.pop()

    def peek(self) -> int:
        self._move()
        return self.out_stack[-1]

    def empty(self) -> bool:
        return not self.in_stack and not self.out_stack

    def _move(self):
        """ Move elements from in_stack to out_stack if out_stack is empty """
        if not self.out_stack:
            while self.in_stack:
                self.out_stack.append(self.in_stack.pop())

# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()
