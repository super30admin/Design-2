"""
Que is FIFO to implement this using stack means we can use two stacks
when value is pushed it goes first stack
when pop happens and the second stack is empty 
we pop all elements from the first stack to second stack so that everything will revered so we can achieve FIFO type operations
if second stack is not empty we simply pop from there

same applies to peek but we return the last element in the second stack
Time Complexity : O(1)
Space : O(n)
"""

class MyQueue:

    def __init__(self):
        self.in_stack = []
        self.out_stack = []

    def push(self, x: int) -> None:
        self.in_stack.append(x)

    def pop(self) -> int:

        if self.out_stack:
            return self.out_stack.pop()

        while self.in_stack:
            self.out_stack.append(self.in_stack.pop())

        return self.out_stack.pop()

    def peek(self) -> int:

        if self.out_stack:
            return self.out_stack[-1]

        while self.in_stack:
            self.out_stack.append(self.in_stack.pop())

        print(self.out_stack)
        return self.out_stack[-1]

    def empty(self) -> bool:

        if not self.in_stack and not self.out_stack:
            return True
        return False


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()
