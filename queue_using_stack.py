class MyQueue:

    def __init__(self):
        self.stack = []
        self.q = []

    def push(self, x: int) -> None:
        # complexity O(1)
        self.stack.append(x)

    def pop(self) -> int:
        # complexity avg O(1)
        if not self.q:
            while self.stack:
                self.q.append(self.stack.pop())
        return self.q.pop()
            

    def peek(self) -> int:
        # complexity avg O(1)
        if not self.q:
            while self.stack:
                self.q.append(self.stack.pop())
        return self.q[-1]
        

    def empty(self) -> bool:
        # complexity O(1)
        if not self.stack and not self.q:
            return True
        return False
        
        
# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()