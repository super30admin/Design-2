# // Time Complexity : O(1)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : no


# // Your code here along with comments explaining your approach
# As the question states, we use two stacks and a front integer to store the leftmost element of the queue.
# PUSH: update the `front` variable if the first stack is empty, append the new item onto first stack
# POP: if the secondary stack is empty, append the values of the first stack to it, and thus reversing the order of the first stack. return the last element from the secondary stack
# PEEK: return the last element of the secondary stack if not empty, else return the front variable
# EMPTY: checks both the stacks 



class MyQueue:

    def __init__(self):
        self.stack_primary = []
        self.stack_secondary = []

    def push(self, x: int) -> None:
        if not self.stack_primary:
            self.front = x
        self.stack_primary.append(x) 

    def pop(self) -> int:
        if not self.stack_secondary:
            while self.stack_primary:
                self.stack_secondary.append(self.stack_primary.pop())
        return self.stack_secondary.pop()
        

    def peek(self) -> int:
        if self.stack_secondary:
            return self.stack_secondary[-1]
        return self.front

    def empty(self) -> bool:
        return not self.stack_primary and not self.stack_secondary
