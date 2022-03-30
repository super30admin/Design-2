# Time Complexity :
# Space Complexity :
# Did this code successfully run on Leetcode :
# Any problem you faced while coding this :


# Your code here along with comments explaining your approach

class MinStack:

    def __init__(self):
        self.stack = []
        self.minVal = math.inf
        self.minStack = [self.minVal]

    def push(self, val: int) -> None:
        if val < self.minVal:
            self.minVal = val
        self.stack += [val]
        self.minStack += [self.minVal]

    def pop(self) -> None:
        if not self.stack:
            return
        self.stack.pop()
        self.minStack.pop()
        self.minVal = self.minStack[-1]
        
    def top(self) -> int:
        return self.stack[-1]
           
    def getMin(self) -> int:
        return self.minVal