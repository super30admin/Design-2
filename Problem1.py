#Time Complexity :O(1)
#Space Complexity :O(n)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No
#Your code here along with comments explaining your approach: Using 2 stacks, one for pushing the elements- InStack and one for poping the elements- OutStack

class MyQueue:

    def __init__(self):
        self.inStack=[]
        self.outStack=[]

    def push(self, x: int) -> None:
        self.inStack.append(x)

    def pop(self) -> int:
        self.peek()
        return self.outStack.pop()

    def peek(self) -> int:
        #check if stack is empty then pop elements from inStack to outStack
        if not self.outStack: 
            while len(self.inStack)>0 :
                self.outStack.append(self.inStack.pop())
            return self.outStack[-1] 

    def empty(self) -> bool:
        if not self.outStack and not self.inStack :
            return True
        else:
            return False


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()