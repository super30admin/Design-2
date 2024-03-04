"""
Approach: As queues work as First In First Out(FIFO), we have two use two stacks as first one taking all the elements in and other one for when we need to pop out any 
element, so the flow of it will be like when we have to add we will keep adding to the first one until there will be command to pop, we will transfer all the elements
from InStack to OutStack one by one, so that my top element in InStack will go into the bottom of my OutStack and when we need to pop we will pop it from the OutStack
and same with peek. and for empty we will check if both the stack are empty we will return true otherwise false.

Time Complexity: O(1)
Space Complexity: O(1)

Returns:
    pop : int (top element from OutStack)
    peek : int (top top element from OutStack)
    empty : boolean (checking both stacks)
"""


class MyQueue:

    def __init__(self):
        self.inStack = []
        self.outStack = []        

    def push(self, x: int) -> None:
        self.inStack.append(x)

    def pop(self) -> int:
        if not self.outStack:
            while(self.inStack):
                self.outStack.append(self.inStack.pop())
        return self.outStack.pop()

    def peek(self) -> int:
        if not self.outStack:
            while(self.inStack):
                self.outStack.append(self.inStack.pop())
        return self.outStack[-1]
        

    def empty(self) -> bool:
       return len(self.inStack) == 0 and len(self.outStack) == 0
            


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()