''' 
Time Complexity : O(1)
Space Complexity : O(n) 
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this :  No
'''

class MyQueue:

    def __init__(self):
        self.in_stack = []
        self.out_stack = []
        self.size = 0

    def push(self, x: int) -> None:
        self.size += 1
        self.in_stack.append(x)

    def pop(self) -> int:
        if not self.out_stack:
            while self.in_stack:
                self.out_stack.append(self.in_stack.pop())

        self.size -= 1
        return self.out_stack.pop()

    def peek(self) -> int:
        if not self.out_stack:
            while self.in_stack:
                self.out_stack.append(self.in_stack.pop())

        return self.out_stack[-1]

    def empty(self) -> bool:
        return self.size == 0
