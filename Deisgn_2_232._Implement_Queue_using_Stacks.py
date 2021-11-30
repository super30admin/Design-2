class MyQueue:
    """
    Approach: 
    1. Declare two stacks
    2. push the element to the in stack whenever push is called
    3. As it is a queue pop should return the First element inserted. First element is              stored in the bootom of the stack, pop all the elements in the in stack to out_stack,        provided out_stack is empty and pop the peek element of out stack.
    4. The same logic as of pop is applied to peek
    5. Queue will be considered as empty if both the stacks are empty
    
    Note: Standard stack operactions can be used
    
    Time Complexity: O(1)
    Space Complexity: amortized O(1)
    """
    from collections import deque
    def __init__(self):
        self.in_stack = deque()
        self.out_stack = deque()
        
    def push(self, x):
        self.in_stack.append(x)

    def pop(self):
        if len(self.out_stack) == 0:
            while (len(self.in_stack) > 0):
                self.out_stack.append(self.in_stack.pop())
        return self.out_stack.pop()

    def peek(self):
        if len(self.out_stack) == 0:
            while (len(self.in_stack) > 0):
                self.out_stack.append(self.in_stack.pop())
        if self.out_stack:
            return self.out_stack[-1]
    
    def empty(self) -> bool:
        return not self.in_stack and not self.out_stack

queue = MyQueue()
queue.push()