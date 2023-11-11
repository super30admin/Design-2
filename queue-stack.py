# Time Complexity is amortized O(1). Space complexity is O(n).

class MyQueue:

    def __init__(self):
        self.stack1 = []                    # Initialize main empty stack
        self.stack2 = []                    # Initialize a second empty stack


    def push(self, x: int) -> None:
        while self.stack1:
            self.stack2.append(self.stack1.pop())   # If stack1 is not empty, move the values from stack1 to stack2 
        self.stack1.append(x)                       # Append new value 'x' now to empty stack1

        while self.stack2:                      
            self.stack1.append(self.stack2.pop())   # If stack2 is not empty, move the values back from stack2 to stack1 on top of the added x element to ensure FIFO property is maintained.

    def pop(self) -> int:
        return self.stack1.pop()
        

    def peek(self) -> int:
        return self.stack1[-1]
        

    def empty(self) -> bool:
        return not self.stack1

# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()