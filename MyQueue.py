# Time Complexity : O(1)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None

class MyQueue:

    def __init__(self):
        self.inStack = []
        self.outStack = []

    def push(self, x: int) -> None:
        self.inStack.append(x)

    def pop(self) -> int:
        if len(self.outStack) == 0:
            while self.inStack:
                self.outStack.append(self.inStack.pop())
        return self.outStack.pop()  

    def peek(self) -> int:
        if len(self.outStack) == 0:
            while self.inStack:
                self.outStack.append(self.inStack.pop())
        return self.outStack[-1]
        

    def empty(self) -> bool:
        if len(self.inStack) == 0 and len(self.outStack) == 0:
            return True
        return False
  


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()