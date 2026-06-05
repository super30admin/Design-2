# Problem: Implement Queue using Stacks
# Time Complexity: 
#   push: O(1) - always
#   pop: O(1) amortized - O(n) only when outStack is empty, but each element moved once in its lifetime
#   peek: O(1) amortized - same reasoning as pop
#   empty: O(1) - always
# Space Complexity: O(n) where n is number of elements in the queue
# Did this code successfully run on Leetcode: YES
# Any problem you faced while coding this: No




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
           while len(self.inStack) > 0:
               self.outStack.append(self.inStack.pop())
        return self.outStack[-1]

    def empty(self):
        return len(self.inStack) == 0 and len(self.outStack) == 0


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()