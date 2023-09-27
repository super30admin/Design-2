# Time Complexity : O(N)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
import collections

class MyQueue:

    def __init__(self):
        self.stack = collections.deque([])

    def push(self, x: int) -> None:
        self.stack.append(x)

    def pop(self) -> int:
        return self.stack.popleft() if self.stack else -1

    def peek(self) -> int:
        return self.stack[0] if self.stack else -1

    def empty(self) -> bool:
        return True if len(self.stack) == 0 else False


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()