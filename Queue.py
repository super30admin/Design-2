'''Approach:
Initialize the inStack and outStack. Any push operation is appended to inStack.
For peek and pop operation, first check the outStack, if the outStack is not empty
return top element of the outStack or pop the top element.
Else, move all the elements from inStack to outStack and do the pop or peek accordingly on
outStack.
'''

#Time Complexity : O(1) - push, empty amortized O(1) - peek, pop
#Space Complexity : O(1)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No


class MyQueue:

    def __init__(self):
        self.inStack = []
        self.outStack = []

    def push(self, x: int) -> None:
        self.inStack.append(x)

    def pop(self) -> int:
        val = self.peek()
        popped = self.outStack.pop()
        return popped

    def peek(self) -> int:
        if not self.outStack:
            while self.inStack:
                self.outStack.append(self.inStack.pop())

        return self.outStack[-1]

    def empty(self) -> bool:
        if not self.inStack and not self.outStack:
            return True
        else:
            return False

# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()