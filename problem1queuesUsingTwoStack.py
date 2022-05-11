'''
Leet Code : https://leetcode.com/problems/implement-queue-using-stacks/
'''

class MyQueue:

    def __init__(self):
        
        self.pushStack = []
        self.popStack = []

    def push(self, x: int) -> None:
    
        # Simply append the elements to pushStack
        self.pushStack.append(x)
        
    def pop(self) -> int:
        
        # To pop first call the peek function
        self.peek()
        
        # Delete the element from the top of popStack
        return self.popStack.pop()
       
    def peek(self) -> int:
        
        # We have to return the last index of the pop stack
        # Before that we need to check if the popStack is empty
        # If empty, add all the elements to the popStack. This avtivity will be performed only if the popStack is empty. So 0(n)
        # For most cases we will return the last index of popStack. So 0(1)
        
        if len(self.popStack) == 0:
            # Iterate the pushStack; pop the elements from the pushStack and append it to the popStack
            while len(self.pushStack)>0:
                self.popStack.append(self.pushStack.pop())
                continue
        
        return self.popStack[-1]
    

    def empty(self) -> bool:
      
        if len(self.pushStack)==0 and len(self.popStack)==0:
            return True
        
        return False

# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()