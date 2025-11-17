'''
For designing a Queue using stack, we initialize 2 stacks
push: we push elements into inStack for every push operation
pop: we pop elements from both the stacks, first we pop all the elemnts one after other from inStack to outStack,
     from outStack we only pop the top most value
empty: we return true if only both the stacks are empty
'''

class MyQueue:

    # we define 2 stacks
    def __init__(self):
        self.inStack = []
        self.outStack = []
        
    # we add the push values to inStack
    def push(self, x: int) -> None:
        self.inStack.append(x)
        
    # popping from both the stacks to pop the first elemt
    def pop(self) -> int:
        if not self.outStack:
            while self.inStack:
                self.outStack.append(self.inStack.pop())
        # self.peek()
        return self.outStack.pop()    

    # first element from the outStack
    def peek(self) -> int:
        if not self.outStack:
            while self.inStack:
                self.outStack.append(self.inStack.pop())
        return self.outStack[-1]    
    
    # to check if both the stacks are empty and return true
    def empty(self) -> bool:
        return not self.inStack and not self.outStack

'''
Time Complexity: O(1)
Space Complexity: O(1)
'''
