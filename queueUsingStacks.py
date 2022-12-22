# Exercise_1: Implement Queue using Stacks
# Time Complextiy: O(1) for push, O(N) for pop and peek, O(1) for empty, where N is the number of elements in the stack
# Space Complexity: O(N), where N is the number of elements in the stack
# Successful Run on Leetcode: Yes (https://leetcode.com/problems/implement-queue-using-stacks/)
# Challenges: None

# Coding Approach:
# Two stacks are used to implement a queue. 
# Push: Push the element to stack1
# Pop: If stack2 is empty, pop all elements from stack1 and push to stack2. Then pop from stack2.
# Peek: If stack2 is empty, pop all elements from stack1 and push to stack2. Then peek from stack2.
# Empty: Check if both stacks are empty.

class MyQueue:

    def __init__(self):
        self.stack1 = []
        self.stack2 = []
        
    def push(self, x: int) -> None:
        self.stack1.append(x)

    def pop(self) -> int:
        if len(self.stack2) == 0:
            while len(self.stack1) != 0:
                self.stack2.append(self.stack1.pop())
        return self.stack2.pop()

    def peek(self) -> int:
        if len(self.stack2) == 0:
            while len(self.stack1) != 0:
                self.stack2.append(self.stack1.pop())
        return self.stack2[-1]
        
    def empty(self) -> bool:
        return len(self.stack1) == 0 and len(self.stack2) == 0