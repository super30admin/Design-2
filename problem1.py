class MyQueue():
    def __init__(self):
        self.stack1 = []
        self.stack2 = []

    def push(self, x):
        self.stack1.append(x)

    def pop(self):
        self.peek()
        return self.stack2.pop()
	
    def peek(self):
        if len(self.stack2)==0:
            while self.stack1:
                self.stack2.append(self.stack1.pop())
        return self.stack2[-1]
	
    def empty(self):
        return not self.stack1 and not self.stack2
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()