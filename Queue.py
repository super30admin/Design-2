#I am using 2 stacks to implement the working of queue. first stack is used to push a new element.
#stack2 act as a buffer which is used when a pop or peek operation to be performed
# Time complexity is O(n)
# class MyQueue:

#     def __init__(self):
#         self.stack1 = []
#         self.stack2 = []
        

#     def push(self, x: int) -> None:
#         while self.stack2:
#             self.stack1.append(self.stack2.pop())
#         self.stack1.append(x)
        
#     def pop(self) -> int:
#         while self.stack1:
#             self.stack2.append(self.stack1.pop())
#         return self.stack2.pop()

#     def peek(self) -> int:
#         while self.stack1:
#             self.stack2.append(self.stack1.pop())
#         return self.stack2[-1]
        
#     def empty(self) -> bool:
#         if self.stack1 == [] and self.stack2 == []:
#             return True
#         return False
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()

#in my first approach the time complexity is O(n) but in the new approach the time complexity of push is O(1)
#for pop and peek it is O(1) which is amortized
class MyQueue:

    def __init__(self):
        self.inStack = []
        self.outStack = []

    def push(self, x: int) -> None:
        self.inStack.append(x)
        
    def pop(self) -> int:
        if self.outStack:
            return self.outStack.pop()
        while self.inStack:
            self.outStack.append(self.inStack.pop())
        return self.outStack.pop()

    def peek(self) -> int:
        if self.outStack:
            return self.outStack[-1]
        while self.inStack:
            self.outStack.append(self.inStack.pop())
        return self.outStack[-1]
        
    def empty(self) -> bool:
        if self.inStack == [] and self.outStack == []:
            return True
        return False