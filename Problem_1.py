# Time complexity - O(1) for each operations O(n) in worst case while popping and peeking
# Space Complexity - O(1) for each operation and O(n) for initializing and pushing the element to both stacks
# Approach - I have used two stacks in_stack and out_stack, for push function I simply append my in_stack
# for pop or peek function I check if my out_stack is empty if it is then I pop from in_stack and append to out_stack
# till in_stack is empty due to this process my out_stack is in reverse order of in_stack hence, when I do pop on
# out_stack, I get the first element which I pushed on in_stack.
# This code ran successfully on Leetcode

class MyQueue:
    def __init__(self):
        self.in_stack = []
        self.out_stack = []

    def push(self, x: int):
        self.in_stack.append(x)
    
    def pop(self):
        if self.out_stack:
            return self.out_stack.pop()
        while self.in_stack:
            self.out_stack.append(self.in_stack.pop())
        return self.out_stack.pop()

    def peek(self):
        if self.out_stack:
            return self.out_stack[-1]
        while self.in_stack:
            self.out_stack.append(self.in_stack.pop())
        return self.out_stack[-1]

    def empty(self):
        if self.in_stack and self.out_stack:
            return False
        if self.in_stack:
            return False
        if self.out_stack:
            return False
        return True

q = MyQueue()
q.push(10)
q.push(20)
q.push(30)
q.push(40)
q.push(50)
q.push(60)
print(q.peek())
print(q.pop())
print(q.peek())
print(q.empty())
