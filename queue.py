# Time: O(1) except push operation (O(n))
# Space: O(n)
# Executed successfully on Leetcode (after the class session)
# No challenges faced

from collections import deque
class MyQueue:

    def __init__(self):
        self.queue = deque()
        

    def push(self, x: int) -> None:
        self.queue.appendleft(x)
        

    def pop(self) -> int:
        return self.queue.pop()
        

    def peek(self) -> int:
        return self.queue[-1]
        

    def empty(self) -> bool:
        return len(self.queue) == 0
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()