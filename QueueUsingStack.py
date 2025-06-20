# Time Complexity : on an Avg O(1) due to amortized analysis
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes

class MyQueue(object):

    def __init__(self):
        self.InStack = []
        self.OutStack = []  

    def push(self, x):
        self.InStack.append(x)
        
    def pop(self):
        self.peek()
        return self.OutStack.pop()
    
    def peek(self):
        if len(self.OutStack) == 0 and len(self.InStack) != 0:
            while self.InStack:
                self.OutStack.append(self.InStack.pop())
            return self.OutStack[-1]
        return self.OutStack[-1]

    def empty(self):
        if len(self.InStack) == 0 and len(self.OutStack) == 0:
            return True
        return False

obj = MyQueue()
obj.push(1)
obj.push(2)
output1 = obj.peek()
print(output1)
output2 = obj.pop()
print(output2)
output3 = obj.empty()
print(output3)