## Problem 1: (https://leetcode.com/problems/implement-queue-using-stacks/)

# Time Complexity : Perfect O(1) for push() and empty() functions. Amortized O(1) for pop() and peek() functions, worst case it would be O(N) for pop() and peek().
# For design problems we consider Amortized Time Complexity
# Space Complexity : O(N) -- O(Number of elements added)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach
# Maintain two stacks: INStack and OUTStack. Whenever we push an element we add it to the INStack.
# When we need to pop() or peek(), we first check if elements are there in OUTStack. If it is empty there we pop elements from INStack
# push into OUTStack and give the top of the stack element. If OUTStack is not empty then we give the top of the stack element of OUTStack


class MyQueue(object):

    def __init__(self):
        self.inStack = []
        self.outStack = []
        

    def push(self, x):
        """
        :type x: int
        :rtype: None
        """
        self.inStack.append(x)
        

    def pop(self):
        """
        :rtype: int
        """
        # if operations are valid no need for extra check
        self.peek()
        return self.outStack.pop()
        

    def peek(self):
        """
        :rtype: int
        """
        if(not self.outStack):
            while(self.inStack):
                self.outStack.append(self.inStack.pop())            

        return self.outStack[-1]
        

    def empty(self):
        """
        :rtype: bool
        """
        isEmpty = False
        if((not self.inStack) and (not self.outStack)):
            isEmpty = True

        return isEmpty



myQueue = MyQueue()
print(myQueue.empty())
myQueue.push(1)
myQueue.push(2)
print(myQueue.peek())
print(myQueue.pop())
print(myQueue.empty())
print(myQueue.peek())