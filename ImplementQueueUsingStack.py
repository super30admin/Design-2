# Time Complexity :O(1)
# Space Complexity :O(N) where N is the number of elements
# Did this code successfully run on Leetcode : Yes.
# Any problem you faced while coding this : rememberd the not functionality is better and neat
# instead of self.inStack == Null

# Your code here along with comments explaining your approach
class MyQueue:
    def __init__(self):
        self.inStack = []
        self.outStack = []

    def push(self, x):
        self.inStack.append(x)

    def pop(self):
        self.peek()
        return self.outStack.pop()

    def peek(self):
        if not self.outStack:
            while self.inStack:
                self.outStack.append(self.inStack.pop())
        return self.outStack[-1]

    def empty(self):
        return not self.inStack and not self.outStack

# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()
