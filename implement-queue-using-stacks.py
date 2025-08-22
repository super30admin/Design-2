# Time Complexity : Amortized O(1)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : handling the empty() edge case


# Your code here along with comments explaining your approach
# Use two stacks:
# - inSt  : collects incoming elements on push (right end is the top)
# - outSt : serves elements for pop/peek in queue order
# Lazy transfer: only when outSt is empty do we pour all items from inSt to outSt,
# reversing their order so the oldest element ends up on top of outSt.

class MyQueue:

    def __init__(self):
        self.inSt = [] # stack for incoming pushes
        self.outSt = [] # stack for outgoing pops/peeks

    def push(self, x: int) -> None:
        # Always push to inSt
        self.inSt.append(x)

    def pop(self) -> int:
        # If queue is empty, return -1
        if self.empty():
            return -1
        # Ensure outSt has the current front on top
        self.peek()
        # Pop from outSt gives FIFO behavior
        return self.outSt.pop(-1)

    def peek(self) -> int:
        # If outSt is empty, move everything from inSt to outSt exactly once per element.
        # This reverses order so the oldest element is at the top of outSt.
        if not self.outSt:
            while self.inSt:
                self.outSt.append(self.inSt.pop())
                # The top of outSt is the queue front
        return self.outSt[-1]

    def empty(self) -> bool:
        # Queue is empty only if both stacks are empty
        return not self.inSt and not self.outSt

# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()