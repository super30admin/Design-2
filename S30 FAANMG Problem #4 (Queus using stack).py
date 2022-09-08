# Time Complexity : O(1)

class MyQueue:

    def __init__(self):
        self.instack = []
        self.outstack = []

    def push(self, x):
        self.instack.append(x)

    def pop(self):
        self.peek()
        return self.outstack.pop()

    def peek(self):
        if len(self.outstack) == 0:
            while len(self.instack) != 0:
                self.outstack.append(self.instack.pop())
        return self.outstack[-1]

    def empty(self):
        if len(self.instack) == 0 and len(self.outstack) == 0:
            return True
        else:
            return False
        
# Your MyQueue object will be instackntiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()