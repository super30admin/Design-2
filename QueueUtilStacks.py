# Time Complexity : O(1)
# Space Complexity : Worst Case, O(self.bucketNum * self.bucketNum)
# Did this code successfully run on Leetcode : Yes!
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
class MyQueue(object):

    def __init__(self):
        self.inStack = []
        self.outStack = []

    def push(self, x):
        self.inStack.append(x)

    def pop(self):
        self.peek()
        return self.outStack.pop()

    def peek(self):
        if len(self.outStack) == 0:
            while len(self.inStack) != 0:
                self.outStack.append(self.inStack.pop())
        return self.outStack[len(self.outStack)-1]


    def empty(self):
        return len(self.inStack) == 0 and len(self.outStack) == 0

# Your MyQueue object will be instantiated and called as such:
obj = MyQueue()
obj.push(1)
obj.push(2)
print obj.pop()
print obj.peek()
print obj.empty()
