"""
I used two stacks to implement a queue. The first stack stores all the elements during the push operation, and when I need to pop or peek, 
I transfer elements to the second stack to reverse their order. This way, the first inserted element comes out first, just like in a normal queue.
Time Complexity: Amortized O(1) for worst case it would be O(n) for transferring the elements
Space Complexity: O(n)
"""
class MyQueue:

    def __init__(self):
        self.stack1 = []
        self.stack2 = []
        
    def push(self, x: int) -> None:
        self.stack1.append(x)
        
    def pop(self) -> int:
        if not self.stack2:
            while self.stack1:
                self.stack2.append(self.stack1.pop())
        return self.stack2.pop()

    def peek(self) -> int:
        if not self.stack2:
            while self.stack1:
                self.stack2.append(self.stack1.pop())
        return self.stack2[-1]

    def empty(self) -> bool:
        return not self.stack1 and not self.stack2
        

# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()