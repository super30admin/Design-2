# // Time Complexity : O(1)
# // Space Complexity : O(N)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach
'''Two stacks have been taken
we insert the elements in inStack and transfer into outStack
whenever the pop function is called '''

#Problem1: Implement Queue using two stacks:

class MyQueue:

    def __init__(self):
        self.inStack = []
        self.outStack = []
        

    def push(self, x: int) -> None:
        self.inStack.append(x)
        
        

    def pop(self) -> int:
        if len(self.outStack) == 0:
            if len(self.inStack) == 0:
                return "No elements found"
            while len(self.inStack) > 0:
                poppedItem = self.inStack.pop()
                self.outStack.append(poppedItem)
        return self.outStack.pop()
        

    def peek(self) -> int:
        if len(self.outStack) == 0:
            if len(self.inStack) == 0:
                return "No elements found"
            while len(self.inStack) >0:
                poppedItem = self.inStack.pop()
                self.outStack.append(poppedItem)
        return self.outStack.pop()
        
        

    def empty(self) -> bool:
        if (len(self.inStack) == 0 & len(self.outStack) == 0):
            return True
        else:
            return False