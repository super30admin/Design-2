#Time Complexity for push operation: O(1)
#Time Complexity for pop operation: O(1)
#Notes: - Using two stacks to implement a Queue. 
#To perform the pop operation check if the out stack is empty if it is then transfer the elements from in stack to out stack and pop the top most element

class MyQueue:
    def __init__(self):
        self.in_stack = []
        self.out_stack = []

    def push(self, x: int) -> None:
        self.in_stack.append(x)

    def pop(self) -> int:
        self.peek()
        return self.out_stack.pop()

    def peek(self) -> int:
        # out_stack gives us peek
        if not self.out_stack:
            while self.in_stack:
                self.out_stack.append(self.in_stack.pop()) #to get values in reverse order
        return self.out_stack[-1]

    def empty(self) -> bool:
        return not self.in_stack and not self.out_stack

# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()
