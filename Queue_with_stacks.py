# Time Complexity : O(1)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach:
# I have used 2 stacks one for pushing all the values. And as soon
# as there is a pop we move everything to the 2nd stack and pop from the 2nd stack.
# So basically we push to stack 1 and pop from stack 2. 

class MyQueue:
    def __init__(self):
        self.stack1 = []
        self.stack2 = []

    def push(self, x):
        self.stack1.append(x)

    def pop(self):
        if len(self.stack2)!=0:
            return self.stack2.pop()
        else:
            while len(self.stack1)!=0:
                self.stack2.append(self.stack1.pop())
            return self.stack2.pop()

    def peek(self):
        if len(self.stack2)!=0:
            return self.stack2[-1]
        else:
            while len(self.stack1)!=0:
                self.stack2.append(self.stack1.pop())
            return self.stack2[-1]

    def empty(self):
        if len(self.stack1)==0 and len(self.stack2)==0:
            return True
        else:
            return False
