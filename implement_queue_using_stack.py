# Time Complexity: O(1)
# Space Complexity: O (n)
# Did this code successfully run on Leetcode: ✔️
# Any problem you faced while coding this:

class MyQueue:

    def __init__(self):
        self.stack = []

    def push(self, x: int) -> None:
        self.stack.append(x)

    def pop(self) -> int:
        pop = self.stack[0]
        self.stack = self.stack[1:len(self.stack)]
        return pop

    def peek(self) -> int:
        return self.stack[0]

    def empty(self) -> bool:
        return len(self.stack) == 0

# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()