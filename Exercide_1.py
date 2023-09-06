# ## Problem 1: (https://leetcode.com/problems/implement-queue-using-stacks/)

# // Time Complexity : O(1)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this :No


# // Your code here along with comments explaining your approach

class MyQueue:

    def __init__(self):
        # creating two stacks in
        self.in_stack = []
        # and out
        self.out_stack = []
        # creating a size variable
        self.size = 0

    def push(self, x):
        # appending x
        self.in_stack.append(x)
        # adjusting size coz pushed
        self.size += 1

    def pop(self):
        self.peek()
        # adjusting size coz popped
        self.size -= 1
        return self.out_stack.pop()

    def peek(self):
        # filling elements in out_stack from in_stack if not present
        if not self.out_stack:
            while self.in_stack:
                self.out_stack.append(self.in_stack.pop())
        return self.out_stack[-1]

    def empty(self):
        if self.in_stack or self.out_stack:
            return False
        return True
