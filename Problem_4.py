# Time Complexity : POP Operation : Worst Case: O(n), Other operations : O(1)
# Space Complexity : O(n)

class Stack:
    def __init__(self):
        self.stack = []

    def push(self, x):
        self.stack.append(x)
        return

    def pop(self):
        if self.stack:
            return self.stack.pop()
        return

    def peek(self):
        if self.stack:
            return self.stack[-1]

    def size(self):
        return len(self.stack)
    
    def is_empty(self):
        return self.stack == []

class MyQueue:

    def __init__(self):
        self.stack1 = Stack()
        self.stack2 = Stack()
        self.first_elem = math.inf

    def push(self, x: int) -> None:
        if self.stack1.is_empty():
            self.first_elem = x
        self.stack1.push(x)

    def pop(self) -> int:
        if self.stack2.is_empty():
            while self.stack1.is_empty() == False:
                self.stack2.push(self.stack1.pop())
        return self.stack2.pop()

    def peek(self) -> int:
        if self.stack2.is_empty() == False:
            return self.stack2.peek()
        return self.first_elem

    def empty(self) -> bool:
        return self.stack1.is_empty() and self.stack2.is_empty()


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()