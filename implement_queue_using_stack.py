# // Time Complexity : O(1)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : Less issues than before.


# // Your code here along with comments explaining your approach
''' 
This approach initializes the two stacks inStack and outStack. Basically, new elements are always pushed into instack. and when elements are to be popped. it checks and outstack and finding it empty, 
adds the instack elements to outstack.
'''

class MyQueue:

    def __init__(self):
        self.inSt = []
        self.outSt = []

   #adds new elements to instack
    def push(self, x: int) -> None:
        self.inSt.append(x)

    #moves elements into outstack if empty
    def pop(self) -> int:
        if len(self.outSt) == 0:
            while self.inSt:
                self.outSt.append(self.inSt.pop())
        return self.outSt.pop()

    #return the top of outstack
    def peek(self) -> int:
        if len(self.outSt) == 0:
            while self.inSt:
                self.outSt.append(self.inSt.pop())
        return self.outSt[-1]
    #Checks if both the stacks are empty
    def empty(self) -> bool:
        if len(self.inSt) == 0 and len(self.outSt) == 0:
            return True
        return False


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()
