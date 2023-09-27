// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Stack not present in native language, so had to use array functions.


// Your code here along with comments explaining your approach
class MyQueue:

    def __init__(self):
        self.in_stack  = []
        self.out_stack = []

    def push(self, x: int) -> None:
        self.in_stack.append(x)

    def pop(self) -> int:
        self.peek()
        return self.out_stack.pop()
        

    def peek(self) -> int:
        if not self.out_stack:
            while self.in_stack:
                self.out_stack.append(self.in_stack.pop())
        return self.out_stack[-1]

    def empty(self) -> bool:
        if len(self.in_stack)==0 and len(self.out_stack)==0:
            return True
        return False
