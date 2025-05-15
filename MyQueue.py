class MyQueue:
    # Did this code successfully run on Leetcode :Yes

    def __init__(self):
        self.s1 = []
        self.s2 = []
        

    def push(self, x: int) -> None: # o(1)
        
        self.s1.append(x)

    def pop(self) -> int: # Amortized o(1)
        if len(self.s2)==0:
            while self.s1:
                self.s2.append(self.s1.pop())
        return self.s2.pop()

    def peek(self) -> int: #o(1)
        if len(self.s2)==0:
            while self.s1:
                self.s2.append(self.s1.pop())
        return self.s2[-1]

    def empty(self) -> bool: #o(1)
        return len(self.s1)==0 and len(self.s2)==0
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()