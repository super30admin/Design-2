# Time Complexity : O(1)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No



class MyQueue:

    def __init__(self):
        # initialize two stacks one for input and outstack for handling pop and peek operation
        self.inStack = []
        self.outStack = []

    def push(self, x: int) -> None:
        # add a new element in instack
        self.inStack.append(x)

    def pop(self) -> int:
        # perform peek operation and pop top element of outStack 
        self.peek()
        return self.outStack.pop()

    def peek(self) -> int:
        # peek will irst heck if the outstack is not empty. If emty it will return -1 else pop and peek an element from inStack to outStack 
        if not self.outStack:
            while self.inStack:
                self.outStack.append(self.inStack.pop())
        return self.outStack[-1]

    def empty(self) -> bool:
        # return bool based on elements in both the stacks
        return not self.inStack and not self.outStack


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()