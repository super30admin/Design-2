class queueStack:

    def __init__(self):
        self.stack1 = []
        self.stack2 = []

    def push(self, data):
        self.stack1.append(data)

    def pop(self):
        if (self.stack2):
            return self.stack2.pop()
        else:
         while (self.stack1):
            self.stack2.append(self.stack1.pop())
            
        return self.stack2.pop()


queueStack = queueStack()
queueStack.push(1)
queueStack.push(2)
queueStack.pop()
queueStack.push(3)
res = queueStack.pop()
print(res)






