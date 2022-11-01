# Time Complexity: O(1) for push, O(1) for empty
#                  For peek and pop: O(1) average case, O(N) worst case(when out stack is empty and we need to copy elements)
# Space Complexity: O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class MyQueue:

    def __init__(self):
        self.in_stack = list()
        self.out_stack = list()

    def push(self, x: int) -> None:
        self.in_stack.append(x)

    def pop(self) -> int:
        self.peek()
        return self.out_stack.pop()

    def peek(self) -> int:
        if len(self.out_stack) == 0:
            while self.in_stack:
                self.out_stack.append(self.in_stack.pop())
        return self.out_stack[-1]

    def empty(self) -> bool:
        return not (self.in_stack or self.out_stack)



# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()